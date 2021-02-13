package model;

// Represents a book with a name, author's name and genre
public class Book {
    private String name;
    private String author;
    private String genre;
    private Double price;

    Book(String name, String author, String genre, double price) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    Book percyJackson = new Book("Percy Jackson and the Lightning Thief","Rick Riordan","Action", 6.00);
    Book harryPotter = new Book("Harry Potter and the Prisoner of Azkaban","J. K. Rowling","Action", 5.00);
    Book eragon = new Book("Eragon","Christopher Paolini","Action", 5.50);
    Book theMazeRunner = new Book("The Maze Runner","James Dashner","Action", 4.00);
    Book bone = new Book("Bone","Jeff Smith","Comics", 10.00);
    Book archies = new Book("Archies","Vic Bloom","Comics", 9.00);
    Book xmen = new Book("X-men","Stan Lee","Comics", 7.00);
    Book phantom = new Book("Phantom","Lee Falk","Comics", 4.00);
    Book daVinciCode = new Book("The Da Vinci Code","Dan Brown","Mystery", 5.00);
    Book theBigSleep = new Book("The Big Sleep","Raymond Chandler","Mystery", 3.20);
    Book goneGirl = new Book("Gone Girl","Gillian Flynn","Mystery", 4.00);
    Book sherlockHolmes = new Book("The Adventures of Sherlock Holmes","Arthur Conan Doyle","Mystery", 2.50);
    Book faultInOurStars = new Book("The Fault in Our Stars","John Green","Drama", 5.00);
    Book macbeth = new Book("Macbeth","William Shakespeare","Drama", 1.80);
    Book deathOfASalesmen = new Book("Death of a Salesmen","Arthur Miller","Drama", 4.20);
    Book toKillAMockingbird = new Book("To Kill a Mockingbird","Harper Lee","Drama", 5.00);

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public Double getPrice() {
        return price;
    }
}
