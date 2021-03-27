package ui;

import model.Book;
import model.Customer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static model.Book.*;
import static model.City.*;

public class BookstoreGUI extends JFrame implements ActionListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    public static final String SOUNDLOCATION = "./data/Button_Sound.wav";
    private Book bookToAdd;
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
    private JTextField firstName;
    private JTextField lastName;
    private JTextField email;
    private JTextField enteredQuantity;
    private JLabel successMessage;
    private JComboBox cityList;


    BookstoreGUI() {
        frame = new JFrame("Aman's Bookstore");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        userInfoPanel();
        //mainMenu();
        //viewGenres();
        //viewCart();
        //viewActionBooks();
        //viewComicBooks();


        frame.add(startingPanel);
        //frame.add(mainMenuPanel);
        //frame.add(genresPanel);
        //frame.add(viewCartPanel);
        //frame.add(actionPanel);
        //frame.setContentPane(startingPanel);

        frame.setVisible(true);

    }

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

    private void showDiscountOffers() {
        JLabel label1 = new JLabel("Welcome to Aman's book store, Vancouver");
        JLabel label2 = new JLabel("EXCLUSIVE OFFERS:");
        JLabel label3 = new JLabel("On total bill price over CAD 5.00 get 5% off!\n");
        JLabel label4 = new JLabel("On total bill price over CAD 13.00 get 10% off!\n");
        JLabel label5 = new JLabel("On total bill price over CAD 16.00 get 15% off!\n");
        JLabel label6 = new JLabel("On total bill price over CAD 30.00 get 20% off!\n");
        label1.setBounds(175, 5, 500, 50);
        label2.setBounds(10, 20, 500, 50);
        label3.setBounds(10, 30, 500, 50);
        label4.setBounds(10, 40, 500, 50);
        label5.setBounds(10, 50, 500, 50);
        label6.setBounds(10, 60, 500, 50);

        startingPanel.add(label1);
        startingPanel.add(label2);
        startingPanel.add(label3);
        startingPanel.add(label4);
        startingPanel.add(label5);
        startingPanel.add(label6);
    }

    public void mainMenu() {
        mainMenuPanel = new JPanel();
        setupPanel(mainMenuPanel);

        JLabel menuTitle = new JLabel("MAIN MENU");
        menuTitle.setFont(new Font("Serif", Font.PLAIN, 24));
        menuTitle.setBounds(215, 10, 200, 50);
        mainMenuPanel.add(menuTitle);
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

        frame.setContentPane(mainMenuPanel);
    }

    public void viewGenres() {
        genresPanel = new JPanel();
        setupPanel(genresPanel);

        JLabel genresTitle = new JLabel("GENRES");
        genresTitle.setFont(new Font("Serif", Font.PLAIN, 24));
        genresTitle.setBounds(210, 10, 200, 50);
        genresPanel.add(genresTitle);

        JLabel genresInstructions = new JLabel("Select the desired genre from the list below:");
        genresInstructions.setFont(new Font("Serif", Font.PLAIN, 16));
        genresInstructions.setBounds(15, 50, 300, 50);
        genresPanel.add(genresInstructions);

        actionButton = new JButton("Action");
        actionButton.setBounds(165, 100, 250, 30);
        actionButton.addActionListener(this);

        comicsButton = new JButton("Comics");
        comicsButton.setBounds(165, 135, 250, 30);
        comicsButton.addActionListener(this);

        mysteryButton = new JButton("Mystery");
        mysteryButton.setBounds(165, 170, 250, 30);
        mysteryButton.addActionListener(this);

        dramaButton = new JButton("Drama");
        dramaButton.setBounds(165, 205, 250, 30);
        dramaButton.addActionListener(this);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 250, 30);
        mainMenuButton.addActionListener(this);

        genresPanel.add(actionButton);
        genresPanel.add(comicsButton);
        genresPanel.add(mysteryButton);
        genresPanel.add(dramaButton);
        genresPanel.add(mainMenuButton);

        frame.setContentPane(genresPanel);
    }

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

    private static void addBooksToPanel(JPanel panel, JButton b1, JButton b2, JButton b3, JButton b4, JButton menu) {
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(menu);
    }

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

    private static void setupPanel(JPanel startingPanel) {
        startingPanel.setBackground(Color.gray);
        startingPanel.setBounds(0, 0, WIDTH, HEIGHT);
        startingPanel.setLayout(null);
    }

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

    private void viewBookInfo(Book book) {
        bookToAdd = book;
        bookInfo = new JPanel();
        setupPanel(bookInfo);
        JLabel bookName = new JLabel(book.getName());
        bookName.setFont(new Font("Serif", Font.PLAIN, 30));
        bookName.setBounds(100,10,450,50);

        JLabel bookAuthor = new JLabel("Author: " + book.getAuthor());
        bookAuthor.setFont(new Font("Serif", Font.PLAIN, 20));
        bookAuthor.setBounds(20,90,400,50);

        JLabel bookPrice = new JLabel("Book Price: " + book.getPrice() + " CAD");
        bookPrice.setFont(new Font("Serif", Font.PLAIN, 20));
        bookPrice.setBounds(20,110,400,50);

        JLabel quantityLabel = new JLabel("Enter the number of books you want to add to the cart:");
        quantityLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        quantityLabel.setBounds(20,160,450,50);

        successMessage = new JLabel("");
        successMessage.setFont(new Font("Serif", Font.PLAIN, 20));
        successMessage.setBounds(105,250,450,50);

        enteredQuantity = new JTextField();
        enteredQuantity.setBounds(460,170,40,30);

        addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBounds(165, 310, 280, 30);
        addToCartButton.addActionListener(this);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(165, 350, 280, 30);
        mainMenuButton.addActionListener(this);

        bookInfo.add(bookName);
        bookInfo.add(bookAuthor);
        bookInfo.add(bookPrice);
        bookInfo.add(quantityLabel);
        bookInfo.add(enteredQuantity);
        bookInfo.add(addToCartButton);
        bookInfo.add(mainMenuButton);
        bookInfo.add(successMessage);

        frame.setContentPane(bookInfo);
    }

    public void viewCart() {
        viewCartPanel = new JPanel();
        setupPanel(viewCartPanel);
    }

    public static void main(String[] args) {
        new BookstoreGUI();
    }

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

    private void checkOtherButtons(ActionEvent e) {
        if (e.getSource() == booksButton) {
            viewGenres();
        } else if (e.getSource() == viewCartButton) {
            frame.setContentPane(viewCartPanel);
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
            bookToAdd.addQuantity(Integer.parseInt(enteredQuantity.getText()));
            successMessage.setText("The book(s) have been added to your cart successfully!");
            System.out.println(bookToAdd.getQuantity());
        }
    }
}
