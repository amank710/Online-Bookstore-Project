package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a book with a name, author's name, genre and quantity of that specific book in the cart
public class Book implements Writable {
    private String name;
    private String author;
    private String genre;
    private Double price;
    private int quantity;

    public static final Book PERCYJACKSON = new Book("Percy Jackson the Lightning Thief","R. Riordan","Action", 6.00);
    public static final Book HARRYPOTTER = new Book("Harry Potter and the Goblet of Fire","J.Rowling","Action", 5.00);
    public static final Book ERAGON = new Book("Eragon","Christopher Paolini","Action", 5.50);
    public static final Book THEMAZERUNNER = new Book("The Maze Runner","James Dashner","Action", 4.00);
    public static final Book BONE = new Book("Bone","Jeff Smith","Comics", 10.00);
    public static final Book ARCHIES = new Book("Archies","Vic Bloom","Comics", 9.00);
    public static final Book XMEN = new Book("X-men","Stan Lee","Comics", 7.00);
    public static final Book PHANTOM = new Book("Phantom","Lee Falk","Comics", 4.00);
    public static final Book THEDAVINCICODE = new Book("The Da Vinci Code","Dan Brown","Mystery", 5.00);
    public static final Book THEBIGSLEEP = new Book("The Big Sleep","Raymond Chandler","Mystery", 3.20);
    public static final Book GONEGIRL = new Book("Gone Girl","Gillian Flynn","Mystery", 4.00);
    public static final Book SHERLOCKHOLMES = new Book("The Adventures of Sherlock Holmes","A. Doyle","Mystery", 2.50);
    public static final Book FAULTINOURSTARS = new Book("The Fault in Our Stars","John Green","Drama", 5.00);
    public static final Book MACBETH = new Book("Macbeth","William Shakespeare","Drama", 1.80);
    public static final Book DEATHOFASALESMAN = new Book("Death of a Salesman","Arthur Miller","Drama", 4.20);
    public static final Book TOKILLAMOCKINGBIRD = new Book("To Kill a Mockingbird","Harper Lee","Drama", 5.00);


    //REQUIRES: A positive value for the price of the book
    //EFFECTS: Initialises the name, author, genre and the price of a book. Also initialises the number of that specific
    //         book in the cart to 0;
    public Book(String name, String author, String genre, double price) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
        quantity = 0;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    //MODIFIES: this
    // EFFECTS: Add the integer quantity to the number of the specific book in the cart already.
    public void addQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    @Override

    // CITATION: Code obtained and modified from JsonSerializationDemo
    //           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: returns this as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("author", author);
        json.put("genre", genre);
        json.put("price", price);
        json.put("quantity", quantity);
        return json;
    }
}
