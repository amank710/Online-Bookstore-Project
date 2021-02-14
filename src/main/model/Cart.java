package model;

import java.util.ArrayList;

public class Cart {
    private static ArrayList<Book> booksInCart = new ArrayList<>();

    public Cart() {
        booksInCart = new ArrayList<Book>();
    }

    public static void addToCart(Book book, int quantity) {
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

    public static double discount(double rawAmount) {
        if (rawAmount >= 0.0 && rawAmount < 5.0) {
            return 0;
        } else if (rawAmount >= 5.0 && rawAmount < 13.0) {
            return 0.05 * rawAmount;
        } else if (rawAmount >= 13.0 && rawAmount < 16.0) {
            return 0.1 * rawAmount;
        } else if (rawAmount >= 16.0  &&  rawAmount < 30.0) {
            return 0.15 * rawAmount;
        } else {
            return 0.2 * rawAmount;
        }
    }
}
