package ui;

import model.*;
import java.util.Scanner;

import static model.Book.*;
import static model.Cart.addToCart;
import static model.City.DELIVERYCITIES;
import static model.City.NO_OF_CITIES;

// Bookstore Application
public class Bookstore {

    private Scanner input;
    private String firstName;
    private String lastName;

    Bookstore() {
        input = new Scanner(System.in);
        mainScreen();
    }

    //EFFECTS: displays the opening screen of the bookstore application with all the discount offers. Also calls the
    //         method responsible for accepting the user's first name
    private void mainScreen() {
        System.out.println("Welcome to Aman's book store, Vancouver");
        System.out.println();
        System.out.println("EXCLUSIVE OFFERS: ");
        System.out.println("On total bill price over CAD 5.00 get 5% off!");
        System.out.println("On total bill price over CAD 13.00 get 10% off!");
        System.out.println("On total bill price over CAD 16.00 get 15% off!");
        System.out.println("On total bill price over CAD 30.00 get 20% off!");
        System.out.println();
        System.out.println("Hurry, offer stands only for a limited time!!!");
        System.out.println();
        System.out.println();
        System.out.println();
        enterFirstName();
    }

    //MODIFIES: this and Customer
    //EFFECTS: Stores the customers first name
    public void enterFirstName() {
        l: while (true) {
            int count1 = 0;
            String firstNameCopy;
            while (true) {
                System.out.println("Enter First Name");
                firstName = input.nextLine();
                firstNameCopy = firstName.toLowerCase();
                for (int m = 0; m < firstName.length(); m++) {
                    if ((firstNameCopy.charAt(m) <= 122 && firstNameCopy.charAt(m) >= 97)) {
                        count1++;
                    } else {
                        System.out.println("Enter letters only. No special characters or numbers allowed. Try again");
                        count1 = 0;
                        break;
                    }
                }
                if (count1 == firstNameCopy.length()) {
                    break l;
                }
            }
        }
        Customer.setFirstName(this.firstName);
        enterLastName();
    }


    //MODIFIES: this and Customer
    //EFFECTS: Stores the customers last name
    public void enterLastName() {

        l: while (true) {
            int count1 = 0;
            String lastNameCopy;
            while (true) {
                System.out.println("Enter Last Name");
                lastName = input.nextLine();
                lastNameCopy = lastName.toLowerCase();
                for (int m = 0; m < lastName.length(); m++) {
                    if ((lastNameCopy.charAt(m) <= 122 && lastNameCopy.charAt(m) >= 97)) {
                        count1++;
                    } else {
                        System.out.println("Enter letters only. No special characters or numbers allowed. Try again");
                        count1 = 0;
                        break;
                    }
                }
                if (count1 == lastNameCopy.length()) {
                    break l;
                }
            }
        }
        Customer.setLastName(this.firstName);
        enterEmail();
    }

    //MODIFIES: this and Customer
    //EFFECTS: Stores the customers email address
    private void enterEmail() {

        System.out.println("Please enter your Email address:");
        Customer.setEmail(input.nextLine());
        toShip();
    }

    //MODIFIES: this and Customer
    //EFFECTS: Stores the cost of delivery based on the location of delivery selected by the user
    void toShip() {
        System.out.println("Please enter the number corresponding to the city for us to ship your products to:");
        System.out.println("The delivery charges (CAD) are also listed alongside.");
        for (int i = 1; i <= NO_OF_CITIES; i++) {
            System.out.print(i + ". " + DELIVERYCITIES[i - 1].getCityName());
            System.out.println(" (" + DELIVERYCITIES[i - 1].getDeliveryCharge() + ")");
        }

        int entry = input.nextInt();
        Customer.setDeliveryCity(DELIVERYCITIES[entry - 1]);
        Customer.setDeliveryCost(DELIVERYCITIES[entry - 1].getDeliveryCharge());
        mainMenu();
    }

    //EFFECTS: Displays the main menu options to the user
    void mainMenu() {
        System.out.println();
        System.out.println("Press: ");
        System.out.println("1 to view the books available for sale");
        System.out.println("2 to view your bill");
        System.out.println("3 to leave this page");
        System.out.println();
        int entry = input.nextInt();
        if (entry == 1) {
            viewGenres();
        } else if (entry == 2) {
            Bill.viewBillPart1();
            int pay = input.nextInt();
            if (pay == 1) {
                enterAddress();
            } else {
                mainMenu();
            }
        }
        if (entry == 3) {
            System.out.println("Thank you for visiting Aman's Bookstore!");
            System.out.println("We hope to see you again soon. Goodbye!");
            System.exit(0);
        }
    }

