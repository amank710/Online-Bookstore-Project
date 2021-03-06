package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CartTest {
    private Cart cartTest;
    ArrayList<Book> booksInCartTest;

    @BeforeEach
    void runBefore() {
        Cart cartTest = new Cart();
        booksInCartTest = new ArrayList<Book>();
    }

    @Test
    void testConstructor() {
        ArrayList<Book> booksInCartTest2 = new ArrayList<Book>();
        assertEquals(0,booksInCartTest2.size());
    }

    @Test
    void testAddToCartOneBookInEmptyCart() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        cartTest.addToCart(testBook,1);
        assertEquals(1,cartTest.getBooksInCart().size());
        assertEquals(testBook,cartTest.getBooksInCart().get(0));
    }
    @Test
    void testAddToCartBookAlreadyInCart() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        cartTest.addToCart(testBook,4);
        assertEquals(1,cartTest.getBooksInCart().size());
        cartTest.addToCart(testBook,2);
        assertEquals(1,cartTest.getBooksInCart().size());
        assertEquals(testBook,cartTest.getBooksInCart().get(0));
    }

    @Test
    void testAddToCartMultipleBooks() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        Book testBook2 = new Book("Venom","Ryan Stegman","Comic",2.00);
        cartTest.addToCart(testBook,4);
        assertEquals(1,cartTest.getBooksInCart().size());
        cartTest.addToCart(testBook2,2);
        assertEquals(2,cartTest.getBooksInCart().size());
        assertEquals(testBook2,cartTest.getBooksInCart().get(1));
    }

    @Test
    void testNumBooksInCartEmptyCart() {
        assertEquals(0, cartTest.getNumBooksInCart());
    }

    @Test
    void testNumBooksInCartOneBook() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        assertEquals(0, cartTest.getNumBooksInCart());
        cartTest.addToCart(testBook,4);
        assertEquals(1, cartTest.getNumBooksInCart());
    }

    @Test
    void testNumBooksInCartMultipleBook() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        Book testBook2 = new Book("Venom","Ryan Stegman","Comic",2.00);
        assertEquals(0, cartTest.getNumBooksInCart());
        cartTest.addToCart(testBook,4);
        assertEquals(1, cartTest.getNumBooksInCart());
        cartTest.addToCart(testBook2,1);
        assertEquals(2, cartTest.getNumBooksInCart());
    }

    @Test
    void testDiscountNoDiscount() {
        assertEquals(0.0,cartTest.discount(4.0));
        assertEquals(0.0,cartTest.discount(4.5));
        assertEquals(-1.1 * 0.2,cartTest.discount(-1.1));
    }
    @Test
    void testDiscountNoDiscountBoundary() {
        assertEquals(0.0,cartTest.discount(0.0));
        assertEquals(0.0,cartTest.discount(4.9));
    }

    @Test
    void testDiscountFivePercent() {
        assertEquals(0.05 * 10.0,cartTest.discount(10.0));
        assertEquals(0.05 * 10.5,cartTest.discount(10.50));
    }
    @Test
    void testDiscountFivePercentBoundary() {
        assertEquals(0.05 * 5.0,cartTest.discount(5.0));
        assertEquals(0.05 * 12.90,cartTest.discount(12.90));
    }

    @Test
    void testDiscountTenPercent() {
        assertEquals(0.10 * 15.0,cartTest.discount(15.0));
        assertEquals(0.10 * 15.5,cartTest.discount(15.5));
    }
    @Test
    void testDiscountTenPercentBoundary() {
        assertEquals(0.10 * 13.0,cartTest.discount(13.0));
        assertEquals(0.10 * 15.9,cartTest.discount(15.9));
    }

    @Test
    void testDiscountFifteenPercent() {
        assertEquals(0.15 * 16.1,cartTest.discount(16.1));
        assertEquals(0.15 * 22.0,cartTest.discount(22.0));
    }
    @Test
    void testDiscountFifteenPercentBoundary() {
        assertEquals(0.15 * 16.0,cartTest.discount(16.0));
        assertEquals(0.15 * 29.90,cartTest.discount(29.90));
    }

    @Test
    void testDiscountTwentyPercent() {
        assertEquals(0.20 * 104.0,cartTest.discount(104.0));
    }
    @Test
    void testDiscountTwentyPercentBoundary() {
        assertEquals(0.20 * 30.0,cartTest.discount(30.0));
    }
}
