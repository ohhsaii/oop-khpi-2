package ua.khpi.oop.lab06.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InsurancePolicyTest {

    @Test
    void testPolymorphism() {
        // перевірка поліморфної поведінки
        InsurancePolicy health = new HealthPolicy("h-1", "veronika", true, "clinic");
        assertEquals("Health coverage for network: clinic", health.calculateCoverage());
    }
}