package ui;

import model.*;

import java.util.Scanner;

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
        System.out.println("On total bill price over CAD 32.00 get 20% off!");
        System.out.println();
        System.out.println("Hurry, offer stands only for a limited time!!!");
        System.out.println();
        System.out.println();
        System.out.println();
        enterFirstName();
    }

    private void enterFirstName() {

        l: while (true) {
            int count1 = 0;
            String firstNameCopy = "";
            p: while (true) {
                System.out.println("Enter First Name");
                firstName = input.nextLine();
                firstNameCopy = firstName.toLowerCase();
                q: for (int m = 0; m < firstName.length(); m++) {
                    if ((firstNameCopy.charAt(m) <= 122 && firstNameCopy.charAt(m) >= 97)) {
                        count1++;
                    } else {
                        System.out.println("Enter letters only. No special characters or numbers allowed. Try again");
                        count1 = 0;
                        break q;
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

    private void enterLastName() {

        l: while (true) {
            int count1 = 0;
            String lastNameCopy = "";
            p: while (true) {
                System.out.println("Enter Last Name");
                lastName = input.nextLine();
                lastNameCopy = lastName.toLowerCase();
                q: for (int m = 0; m < lastName.length(); m++) {
                    if ((lastNameCopy.charAt(m) <= 122 && lastNameCopy.charAt(m) >= 97)) {
                        count1++;
                    } else {
                        System.out.println("Enter letters only. No special characters or numbers allowed. Try again");
                        count1 = 0;
                        break q;
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

    private void enterEmail() {

        System.out.println("Please enter your Email address:");
        Customer.setEmail(input.nextLine());
        toShip();
    }

    void toShip() {
        System.out.println("Please enter the number corresponding to the city for us to ship your products to:");
        System.out.println("The delivery charges (CAD) are also listed alongside.");
        for (int i = 1; i <= NO_OF_CITIES; i++) {
            System.out.print(i + ". " + DELIVERYCITIES[i - 1].getCityName());
            System.out.println(" (" + DELIVERYCITIES[i - 1].getDeliveryCharge() + ")");
        }

        int entry = input.nextInt();

        Customer.setDeliveryCost(DELIVERYCITIES[entry - 1].getDeliveryCharge());

    }
}
