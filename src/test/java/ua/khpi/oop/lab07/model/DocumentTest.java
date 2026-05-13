package ua.khpi.oop.lab07.model;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab07.contracts.Archivable;
import ua.khpi.oop.lab07.contracts.Printable;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DocumentTest {
    @Test
    void testMultipleImplementation() {
        // перевірка що сертифікат підтримує обидва контракти
        EnrollmentCertificate cert = new EnrollmentCertificate("test-01");

        assertTrue(cert instanceof Printable);
        assertTrue(cert instanceof Archivable);
    }
}
