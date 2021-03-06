package persistence;


import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// CITATION: Code obtained and modified from JsonSerializationDemo
//           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonTest {

    protected void checkBook(String name, String author, String genre, double price, int quantity, Book book) {
        assertEquals(name, book.getName());
        assertEquals(author, book.getAuthor());
        assertEquals(genre, book.getGenre());
        assertEquals(price, book.getPrice());
        assertEquals(quantity, book.getQuantity());
    }
}
