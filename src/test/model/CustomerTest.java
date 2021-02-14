package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    Customer testCustomer;

    @BeforeEach
    void runBefore() {
        testCustomer = new Customer();
    }

    @Test
    void testSetFirstName() {
        testCustomer.setFirstName("Aman");
        assertEquals("Aman",testCustomer.getFirstName());
    }

    @Test
    void testSetLastName() {
        testCustomer.setLastName("Khetawat");
        assertEquals("Khetawat",testCustomer.getLastName());
    }

    @Test
    void testSetEmail() {
        testCustomer.setEmail("amankhetawat710@gmail.com");
        assertEquals("amankhetawat710@gmail.com",testCustomer.getEmail());
    }

    @Test
    void testSetAddress() {
        testCustomer.setAddress("123 Pine Apartments, ABC Road, Bangalore - 560052");
        assertEquals("123 Pine Apartments, ABC Road, Bangalore - 560052",testCustomer.getAddress());
    }

    @Test
    void testSetDeliveryCost() {
        testCustomer.setDeliveryCost(1.50);
        assertEquals(1.50,testCustomer.getDeliveryCost());
    }

    @Test
    void testSetDeliveryCity() {
        City QuebecCity = new City("Quebec City",2.50);
        testCustomer.setDeliveryCity(QuebecCity);
        assertEquals(QuebecCity,testCustomer.getDeliveryCity());
    }
}