    //EFFECTS: Displays the various genres available to the user
    private void viewGenres() {
        System.out.println("Select desired genre from the list below:");
        for (int i = 1; i <= NO_OF_GENRES; i++) {
            System.out.print(i + ".");
            System.out.printf(GENRES[i - 1]);
            System.out.println();
        }
        System.out.println("5.Go back to main menu");
        int entry = input.nextInt();
        if (entry == 1) {
            showActionBooks();
        } else if (entry == 2) {
            showComicBooks();
        } else if (entry == 3) {
            showMysteryBooks();
        } else if (entry == 4) {
            showDramaBooks();
        } else {
            mainMenu();
        }
    }

    private void showActionBooks() {
        System.out.println("Select desired book from the list below.");
        System.out.println("The corresponding prices (CAD) are given alongside:");
        for (int i = 1;i <= NO_OF_ACTIONBOOKS;i++) {
            System.out.print(i + ". " + ACTIONBOOKS[i - 1].getName());
            System.out.println(" (" + ACTIONBOOKS[i - 1].getPrice() + ")");
        }
        System.out.println("Enter 5 to go back to the main menu");

        int entry = input.nextInt();

        if (entry <= 4) {
            chooseQuantity(ACTIONBOOKS[entry - 1]);
        } else {
            mainMenu();
        }
    }

    private void showComicBooks() {
        System.out.println("Select desired book from the list below.");
        System.out.println("The corresponding prices (CAD) are given alongside:");
        for (int i = 1;i <= NO_OF_COMICBOOKS;i++) {
            System.out.print(i + ". " + COMICBOOKS[i - 1].getName());
            System.out.println(" (" + COMICBOOKS[i - 1].getPrice() + ")");
        }
        System.out.println("Enter 5 to go back to the main menu");

        int entry = input.nextInt();

        if (entry <= 4) {
            chooseQuantity(COMICBOOKS[entry - 1]);
        } else {
            mainMenu();
        }
    }

    private void showMysteryBooks() {
        System.out.println("Select desired book from the list below.");
        System.out.println("The corresponding prices (CAD) are given alongside:");
        for (int i = 1;i <= NO_OF_MYSTERYBOOKS;i++) {
            System.out.print(i + ". " + MYSTERYBOOKS[i - 1].getName());
            System.out.println(" (" + MYSTERYBOOKS[i - 1].getPrice() + ")");
        }
        System.out.println("Enter 5 to go back to the main menu");

        int entry = input.nextInt();

        if (entry <= 4) {
            chooseQuantity(MYSTERYBOOKS[entry - 1]);
        } else {
            mainMenu();
        }
    }

    private void showDramaBooks() {
        System.out.println("Select desired book from the list below.");
        System.out.println("The corresponding prices (CAD) are given alongside:");
        for (int i = 1;i <= NO_OF_DRAMABOOKS;i++) {
            System.out.print(i + ". " + DRAMABOOKS[i - 1].getName());
            System.out.println(" (" + DRAMABOOKS[i - 1].getPrice() + ")");
        }
        System.out.println("Enter 5 to go back to the main menu");

        int entry = input.nextInt();

        if (entry <= 4) {
            chooseQuantity(DRAMABOOKS[entry - 1]);
        } else {
            mainMenu();
        }
    }

    private void chooseQuantity(Book book) {
        System.out.println("Enter number of books:");
        int entry2 = input.nextInt();
        addToCart(book, entry2);
        System.out.println("Book(s) have successfully been added to your cart");
        mainMenu();
    }

    public void enterAddress() {
        System.out.println("Please enter your Address");
        Customer.setAddress(input.nextLine());
        toPay();
    }

    private void toPay() {
        System.out.println("Please enter your 16 digit credit card number");
        String creditCardNumber = input.next();
        System.out.println("Please enter your 3 digit CVV number");
        String cvv = input.next();
        System.out.println("Your account has been debited.");
        System.out.print("Your purchase will be available for pick up from our nearest " + Customer.getDeliveryCity());
        System.out.println(" outlet in 3 days");
        System.out.println("Thank you for visiting!!!");
    }

}

