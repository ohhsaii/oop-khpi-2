package ua.khpi.oop.lab09.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GenericComponentsTest {

    @Test
    void testProgressEntry() {
        // перевірка збереження правильних типів у записі
        Exercise pullUps = new Exercise("підтягування");
        ProgressEntry<Exercise, Integer> entry = new ProgressEntry<>(pullUps, 15);

        assertEquals(pullUps, entry.getEntity());
        assertEquals(15, entry.getValue());
    }

    @Test
    void testFitnessAnalyzer() {
        // перевірка пошуку найкращого результату
        List<Integer> results = Arrays.asList(10, 50, 30);
        assertEquals(50, FitnessAnalyzer.findBestResult(results));
    }
}