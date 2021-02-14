package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CartTest {
    ArrayList<Book> booksInCartTest;

    @BeforeEach
    void runBefore() {
        booksInCartTest = new ArrayList<Book>();
    }

    @Test
    void testConstructor() {
        ArrayList<Book> booksInCartTest2 = new ArrayList<Book>();
        assertEquals(0,booksInCartTest2.size());
    }

    @Test
    void testAddToCartEmptyCart() {

    }
}
