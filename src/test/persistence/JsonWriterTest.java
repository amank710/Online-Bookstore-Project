package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// CITATION: Code obtained and modified from JsonSerializationDemo
//           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Cart c = new Cart();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCart() {
        try {
            Cart c = new Cart();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCart.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCart.json");
            c = reader.read();
            assertEquals(0, c.getNumBooksInCart());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testWriterGeneralCart() {
        try {
            Cart c = new Cart();
            c.addToCart(new Book("In The Woods","Tana French","Mystery",5.00),2);
            c.addToCart (new Book("Venom","Ryan Stegman","Comic",2.00),4);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCart.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCart.json");
            c = reader.read();
            List<Book> books = c.getBooksInCart();
            assertEquals(2, books.size());
            checkBook("In The Woods", "Tana French","Mystery",5, 2, books.get(0));
            checkBook("Venom", "Ryan Stegman","Comic",2, 4, books.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
