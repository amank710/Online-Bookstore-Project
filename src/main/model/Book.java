package model;

// Represents a book with a name, author's name, genre and quantity of that specific book in the cart
public class Book {
    private String name;
    private String author;
    private String genre;
    private Double price;
    private int quantity;

    static final Book PERCYJACKSON = new Book("Percy Jackson and the Lightning Thief","Rick Riordan","Action", 6.00);
    static final Book HARRYPOTTER = new Book("Harry Potter and the Goblet of Fire","J. K. Rowling","Action", 5.00);
    static final Book ERAGON = new Book("Eragon","Christopher Paolini","Action", 5.50);
    static final Book THEMAZERUNNER = new Book("The Maze Runner","James Dashner","Action", 4.00);
    static final Book BONE = new Book("Bone","Jeff Smith","Comics", 10.00);
    static final Book ARCHIES = new Book("Archies","Vic Bloom","Comics", 9.00);
    static final Book XMEN = new Book("X-men","Stan Lee","Comics", 7.00);
    static final Book PHANTOM = new Book("Phantom","Lee Falk","Comics", 4.00);
    static final Book THEDAVINCICODE = new Book("The Da Vinci Code","Dan Brown","Mystery", 5.00);
    static final Book THEBIGSLEEP = new Book("The Big Sleep","Raymond Chandler","Mystery", 3.20);
    static final Book GONEGIRL = new Book("Gone Girl","Gillian Flynn","Mystery", 4.00);
    static final Book SHERLOCKHOLMES = new Book("The Adventures of Sherlock Holmes","Arthur Doyle","Mystery", 2.50);
    static final Book FAULTINOURSTARS = new Book("The Fault in Our Stars","John Green","Drama", 5.00);
    static final Book MACBETH = new Book("Macbeth","William Shakespeare","Drama", 1.80);
    static final Book DEATHOFASALESMAN = new Book("Death of a Salesman","Arthur Miller","Drama", 4.20);
    static final Book TOKILLAMOCKINGBIRD = new Book("To Kill a Mockingbird","Harper Lee","Drama", 5.00);

    public static final int NO_OF_GENRES = 4;
    public static final String[] GENRES = new String[] {"Action","Comics","Mystery","Drama"};

    public static final int NO_OF_ACTIONBOOKS = 4;
    public static final int NO_OF_COMICBOOKS = 4;
    public static final int NO_OF_MYSTERYBOOKS = 4;
    public static final int NO_OF_DRAMABOOKS = 4;
    public static final Book[] ACTIONBOOKS = new Book[] {PERCYJACKSON,HARRYPOTTER,ERAGON,THEMAZERUNNER};
    public static final Book[] COMICBOOKS = new Book[] {BONE,ARCHIES,XMEN,PHANTOM};
    public static final Book[] MYSTERYBOOKS = new Book[] {THEDAVINCICODE,THEBIGSLEEP,GONEGIRL,SHERLOCKHOLMES};
    public static final Book[] DRAMABOOKS = new Book[] {FAULTINOURSTARS,MACBETH,DEATHOFASALESMAN,TOKILLAMOCKINGBIRD};


    //REQUIRES: A positive value for the price of the book
    //EFFECTS: Initialises the name, author, genre and the price of a book. Also initialises the number of that specific
    //         book in the cart to 0;
    Book(String name, String author, String genre, double price) {
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


}
