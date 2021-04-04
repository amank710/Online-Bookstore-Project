package model;

import exceptions.InvalidAmountException;
import exceptions.NegativeQuantityException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//Represents the Shopping Cart of the customer
public class Cart implements Writable {

    private static ArrayList<Book> booksInCart;

    //EFFECTS: Initialises the ArrayList booksInCart which contains all the books that have been
    //         added to the cart already
    public Cart() {
        booksInCart = new ArrayList<Book>();
    }

    //MODIFIES: this and Book
    //EFFECTS: Adds a book to the cart if it is not already there. If the book is already in the cart
    //         it just increments the number of that book in the cart. Throws exception if quantity of
    //         books to add is negative
    public static void addToCart(Book book, int quantity) throws NegativeQuantityException {
        if (quantity < 0) {
            throw new NegativeQuantityException();
        }
        book.addQuantity(quantity);
        if (booksInCart.isEmpty()) {
            booksInCart.add(book);
        } else {
            boolean bookAlreadyInCart = false;
            for (Book b : booksInCart) {
                if ((b.equals(book))) {
                    bookAlreadyInCart = true;
                    break;
                }
            }
            if (!bookAlreadyInCart) {
                booksInCart.add(book);
            }
        }
    }

    public static ArrayList<Book> getBooksInCart() {
        return booksInCart;
    }

    // EFFECTS: Returns the number of different books in the cart
    public static int getNumBooksInCart() {
        return booksInCart.size();
    }

    //EFFECTS: Returns the discount awarded based on the Raw Price of the books. The discounts are based
    //         on the the deals shown in the opening screen of the application. Throws exception if raw price
    //         is negative.
    public static double discount(double rawAmount) throws InvalidAmountException {
        if (rawAmount < 0) {
            throw new InvalidAmountException();
        }
        return calculateDiscount(rawAmount);
    }

    // EFFECTS: Calculates and returns the discount awarded based on the Raw Price of the books.
    static double calculateDiscount(double rawAmount) {
        if (rawAmount >= 0.0) {
            if (rawAmount < 5.0) {
                return 0;
            }
        }
        if (rawAmount >= 5.0) {
            if (rawAmount < 13.0) {
                return 0.05 * rawAmount;
            }
        }
        if (rawAmount >= 13.0) {
            if (rawAmount < 16.0) {
                return 0.1 * rawAmount;
            }
        }
        if (rawAmount >= 16.0) {
            if (rawAmount < 30.0) {
                return 0.15 * rawAmount;
            }
        }
        return 0.2 * rawAmount;
    }

    @Override

    // CITATION: Code obtained and modified from JsonSerializationDemo
    //           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: returns this as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("booksInCart", thingiesToJson());
        return json;
    }

    // CITATION: Code obtained and modified from JsonSerializationDemo
    //           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: returns things in this cart as a JSON array
    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Book b : booksInCart) {
            jsonArray.put(b.toJson());
        }

        return jsonArray;
    }
}

