package ua.khpi.oop.lab10.container;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab10.model.Podcast;
import static org.junit.jupiter.api.Assertions.*;

class MediaContainerTest {

    @Test
    void testAddAndGet() {
        // перевірка додавання
        MediaContainer<String> container = new MediaContainer<>();
        container.add("тест1");
        container.add("тест2");

        assertEquals(2, container.size());
        assertEquals("тест1", container.get(0));
    }

    @Test
    void testRemove() {
        // перевірка видалення
        MediaContainer<Integer> container = new MediaContainer<>();
        container.add(10);
        container.add(20);
        int removed = container.remove(0);

        assertEquals(10, removed);
        assertEquals(1, container.size());
        assertEquals(20, container.get(0));
    }

    @Test
    void testIterator() {
        // перевірка ітератора
        MediaContainer<Podcast> container = new MediaContainer<>();
        container.add(new Podcast("новини", "олег"));

        int count = 0;
        for (Podcast p : container) {
            assertNotNull(p);
            count++;
        }
        assertEquals(1, count);
    }
}