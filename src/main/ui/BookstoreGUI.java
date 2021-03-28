package ui;

import model.Book;
import model.Cart;
import model.Customer;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import static model.Book.*;
import static model.Cart.getBooksInCart;
import static model.City.*;

//Online bookstore application (GUI)
public class BookstoreGUI extends JFrame implements ActionListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    public static final String SOUNDLOCATION = "./data/Button_Sound.wav";

    private DecimalFormat df2 = new DecimalFormat("#.##");
    private double rawAmount;
    private double discountedPrice;
    private Book bookToAdd;
    private Cart cart = new Cart();

    private JFrame frame;

    private JPanel startingPanel;
    private JPanel mainMenuPanel;
    private JPanel genresPanel;
    private JPanel viewCartPanel;
    private JPanel actionPanel;
    private JPanel comicsPanel;
    private JPanel mysteryPanel;
    private JPanel dramaPanel;
    private JPanel bookInfo;
    private JPanel checkOutPanel;

    private JButton enter;
    private JButton booksButton;
    private JButton viewCartButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton actionButton;
    private JButton comicsButton;
    private JButton mysteryButton;
    private JButton dramaButton;
    private JButton mainMenuButton;
    private JButton percyJButton;
    private JButton harryPButton;
    private JButton eragonButton;
    private JButton mazeRunnerButton;
    private JButton boneButton;
    private JButton archiesButton;
    private JButton xmenButton;
    private JButton phantomButton;
    private JButton daVinciButton;
    private JButton bigSleepButton;
    private JButton goneGirlButton;
    private JButton sherlockButton;
    private JButton faultStarsButton;
    private JButton macbethButton;
    private JButton salesmanButton;
    private JButton mockingbirdButton;
    private JButton addToCartButton;
    private JButton payNowButton;
    private JButton confirmPaymentButton;

    private JTextField firstName;
    private JTextField lastName;
    private JTextField email;
    private JTextField enteredQuantity;
    private JTextField address;
    private JLabel successMessage;
    private JLabel saveMessage;
    private JLabel loadMessage;
    private JComboBox cityList;

    private static final String JSON_STORE = "./data/cart.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //Sets up the GUI of the bookstore and calls the opening panel to be displayed
    BookstoreGUI() {
        frame = new JFrame("Aman's Bookstore");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        userInfoPanel();

        frame.add(startingPanel);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: displays the opening screen of the bookstore application with all the discount offers. Also accepts the
    //          user's name, email and city of delivery
    private void userInfoPanel() {
        startingPanel = new JPanel();
        setupPanel(startingPanel);

        showDiscountOffers();
        enterName();
        enterEmailAndCity();

        enter = new JButton("Enter Store");
        enter.setBounds(200, 350, 125, 30);
        enter.addActionListener(this);
        startingPanel.add(enter);
    }

    // MODIFIES: this
    // EFFECTS: Shows all the discounts available
    private void showDiscountOffers() {
        JLabel label1 = new JLabel("Welcome to Aman's book store, Vancouver");
        label1.setFont(new Font("Serif", Font.PLAIN, 26));
        JLabel label2 = new JLabel("EXCLUSIVE OFFERS:");
        JLabel label3 = new JLabel("On total bill price over CAD 5.00 get 5% off!\n");
        JLabel label4 = new JLabel("On total bill price over CAD 13.00 get 10% off!\n");
        JLabel label5 = new JLabel("On total bill price over CAD 16.00 get 15% off!\n");
        JLabel label6 = new JLabel("On total bill price over CAD 30.00 get 20% off!\n");
        label1.setBounds(60, 5, 500, 50);
        label2.setBounds(10, 50, 500, 50);
        label3.setBounds(10, 65, 500, 50);
        label4.setBounds(10, 80, 500, 50);
        label5.setBounds(10, 95, 500, 50);
        label6.setBounds(10, 110, 500, 50);

        startingPanel.add(label1);
        startingPanel.add(label2);
        startingPanel.add(label3);
        startingPanel.add(label4);
        startingPanel.add(label5);
        startingPanel.add(label6);
    }

    // MODIFIES: this
    // EFFECTS: Sets up the text fields to accepts the user's first name and last name
    private void enterName() {
        JLabel labelFirst = new JLabel("First name:");
        labelFirst.setFont(new Font("Serif", Font.PLAIN, 20));
        labelFirst.setBounds(20, 150, 200, 50);
        firstName = new JTextField();
        firstName.setBounds(175, 165, 200, 25);

        JLabel labelLast = new JLabel("Last name:");
        labelLast.setFont(new Font("Serif", Font.PLAIN, 20));
        labelLast.setBounds(20, 180, 200, 50);
        lastName = new JTextField();
        lastName.setBounds(175, 195, 200, 25);

        startingPanel.add(firstName);
        startingPanel.add(labelFirst);
        startingPanel.add(lastName);
        startingPanel.add(labelLast);
    }

    // MODIFIES: this
    // EFFECTS: Sets up a text field for the user to enter their e-mail address. Also provides a drop-down box for the
    //          the user to select their desired city for delivery
    private void enterEmailAndCity() {
        JLabel labelMail = new JLabel("E-Mail:");
        labelMail.setFont(new Font("Serif", Font.PLAIN, 20));
        labelMail.setBounds(20, 210, 200, 50);
        email = new JTextField();
        email.setBounds(175, 225, 200, 25);

        JLabel labelCity = new JLabel("City to deliver to:");
        labelCity.setFont(new Font("Serif", Font.PLAIN, 20));
        labelCity.setBounds(20, 240, 200, 50);
        cityList = new JComboBox(DELIVERYCITYNAMES);
        cityList.setBounds(175, 255, 200, 25);

        startingPanel.add(labelMail);
        startingPanel.add(email);
        startingPanel.add(labelCity);
        startingPanel.add(cityList);
    }

    // MODIFIES: this
    // EFFECTS: Displays the main menu options to the user
    public void mainMenu() {
        mainMenuPanel = new JPanel();
        setupPanel(mainMenuPanel);

        displayMainMenuTitle();

        booksButton = new JButton("View the books available for sale");
        booksButton.setBounds(165, 100, 250, 30);
        booksButton.addActionListener(this);

        viewCartButton = new JButton("View your Bill");
        viewCartButton.setBounds(165, 135, 250, 30);
        viewCartButton.addActionListener(this);

        saveButton = new JButton("Save current cart to file");
        saveButton.setBounds(165, 170, 250, 30);
        saveButton.addActionListener(this);

        loadButton = new JButton("Load cart from file");
        loadButton.setBounds(165, 205, 250, 30);
        loadButton.addActionListener(this);

        mainMenuPanel.add(booksButton);
        mainMenuPanel.add(viewCartButton);
        mainMenuPanel.add(saveButton);
        mainMenuPanel.add(loadButton);

        displaySaveAndLoadMessages();

        frame.setContentPane(mainMenuPanel);
    }

    // MODIFIES: this
    // EFFECTS: Generated the title for the main menu page
    private void displayMainMenuTitle() {
        JLabel menuTitle = new JLabel("MAIN MENU");
        menuTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        menuTitle.setBounds(215, 10, 200, 50);
        mainMenuPanel.add(menuTitle);
    }

    // EFFECTS: Displays the message if cart is saved or loaded to/from a file
    private void displaySaveAndLoadMessages() {
        saveMessage = new JLabel("Saved cart to " + JSON_STORE);
        saveMessage.setVisible(false);
        saveMessage.setFont(new Font("Serif", Font.PLAIN, 22));
        saveMessage.setBounds(165, 250, 300, 50);
        mainMenuPanel.add(saveMessage);

        loadMessage = new JLabel("Loaded cart from " + JSON_STORE);
        loadMessage.setVisible(false);
        loadMessage.setFont(new Font("Serif", Font.PLAIN, 22));
        loadMessage.setBounds(165, 250, 300, 50);
        mainMenuPanel.add(loadMessage);
    }

    //MODIFIES: this
    //EFFECTS: Displays the various genres available to the user and allows users to pick what genre books they want to
    //         see. Otherwise they can go back to the main menu
    public void viewGenres() {
        genresPanel = new JPanel();
        setupPanel(genresPanel);
        genresPanelInstructions();

        actionButton = new JButton("Action");
        addButtonToGenresPanel(actionButton,165,100);

        comicsButton = new JButton("Comics");
        addButtonToGenresPanel(comicsButton,165,135);

        mysteryButton = new JButton("Mystery");
        addButtonToGenresPanel(mysteryButton,165,170);

        dramaButton = new JButton("Drama");
        addButtonToGenresPanel(dramaButton,165,205);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 250, 30);
        mainMenuButton.addActionListener(this);
        genresPanel.add(mainMenuButton);

        frame.setContentPane(genresPanel);
    }

    //MODIFIES: this
    //EFFECTS: Displays the title and instructions of the genres panel
    private void genresPanelInstructions() {
        JLabel genresTitle = new JLabel("GENRES");
        genresTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        genresTitle.setBounds(210, 10, 200, 50);
        genresPanel.add(genresTitle);

        JLabel genresInstructions = new JLabel("Select the desired genre from the list below:");
        genresInstructions.setFont(new Font("Serif", Font.PLAIN, 16));
        genresInstructions.setBounds(15, 50, 300, 50);
        genresPanel.add(genresInstructions);
    }

    // MODIFIES: this
    // EFFECTS: Adds buttons corresponding to each genre on the genres panel
    private void addButtonToGenresPanel(JButton button, int x, int y) {
        button.setBounds(x, y, 250, 30);
        button.addActionListener(this);
        genresPanel.add(button);
    }

    // MODIFIES: this
    //EFFECTS: Shows the list of action books available and allows users to choose which book they want to buy.
    //         Otherwise they can go back to the main menu.
    public void viewActionBooks() {
        actionPanel = new JPanel();
        setupPanel(actionPanel);
        allBookInstructions(actionPanel, "ACTION BOOKS");

        percyJButton = new JButton(PERCYJACKSON.getName() + "   (" + PERCYJACKSON.getPrice() + ")");
        percyJButton.setBounds(165, 110, 270, 30);
        percyJButton.addActionListener(this);

        harryPButton = new JButton(HARRYPOTTER.getName() + "   (" + HARRYPOTTER.getPrice() + ")");
        harryPButton.setBounds(165, 145, 270, 30);
        harryPButton.addActionListener(this);

        eragonButton = new JButton(ERAGON.getName() + "   (" + ERAGON.getPrice() + ")");
        eragonButton.setBounds(165, 180, 270, 30);
        eragonButton.addActionListener(this);

        mazeRunnerButton = new JButton(THEMAZERUNNER.getName() + "   (" + THEMAZERUNNER.getPrice() + ")");
        mazeRunnerButton.setBounds(165, 215, 270, 30);
        mazeRunnerButton.addActionListener(this);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 270, 30);
        mainMenuButton.addActionListener(this);

        addBooksToPanel(actionPanel, percyJButton, harryPButton, eragonButton, mazeRunnerButton, mainMenuButton);

        frame.setContentPane(actionPanel);
    }

    // MODIFIES: this
    // EFFECTS: Adds all the listed books to the panel representing the genre they belong to
    private static void addBooksToPanel(JPanel panel, JButton b1, JButton b2, JButton b3, JButton b4, JButton menu) {
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(menu);
    }

    // MODIFIES: this
    // EFFECTS: Shows the list of comic books available and allows users to choose which book they want to buy.
    //         Otherwise they can go back to the main menu.
    public void viewComicBooks() {
        comicsPanel = new JPanel();
        setupPanel(comicsPanel);
        allBookInstructions(comicsPanel, "COMIC BOOKS");

        boneButton = new JButton(BONE.getName() + "   (" + BONE.getPrice() + ")");
        boneButton.setBounds(165, 110, 270, 30);
        boneButton.addActionListener(this);

        archiesButton = new JButton(ARCHIES.getName() + "   (" + ARCHIES.getPrice() + ")");
        archiesButton.setBounds(165, 145, 270, 30);
        archiesButton.addActionListener(this);

        xmenButton = new JButton(XMEN.getName() + "   (" + XMEN.getPrice() + ")");
        xmenButton.setBounds(165, 180, 270, 30);
        xmenButton.addActionListener(this);

        phantomButton = new JButton(PHANTOM.getName() + "   (" + PHANTOM.getPrice() + ")");
        phantomButton.setBounds(165, 215, 270, 30);
        phantomButton.addActionListener(this);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 270, 30);
        mainMenuButton.addActionListener(this);

        addBooksToPanel(comicsPanel, boneButton, archiesButton, xmenButton, phantomButton, mainMenuButton);

        frame.setContentPane(comicsPanel);
    }

    // MODIFIES: this
    // EFFECTS: Shows the list of mystery books available and allows users to choose which book they want to buy.
    //         Otherwise they can go back to the main menu.
    public void viewMysteryBooks() {
        mysteryPanel = new JPanel();
        setupPanel(mysteryPanel);
        allBookInstructions(mysteryPanel, "MYSTERY BOOKS");

        daVinciButton = new JButton(THEDAVINCICODE.getName() + "   (" + THEDAVINCICODE.getPrice() + ")");
        daVinciButton.setBounds(165, 110, 280, 30);
        daVinciButton.addActionListener(this);

        bigSleepButton = new JButton(THEBIGSLEEP.getName() + "   (" + THEBIGSLEEP.getPrice() + ")");
        bigSleepButton.setBounds(165, 145, 280, 30);
        bigSleepButton.addActionListener(this);

        goneGirlButton = new JButton(GONEGIRL.getName() + "   (" + GONEGIRL.getPrice() + ")");
        goneGirlButton.setBounds(165, 180, 280, 30);
        goneGirlButton.addActionListener(this);

        sherlockButton = new JButton(SHERLOCKHOLMES.getName() + "   (" + SHERLOCKHOLMES.getPrice() + ")");
        sherlockButton.setBounds(165, 215, 280, 30);
        sherlockButton.addActionListener(this);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 280, 30);
        mainMenuButton.addActionListener(this);

        addBooksToPanel(mysteryPanel, daVinciButton, bigSleepButton, goneGirlButton, sherlockButton, mainMenuButton);

        frame.setContentPane(mysteryPanel);
    }

    // MODIFIES: this
    // EFFECTS: Shows the list of drama books available and allows users to choose which book they want to buy.
    //         Otherwise they can go back to the main menu.
    public void viewDramaBooks() {
        dramaPanel = new JPanel();
        setupPanel(dramaPanel);
        allBookInstructions(dramaPanel, "DRAMA BOOKS");

        faultStarsButton = new JButton(FAULTINOURSTARS.getName() + "   (" + FAULTINOURSTARS.getPrice() + ")");
        faultStarsButton.setBounds(165, 110, 280, 30);
        faultStarsButton.addActionListener(this);

        macbethButton = new JButton(MACBETH.getName() + "   (" + MACBETH.getPrice() + ")");
        macbethButton.setBounds(165, 145, 280, 30);
        macbethButton.addActionListener(this);

        salesmanButton = new JButton(DEATHOFASALESMAN.getName() + "   (" + DEATHOFASALESMAN.getPrice() + ")");
        salesmanButton.setBounds(165, 180, 280, 30);
        salesmanButton.addActionListener(this);

        mockingbirdButton = new JButton(TOKILLAMOCKINGBIRD.getName() + "   (" + TOKILLAMOCKINGBIRD.getPrice() + ")");
        mockingbirdButton.setBounds(165, 215, 280, 30);
        mockingbirdButton.addActionListener(this);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 280, 30);
        mainMenuButton.addActionListener(this);

        addBooksToPanel(dramaPanel, faultStarsButton, macbethButton, salesmanButton, mockingbirdButton, mainMenuButton);

        frame.setContentPane(dramaPanel);
    }

    // MODIFIES: this
    // EFFECTS: Sets the background colour, bounds and layout of a panel
    private static void setupPanel(JPanel startingPanel) {
        startingPanel.setBackground(Color.cyan);
        startingPanel.setBounds(0, 0, WIDTH, HEIGHT);
        startingPanel.setLayout(null);
    }

    // MODIFIES: this
    // EFFECTS: Displays all the instructions on how to select the book the user wants to purchase
    private static void allBookInstructions(JPanel panel, String bookType) {
        JLabel title = new JLabel(bookType);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        title.setBounds(210, 10, 200, 50);
        panel.add(title);

        JLabel booksInstructions = new JLabel("Select desired book from the list below.");
        JLabel booksInstructions2 = new JLabel("The corresponding prices (CAD) are given alongside:");
        booksInstructions.setFont(new Font("Serif", Font.PLAIN, 16));
        booksInstructions2.setFont(new Font("Serif", Font.PLAIN, 16));
        booksInstructions.setBounds(15, 50, 300, 50);
        booksInstructions2.setBounds(15, 65, 400, 50);
        panel.add(booksInstructions);
        panel.add(booksInstructions2);
    }

    // MODIFIES: this
    // EFFECTS: Displays the available information in relation to a certain book
    private void viewBookInfo(Book book) {
        bookToAdd = book;
        bookInfo = new JPanel();
        setupPanel(bookInfo);
        displayBookDetails(book);

        JLabel quantityLabel = new JLabel("Enter the number of books you want to add to the cart:");
        quantityLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        quantityLabel.setBounds(20,160,450,50);

        enteredQuantity = new JTextField();
        enteredQuantity.setBounds(460,170,40,30);

        addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBounds(165, 310, 280, 30);
        addToCartButton.addActionListener(this);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 280, 30);
        mainMenuButton.addActionListener(this);

        bookInfo.add(quantityLabel);
        bookInfo.add(enteredQuantity);
        bookInfo.add(addToCartButton);
        bookInfo.add(mainMenuButton);

        frame.setContentPane(bookInfo);
    }

    // MODIFIES: this
    // EFFECTS: Displays book name, author and message if book is successfully added to the cart
    private void displayBookDetails(Book book) {
        JLabel bookName = new JLabel(book.getName());
        bookName.setFont(new Font("Serif", Font.PLAIN, 30));
        bookName.setBounds(100,10,450,50);

        JLabel bookAuthor = new JLabel("Author: " + book.getAuthor());
        bookAuthor.setFont(new Font("Serif", Font.PLAIN, 20));
        bookAuthor.setBounds(20,90,400,50);

        JLabel bookPrice = new JLabel("Book Price: " + book.getPrice() + " CAD");
        bookPrice.setFont(new Font("Serif", Font.PLAIN, 20));
        bookPrice.setBounds(20,110,400,50);

        successMessage = new JLabel("");
        successMessage.setFont(new Font("Serif", Font.PLAIN, 20));
        successMessage.setBounds(105,250,450,50);

        bookInfo.add(bookName);
        bookInfo.add(bookAuthor);
        bookInfo.add(bookPrice);
        bookInfo.add(successMessage);
    }

    // MODIFIES: this
    // EFFECTS: Shows all the items in the cart with the breakdown of the payable amount.
    //          User can choose to pay or return to the main menu
    public void viewCart() {
        rawAmount = 0.0;
        discountedPrice = 0.0;
        viewCartPanel = new JPanel();
        setupPanel(viewCartPanel);
        JLabel cartTitle = new JLabel("CART");
        cartTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        cartTitle.setBounds(250, 10, 200, 50);
        viewCartPanel.add(cartTitle);
        if (cart.getBooksInCart().size() == 0) {
            displayEmptyCart();
        } else {
            generateTableWithCartItems();
            costCalculation();

            mainMenuButton = new JButton("Main Menu");
            mainMenuButton.setBounds(130, 390, 140, 30);
            mainMenuButton.addActionListener(this);
            viewCartPanel.add(mainMenuButton);

            payNowButton = new JButton("Pay Now");
            payNowButton.setBounds(300, 390, 140, 30);
            payNowButton.addActionListener(this);
            viewCartPanel.add(payNowButton);
        }
        frame.setContentPane(viewCartPanel);
    }

    // MODIFIES: this
    // EFFECTS: Displays output when user tries accessing the cart while there are no book in it
    private void displayEmptyCart() {
        JLabel emptyCart = new JLabel("There are currently no books in the cart");
        emptyCart.setBounds(150,200,400,50);
        emptyCart.setFont(new Font("Serif", Font.PLAIN, 20));
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 280, 30);
        mainMenuButton.addActionListener(this);

        viewCartPanel.add(emptyCart);
        viewCartPanel.add(mainMenuButton);
    }

    // MODIFIES: this
    // EFFECTS: Generates a table with the book name, price, quantity and total amount of each book in the cart
    private void generateTableWithCartItems() {
        JLabel name = new JLabel(Customer.getFirstName() + " " + Customer.getLastName());
        name.setBounds(10,47,400,50);
        viewCartPanel.add(name);
        String[] cols = {"Item","Unit Price (CAD)", "Quantity", "Total (CAD)"};
        DefaultTableModel tableModel = new DefaultTableModel(cols,0);
        JTable items = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(items);
        scrollPane.setBounds(10, 90, 550, 150);
        for (int i = 0; i < cart.getNumBooksInCart(); i++) {
            String bookName = cart.getBooksInCart().get(i).getName();
            Double unitPrice = cart.getBooksInCart().get(i).getPrice();
            int quantity = getBooksInCart().get(i).getQuantity();
            double total = unitPrice * quantity;
            Object[] data = {bookName, unitPrice, quantity, total};
            tableModel.addRow(data);
            rawAmount = rawAmount + total;
        }
        viewCartPanel.add(scrollPane);
    }

    // MODIFIES: this
    // EFFECTS: Calculates and displays the breakdown of how the final payable amount is calculated
    private void costCalculation() {
        JLabel totalAmount = new JLabel("Total = " + rawAmount + " CAD");
        totalAmount.setBounds(10,250,400,20);

        double discountAwarded = Double.parseDouble(df2.format(cart.discount(rawAmount)));
        JLabel discountLabel = new JLabel("Discount = " + discountAwarded + " CAD");
        discountLabel.setBounds(10,270,400,20);

        discountedPrice = rawAmount - discountAwarded;
        JLabel discountedTotalLabel = new JLabel("Discounted Price = " + discountedPrice + " CAD");
        discountedTotalLabel.setBounds(10,290,400,20);

        double salesTax = Double.parseDouble(df2.format(0.12 * discountedPrice));
        JLabel salesTaxLabel = new JLabel("Sales Tax = " + salesTax + " CAD");
        salesTaxLabel.setBounds(10,310,400,20);

        JLabel freightChargesLabel = new JLabel("Freight Charges = " + Customer.getDeliveryCost() + " CAD");
        freightChargesLabel.setBounds(10,330,400,20);

        double finalAmount = discountedPrice + Customer.getDeliveryCity().getDeliveryCharge() + salesTax;
        finalAmount = Double.parseDouble(df2.format(finalAmount));
        JLabel amountPayableLabel = new JLabel("Amount Payable = " + finalAmount + " CAD");
        amountPayableLabel.setBounds(10,350,400,20);
        viewCartPanel.add(totalAmount);
        viewCartPanel.add(discountLabel);
        viewCartPanel.add(discountedTotalLabel);
        viewCartPanel.add(salesTaxLabel);
        viewCartPanel.add(freightChargesLabel);
        viewCartPanel.add(amountPayableLabel);
    }

    // MODIFIES: this
    // EFFECTS: Accepts the users delivery address, credit card number and cvv in order to
    //          process the payment for their order. Otherwise, user can return to main menu.
    private void checkOutScreen() {
        checkOutPanel = new JPanel();
        setupPanel(checkOutPanel);

        JLabel checkOutTitle = new JLabel("CHECKOUT");
        checkOutTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        checkOutTitle.setBounds(200, 10, 200, 50);
        checkOutPanel.add(checkOutTitle);

        enterAddress();
        enterCreditCardInfo();

        confirmPaymentButton = new JButton("Confirm Payment");
        confirmPaymentButton.setBounds(165, 300, 280, 30);
        confirmPaymentButton.addActionListener(this);
        checkOutPanel.add(confirmPaymentButton);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 280, 30);
        mainMenuButton.addActionListener(this);
        checkOutPanel.add(mainMenuButton);

        frame.setContentPane(checkOutPanel);
    }

    // MODIFIES: this
    // EFFECTS: Accepts user's delivery address
    private void enterAddress() {
        JLabel addressLabel = new JLabel("Desired delivery address");
        addressLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        addressLabel.setBounds(20, 120, 200, 50);
        address = new JTextField();
        address.setBounds(270, 135, 250, 25);

        checkOutPanel.add(addressLabel);
        checkOutPanel.add(address);
    }

    // MODIFIES: this
    // EFFECTS: Accepts users Credit card information
    private void enterCreditCardInfo() {
        JLabel cardNumberLabel = new JLabel("16 digit Credit Card Number:");
        cardNumberLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cardNumberLabel.setBounds(20, 150, 260, 50);
        JTextField cardNumber = new JTextField();
        cardNumber.setBounds(270, 165, 200, 25);

        JLabel cvvLabel = new JLabel("3 digit CVV Number");
        cvvLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cvvLabel.setBounds(20, 180, 200, 50);
        JTextField cvv = new JTextField();
        cvv.setBounds(270, 195, 50, 25);

        checkOutPanel.add(cardNumber);
        checkOutPanel.add(cardNumberLabel);
        checkOutPanel.add(cvv);
        checkOutPanel.add(cvvLabel);
    }

    // MODIFIES: this
    // EFFECTS: Displays the after payment is processed and the user checks out.
    private void exitSequence() {
        JPanel exitPanel = new JPanel();
        setupPanel(exitPanel);
        JLabel debitedAccount = new JLabel("Your account has been debited.");
        debitedAccount.setBounds(120,150,400,50);
        debitedAccount.setFont(new Font("Serif", Font.PLAIN, 20));

        JLabel message = new JLabel("Your order will reach " + Customer.getDeliveryCity().getCityName() + " in 3 days");
        message.setBounds(120,170,400,50);
        message.setFont(new Font("Serif", Font.PLAIN, 20));

        JLabel message2 = new JLabel("The package should be at your door in 4 days.");
        message2.setBounds(120,190,400,50);
        message2.setFont(new Font("Serif", Font.PLAIN, 20));

        JLabel thankYou = new JLabel("Thank you for shopping with us!");
        thankYou.setBounds(120,210,400,50);
        thankYou.setFont(new Font("Serif", Font.PLAIN, 20));

        exitPanel.add(debitedAccount);
        exitPanel.add(message);
        exitPanel.add(message2);
        exitPanel.add(thankYou);

        frame.setContentPane(exitPanel);
    }

    // CITATION: Code obtained and modified from JsonSerializationDemo
    //           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: Saves content of the cart to the file JSON_STORE.
    //          Throws exception if unable to write to the desired file.
    private void saveCart() {
        try {
            jsonWriter.open();
            jsonWriter.write(cart);
            jsonWriter.close();
            loadMessage.setVisible(false);
            saveMessage.setVisible(true);
            System.out.println("Saved cart to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // CITATION: Code obtained and modified from JsonSerializationDemo
    //           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this, cart
    // EFFECTS: loads cart from file. Throws exception if file to load from cannot be found.
    private void loadCart() {
        try {
            cart = jsonReader.read();
            saveMessage.setVisible(false);
            loadMessage.setVisible(true);
            System.out.println("Loaded cart from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // CITATION: Code adapted from http://suavesnippets.blogspot.com/2011/06/add-sound-on-jbutton-click-in-java.html
    // EFFECTS: Plays a specific sound when called. If invalid location for sound file is given, throws exception
    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error with playing sound.");
            e.printStackTrace();
        }
    }

    // MODIFIES: this, Customer
    // EFFECTS: Produces the desired output if a certain button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {
            Customer.setFirstName(firstName.getText());
            Customer.setLastName(lastName.getText());
            Customer.setEmail(email.getText());
            String itemAt = (String) cityList.getItemAt(cityList.getSelectedIndex());
            if ("Toronto".equals(itemAt)) {
                Customer.setDeliveryCity(TORONTO);
            } else if ("Ottawa".equals(itemAt)) {
                Customer.setDeliveryCity(OTTAWA);
            } else if ("Edmonton".equals(itemAt)) {
                Customer.setDeliveryCity(EDMONTON);
            } else if ("Calgary".equals(itemAt)) {
                Customer.setDeliveryCity(CALGARY);
            } else {
                Customer.setDeliveryCity(VANCOUVER);
            }
            mainMenu();

        } else {
            checkOtherButtons(e);
        }
        playSound(SOUNDLOCATION);
    }

    // MODIFIES: this
    // EFFECTS: Produces the desired output if a certain button is pressed
    private void checkOtherButtons(ActionEvent e) {
        if (e.getSource() == booksButton) {
            viewGenres();
        } else if (e.getSource() == viewCartButton) {
            viewCart();
        } else if (e.getSource() == mainMenuButton) {
            mainMenu();
        } else if (e.getSource() == actionButton) {
            viewActionBooks();
        } else if (e.getSource() == comicsButton) {
            viewComicBooks();
        } else if (e.getSource() == mysteryButton) {
            viewMysteryBooks();
        } else if (e.getSource() == dramaButton) {
            viewDramaBooks();
        } else {
            checkOtherButtons2(e);
        }
    }

    // MODIFIES: this
    // EFFECTS: Produces the desired output if a certain button is pressed
    private void checkOtherButtons2(ActionEvent e) {
        if (e.getSource() == percyJButton) {
            viewBookInfo(PERCYJACKSON);
        } else if (e.getSource() == harryPButton) {
            viewBookInfo(HARRYPOTTER);
        } else if (e.getSource() == eragonButton) {
            viewBookInfo(ERAGON);
        } else if (e.getSource() == mazeRunnerButton) {
            viewBookInfo(THEMAZERUNNER);
        } else if (e.getSource() == boneButton) {
            viewBookInfo(BONE);
        } else if (e.getSource() == archiesButton) {
            viewBookInfo(ARCHIES);
        } else if (e.getSource() == xmenButton) {
            viewBookInfo(XMEN);
        } else if (e.getSource() == phantomButton) {
            viewBookInfo(PHANTOM);
        } else {
            checkOtherButtons3(e);
        }
    }

    // MODIFIES: this, cart
    // EFFECTS: Produces the desired output if a certain button is pressed
    private void checkOtherButtons3(ActionEvent e) {
        if (e.getSource() == daVinciButton) {
            viewBookInfo(THEDAVINCICODE);
        } else if (e.getSource() == bigSleepButton) {
            viewBookInfo(THEBIGSLEEP);
        } else if (e.getSource() == goneGirlButton) {
            viewBookInfo(GONEGIRL);
        } else if (e.getSource() == sherlockButton) {
            viewBookInfo(SHERLOCKHOLMES);
        } else if (e.getSource() == faultStarsButton) {
            viewBookInfo(FAULTINOURSTARS);
        } else if (e.getSource() == macbethButton) {
            viewBookInfo(MACBETH);
        } else if (e.getSource() == salesmanButton) {
            viewBookInfo(DEATHOFASALESMAN);
        } else if (e.getSource() == mockingbirdButton) {
            viewBookInfo(TOKILLAMOCKINGBIRD);
        } else if (e.getSource() == addToCartButton) {
            cart.addToCart(bookToAdd,Integer.parseInt(enteredQuantity.getText()));
            successMessage.setText("The book(s) have been added to your cart successfully!");
        } else {
            checkOtherButtons4(e);
        }
    }

    // MODIFIES: this, Customer
    // EFFECTS: Produces the desired output if a certain button is pressed
    private void checkOtherButtons4(ActionEvent e) {
        if (e.getSource() == payNowButton) {
            checkOutScreen();
        } else if (e.getSource() == confirmPaymentButton) {
            Customer.setAddress(address.getText());
            exitSequence();
        } else if (e.getSource() == loadButton) {
            loadCart();
        } else if (e.getSource() == saveButton) {
            saveCart();
        }
    }
}
