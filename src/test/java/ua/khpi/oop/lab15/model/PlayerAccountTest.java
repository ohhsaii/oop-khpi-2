package ua.khpi.oop.lab15.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerAccountTest {

    @Test
    void testSafeExperienceAddition() {
        PlayerAccount account = new PlayerAccount("tester");
        account.addExperienceSafe(150);

        assertEquals(150, account.getExperience(), "досвід має додаватися правильно");
    }

    @Test
    void testReset() {
        PlayerAccount account = new PlayerAccount("tester");
        account.addExperienceSafe(100);
        account.reset();

        assertEquals(0, account.getExperience(), "рахунок має обнулятися");
    }
}