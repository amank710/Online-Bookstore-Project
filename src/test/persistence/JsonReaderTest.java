package persistence;

import model.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// CITATION: Code obtained and modified from JsonSerializationDemo
//           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Cart c = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCart() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCart.json");
        try {
            Cart c = reader.read();
            assertEquals(0, c.getNumBooksInCart());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCart() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCart.json");
        try {
            Cart c = reader.read();
            List<Book> books = c.getBooksInCart();
            assertEquals(2, books.size());
            checkBook("Archies", "Vic Bloom", "Comics", 9, 2, books.get(0));
            checkBook("Gone Girl", "Gillian Flynn", "Mystery", 4, 1, books.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
