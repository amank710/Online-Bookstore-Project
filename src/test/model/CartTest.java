package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static model.Cart.booksInCart;
import static model.Cart.getBooksInCart;
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
    void testDiscountNoDiscount() {
        assertEquals(0.0,cartTest.discount(4.0));
    }
    @Test
    void testDiscountNoDiscountBoundary() {
        assertEquals(0.0,cartTest.discount(4.9));
    }

    @Test
    void testDiscountFivePercent() {
        assertEquals(0.05 * 10.0,cartTest.discount(10.0));
    }
    @Test
    void testDiscountFivePercentBoundary() {
        assertEquals(0.05 * 5.0,cartTest.discount(5.0));
    }

    @Test
    void testDiscountTenPercent() {
        assertEquals(0.10 * 15.0,cartTest.discount(15.0));
    }
    @Test
    void testDiscountTenPercentBoundary() {
        assertEquals(0.10 * 13.0,cartTest.discount(13.0));
    }

    @Test
    void testDiscountFifteenPercent() {
        assertEquals(0.15 * 22.0,cartTest.discount(22.0));
    }
    @Test
    void testDiscountFifteenPercentBoundary() {
        assertEquals(0.15 * 16.0,cartTest.discount(16.0));
    }

    @Test
    void testDiscountTwentyPercent() {
        assertEquals(0.20 * 54.0,cartTest.discount(54.0));
    }
    @Test
    void testDiscountTwentyPercentBoundary() {
        assertEquals(0.20 * 30.0,cartTest.discount(30.0));
    }
}
