package model;

// Represents a customer with a first name, last name, Email address, city they want the books delivered to,
// cost of that delivery, address they want the books delivered to.
public class Customer {
    private static String firstName;
    private static String lastName;
    private static String email;
    private static City deliveryCity;
    private static Double deliveryCost;
    private static String address;

    public static void setFirstName(String name1) {
        firstName = name1;
    }

    public void setLastName(String name2) {
        lastName = name2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeliveryCost(Double deliveryCost) {
        Customer.deliveryCost = deliveryCost;
    }

    public void setDeliveryCity(City deliveryCity) {
        Customer.deliveryCity = deliveryCity;
        setDeliveryCost(deliveryCity.getDeliveryCharge());
    }

    public static void setAddress(String address) {
        Customer.address = address;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }


    public static Double getDeliveryCost() {
        return deliveryCost;
    }

    public static City getDeliveryCity() {
        return deliveryCity;
    }


    public static String getEmail() {
        return email;
    }

    public static String getAddress() {
        return address;
    }
}
