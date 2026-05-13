package ua.khpi.oop.lab08.persistence;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Files;
import ua.khpi.oop.lab08.exception.InvalidDocumentDataException;
import ua.khpi.oop.lab08.service.UniversityDocumentRegistry;
import ua.khpi.oop.lab08.model.TranscriptRequest;
import static org.junit.jupiter.api.Assertions.*;

class DocumentFileManagerTest {

    @Test
    void testSaveAndLoad() throws Exception {
        // перевірка збереження та читання
        UniversityDocumentRegistry registry = new UniversityDocumentRegistry();
        registry.addDocument(new TranscriptRequest("id1", "test"));

        DocumentFileManager manager = new DocumentFileManager();
        Path tempFile = Files.createTempFile("test", ".txt");

        manager.saveAsText(registry, tempFile);
        UniversityDocumentRegistry loaded = manager.loadFromText(tempFile);

        assertEquals(1, loaded.getDocuments().size());
        assertEquals("id1", loaded.getDocuments().get(0).getDocumentId());
    }

    @Test
    void testException() throws Exception {
        // перевірка чи працює наша помилка при поганих даних
        DocumentFileManager manager = new DocumentFileManager();
        Path tempFile = Files.createTempFile("bad", ".txt");
        Files.writeString(tempFile, "bad;data"); // спеціально зламаний запис

        assertThrows(InvalidDocumentDataException.class, () -> manager.loadFromText(tempFile));
    }
}