package ua.khpi.oop.lab11.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab11.model.*;
import static org.junit.jupiter.api.Assertions.*;

class DocumentServiceTest {

    @Test
    void testQueueAndHistory() {
        DocumentService service = new DocumentService();
        Document doc = new Document("d1", "тест");
        Employee emp = new Employee("тестувальник");

        service.registerDocument(doc);
        assertEquals(1, service.getPendingCount());

        service.processNext(emp, "ок");
        assertEquals(0, service.getPendingCount());
        assertEquals(1, service.getHistory(doc).size());
    }
}