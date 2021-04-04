package persistence;


import exceptions.NegativeQuantityException;
import model.Book;
import model.Cart;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// CITATION: Code obtained and modified from JsonSerializationDemo
//           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Represents a reader that reads the items in a cart from JSON data stored in file
public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads cart from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Cart read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCart(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    // EFFECTS: parses Cart from JSON object and returns it

    private Cart parseCart(JSONObject jsonObject) {
        Cart c = new Cart();
        addBooksInCart(c, jsonObject);
        return c;
    }

    // MODIFIES: c
    // EFFECTS: parses booksInCart from JSON object and adds them to Cart
    private void addBooksInCart(Cart c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("booksInCart");
        for (Object json : jsonArray) {
            JSONObject nextBook = (JSONObject) json;
            addThingy(c, nextBook);
        }
    }


    // MODIFIES: c
    // EFFECTS: parses book from JSON object and adds it to cart
    private void addThingy(Cart c, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String author = jsonObject.getString("author");
        String genre = jsonObject.getString("genre");
        Double price = jsonObject.getDouble("price");
        int quantity = jsonObject.getInt("quantity");
        Book book = new Book(name,author,genre,price);
        try {
            c.addToCart(book,quantity);
        } catch (NegativeQuantityException e) {
            System.out.println("Can't add negative quantity");
        }
    }
}
