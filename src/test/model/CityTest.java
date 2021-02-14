package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {
    City QuebecCity;
    @BeforeEach
    void runBefore() {
        QuebecCity = new City("Quebec City",2.50);
    }

    @Test
    void testConstructor(){
        City Vancouver = new City("Vancouver",1.00);
        assertEquals("Vancouver",Vancouver.getCityName());
        assertEquals(1.00,Vancouver.getDeliveryCharge());
    }
}
