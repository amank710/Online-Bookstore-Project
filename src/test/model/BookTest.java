package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book testBook;
    @BeforeEach
    void runBefore() {
        testBook = new Book("In The Woods","Tana French","Mystery",5.00);
    }

    @Test
    void testConstructor() {
        Book testBook2 = new Book("Venom","Ryan Stegman","Comic",2.00);
        assertEquals("Venom",testBook2.getName());
        assertEquals("Ryan Stegman",testBook2.getAuthor());
        assertEquals("Comic",testBook2.getGenre());
        assertEquals(2.00,testBook2.getPrice());
        assertEquals(0,testBook2.getQuantity());
    }

    @Test
    void testAddQuantity() {
        testBook.addQuantity(2);
        assertEquals(2,testBook.getQuantity());
    }

    @Test
    void testAddQuantityMultipleTimes() {
        testBook.addQuantity(1);
        assertEquals(1,testBook.getQuantity());
        testBook.addQuantity(2);
        assertEquals(3,testBook.getQuantity());
    }
}
