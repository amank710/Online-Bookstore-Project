package model;

// Stores the name of the cities that can be delivered to. Also sets and gets the desired city for delivery
public class City {
    private String cityName;
    private Double deliveryCharge;
    public static final int NO_OF_CITIES = 5;
    public static final City VANCOUVER = new City("Vancouver",1.00);
    public static final City TORONTO = new City("Toronto",2.00);
    public static final City OTTAWA = new City("Ottawa",2.00);
    public static final City EDMONTON = new City("Edmonton",1.50);
    public static final City CALGARY = new City("Calgary",1.20);

    public static final City[] DELIVERYCITIES = new City[] {VANCOUVER,TORONTO,OTTAWA,EDMONTON,CALGARY};

    //REQUIRES: A 0 or positive number for charge
    //EFFECTS: Sets the name of the city to String name, and initialises the delivery charge to that city
    City(String name, Double charge) {
        cityName = name;
        deliveryCharge = charge;
    }

    public String getCityName() {
        return cityName;
    }

    public Double getDeliveryCharge() {
        return deliveryCharge;
    }
}
