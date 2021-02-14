package ui;

import model.Cart;
import model.Customer;


import static model.Cart.getBooksInCart;

// Produces the Bill based on items in the cart
public class Bill {
    private static double rawAmount;
    private static double discountedPrice;

    //EFFECTS: Prints the first 1/3rd of the Bill
    public static void viewBillPart1() {
        rawAmount = 0.0;
        discountedPrice = 0.0;
        System.out.println("                    Aman's Online Bookstore                 ");
        System.out.println(Customer.getFirstName() + " " + Customer.getLastName());
        System.out.println("                                           BILL                                          ");
        System.out.println("*****************************************************************************************");
        System.out.println();
        System.out.printf("%-45s", "Item");
        System.out.printf("%-20s", "Unit Price");
        System.out.printf("%-20s", "Quantity");
        System.out.printf("%-20s", "Total");
        System.out.println();
        for (int i = 0; i < getBooksInCart().size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.printf("%-45s", getBooksInCart().get(i).getName());
            System.out.printf("%-20s", getBooksInCart().get(i).getPrice());
            System.out.printf("%-18s", getBooksInCart().get(i).getQuantity());
            double total = getBooksInCart().get(i).getPrice() * getBooksInCart().get(i).getQuantity();
            System.out.printf("%-20s", total);
            rawAmount = rawAmount + total;
            System.out.println();
        }
        viewBillPart2();
    }

    //EFFECTS: Prints the second 1/3rd of the Bill
    public static void viewBillPart2() {
        System.out.println("*****************************************************************************************");
        System.out.printf("%-24s", "Total = ");
        System.out.print("CAD ");
        System.out.printf("%-24.2f", rawAmount);
        System.out.println();
        System.out.printf("%-24s", "Discount = ");
        System.out.print("CAD ");
        double discountAwarded = Cart.discount(rawAmount);
        System.out.printf("%-24.2f", discountAwarded);
        System.out.println();
        discountedPrice = rawAmount - discountAwarded;
        System.out.printf("%-24s", "Discounted Total = ");
        System.out.print("CAD ");
        System.out.printf("%-24.2f", discountedPrice);
        viewBillPart3();
    }

    //EFFECTS: Prints the third 1/3rd of the Bill
    public static void viewBillPart3() {
        System.out.println();
        System.out.printf("%-24s", "Sales Tax = ");
        System.out.print("CAD ");
        System.out.printf("%-24.2f", 0.12 * discountedPrice);
        System.out.println();
        System.out.printf("%-24s", "Freight charges = ");
        System.out.print("CAD ");
        System.out.printf(Customer.getDeliveryCost() + "");
        System.out.println();
        System.out.printf("%-24s", "Amount payable = ");
        System.out.print("CAD ");
        double finalAmount = discountedPrice + Customer.getDeliveryCity().getDeliveryCharge() + 0.12 * discountedPrice;
        System.out.printf("%-24.2f", finalAmount);
        System.out.println();
        System.out.println("*****************************************************************************************");
        System.out.println("To pay now press 1. To return to main menu press 2.");
    }
}
