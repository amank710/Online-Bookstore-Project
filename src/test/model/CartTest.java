package model;

import exceptions.InvalidAmountException;
import exceptions.NegativeQuantityException;
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
        try {
            cartTest.addToCart(testBook,1);
            assertEquals(1,cartTest.getBooksInCart().size());
            assertEquals(testBook,cartTest.getBooksInCart().get(0));
        } catch (NegativeQuantityException e) {
            fail("Did not expect exception");
        }
    }
    @Test
    void testAddToCartBookAlreadyInCart() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        try {
            cartTest.addToCart(testBook,4);
            assertEquals(1,cartTest.getBooksInCart().size());
            cartTest.addToCart(testBook,2);
            assertEquals(1,cartTest.getBooksInCart().size());
            assertEquals(testBook,cartTest.getBooksInCart().get(0));
        } catch (NegativeQuantityException e) {
            fail("Did not expect exception");
        }
    }

    @Test
    void testAddToCartMultipleBooks() {
        try {
            Book testBook = new Book("In The Woods", "Tana French", "Mystery", 5.00);
            Book testBook2 = new Book("Venom", "Ryan Stegman", "Comic", 2.00);
            cartTest.addToCart(testBook, 4);
            assertEquals(1, cartTest.getBooksInCart().size());
            cartTest.addToCart(testBook2, 2);
            assertEquals(2, cartTest.getBooksInCart().size());
            assertEquals(testBook2, cartTest.getBooksInCart().get(1));
        } catch (NegativeQuantityException e) {
            fail("Did not expect exception");
        }
    }

    @Test
    void testNumBooksInCartEmptyCart() {
        assertEquals(0, cartTest.getNumBooksInCart());
    }

    @Test
    void testNumBooksInCartOneBook() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        assertEquals(0, cartTest.getNumBooksInCart());
        try {
            cartTest.addToCart(testBook,4);
            assertEquals(1, cartTest.getNumBooksInCart());
        } catch (NegativeQuantityException e) {
            fail("Did not expect exception");
        }
    }

    @Test
    void testNumBooksInCartMultipleBook() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        Book testBook2 = new Book("Venom","Ryan Stegman","Comic",2.00);
        assertEquals(0, cartTest.getNumBooksInCart());
        try {
            cartTest.addToCart(testBook, 4);
            assertEquals(1, cartTest.getNumBooksInCart());
            cartTest.addToCart(testBook2, 1);
            assertEquals(2, cartTest.getNumBooksInCart());
        } catch (NegativeQuantityException e){
            fail("Did not expect exception");
        }
    }

    @Test
    void testAddToCartThrowException() {
        Book testBook = new Book("In The Woods","Tana French","Mystery",5.00);
        try {
            cartTest.addToCart(testBook,-1);
            fail("Expected NegativeQuantityException exception");
        } catch (NegativeQuantityException e) {
            //Expected
        }
    }

    @Test
    void testDiscountNoDiscount() {
        try {
            assertEquals(0.0, cartTest.discount(4.0));
            assertEquals(0.0, cartTest.discount(4.5));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testDiscountNoDiscountBoundary() {
        try {
            assertEquals(0.0, cartTest.discount(0.0));
            assertEquals(0.0, cartTest.discount(4.9));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testDiscountFivePercent() {
        try {
            assertEquals(0.05 * 10.0, cartTest.discount(10.0));
            assertEquals(0.05 * 10.5, cartTest.discount(10.50));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testDiscountFivePercentBoundary() {
        try {
            assertEquals(0.05 * 5.0, cartTest.discount(5.0));
            assertEquals(0.05 * 12.90, cartTest.discount(12.90));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testDiscountTenPercent() {
        try {
            assertEquals(0.10 * 15.0, cartTest.discount(15.0));
            assertEquals(0.10 * 15.5, cartTest.discount(15.5));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testDiscountTenPercentBoundary() {
        try {
            assertEquals(0.10 * 13.0, cartTest.discount(13.0));
            assertEquals(0.10 * 15.9, cartTest.discount(15.9));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testDiscountFifteenPercent() {
        try {
            assertEquals(0.15 * 16.1, cartTest.discount(16.1));
            assertEquals(0.15 * 22.0, cartTest.discount(22.0));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testDiscountFifteenPercentBoundary() {
        try {
            assertEquals(0.15 * 16.0, cartTest.discount(16.0));
            assertEquals(0.15 * 29.90, cartTest.discount(29.90));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testDiscountTwentyPercent() {
        try {
            assertEquals(0.20 * 104.0, cartTest.discount(104.0));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testDiscountTwentyPercentBoundary() {
        try {
            assertEquals(0.20 * 30.0, cartTest.discount(30.0));
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testDiscountThrowException() {
        try {
            assertEquals(-1.1 * 0.2, cartTest.discount(-1.1));
            fail("Expected InvalidAmountException");
        } catch (InvalidAmountException e) {
            // Expected
        }
    }

    @Test
    void testCalculateDiscountNegativeAmount() {
            assertEquals(-1.1 * 0.2, cartTest.calculateDiscount(-1.1));
    }
}
