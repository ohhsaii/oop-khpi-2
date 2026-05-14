package ua.khpi.oop.lab14.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab14.model.Document;
import static org.junit.jupiter.api.Assertions.*;

class DocumentServiceTest {
    @Test
    void testDocumentValidation() {
        DocumentService service = new DocumentService();
        Document doc = new Document("тест-1", "назва");
        // перевіряємо детерміновану логіку
        assertTrue(service.checkFormat(doc));
    }
}