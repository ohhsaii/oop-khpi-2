package ua.khpi.oop.lab10.container;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab10.model.Exercise;
import static org.junit.jupiter.api.Assertions.*;

class JournalContainerTest {

    @Test
    void testAddAndGet() {
        // перевірка додавання та отримання елементів
        JournalContainer<String> container = new JournalContainer<>();
        container.add("перший");
        container.add("другий");

        assertEquals(2, container.size());
        assertEquals("перший", container.get(0));
        assertEquals("другий", container.get(1));
    }

    @Test
    void testIterator() {
        // перевірка роботи ітератора
        JournalContainer<Exercise> container = new JournalContainer<>();
        container.add(new Exercise("біг"));
        container.add(new Exercise("плавання"));

        int count = 0;
        for (Exercise e : container) {
            assertNotNull(e);
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    void testIndexOutOfBounds() {
        // перевірка генерації помилки при неправильному індексі
        JournalContainer<String> container = new JournalContainer<>();
        container.add("тест");

        assertThrows(IndexOutOfBoundsException.class, () -> container.get(5));
    }
}