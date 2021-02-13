package model;

// Represents a customer with a first name, last name and Email address
public class Customer {
    private static String firstName;
    private static String lastName;
    private static String email;
    private static Double deliveryCost;

    public static void setFirstName(String name1) {
        firstName = name1;
    }

    public static void setLastName(String name2) {
        lastName = name2;
    }

    public static void setEmail(String email) {
        Customer.email = email;
    }

    public static void setDeliveryCost(Double deliveryCost) {
        Customer.deliveryCost = deliveryCost;
    }
}
