package ua.khpi.oop.lab05.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GamingLaptopTest {

    @Test
    void testInheritedAndOwnState() {
        // перевірка ініціалізації полів
        GamingLaptop laptop = new GamingLaptop("Asus", 1500.0, "Intel i7", 80.0, "RTX 3060");

        assertEquals("Asus", laptop.getName());
        assertEquals(1500.0, laptop.getPrice());
        assertEquals("Intel i7", laptop.getProcessor());
        assertEquals(80.0, laptop.getBatteryCapacity());
        assertEquals("RTX 3060", laptop.getGpu());
    }

    @Test
    void testDescriptionOverrides() {
        // перевірка роботи перевизначеного методу
        GamingLaptop laptop = new GamingLaptop("MSI", 2000.0, "Intel i9", 99.9, "RTX 4090");
        String expected = "Product: MSI, price: 2000.0, processor: Intel i9, battery: 99.9Wh, GPU: RTX 4090";

        assertEquals(expected, laptop.description());
    }
}