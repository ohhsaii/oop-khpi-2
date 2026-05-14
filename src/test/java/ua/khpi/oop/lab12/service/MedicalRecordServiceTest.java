package ua.khpi.oop.lab12.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab12.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

// модульні тести для перевірки stream-операцій
class MedicalRecordServiceTest {
    private MedicalRecordService service;
    private Patient p1;

    @BeforeEach
    void setUp() {
        p1 = new Patient("іван");
        Patient p2 = new Patient("анна");
        Prescription pr1 = new Prescription("парацетамол");

        Visit v1 = new Visit(p1, VisitType.CONSULTATION, 20, Arrays.asList(pr1));
        Visit v2 = new Visit(p2, VisitType.TREATMENT, 40, Arrays.asList());

        service = new MedicalRecordService(Arrays.asList(v1, v2));
    }

    @Test
    void testGetVisitsByType() {
        List<Visit> result = service.getVisitsByType(VisitType.CONSULTATION);
        assertEquals(1, result.size());
    }

    @Test
    void testGetUniquePatientNamesSorted() {
        List<String> names = service.getUniquePatientNamesSorted();
        assertEquals(2, names.size());
        assertEquals("анна", names.get(0));
    }

    @Test
    void testGroupVisitsByType() {
        Map<VisitType, List<Visit>> grouped = service.groupVisitsByType();
        assertTrue(grouped.containsKey(VisitType.TREATMENT));
    }

    @Test
    void testGetTotalDurationMinutes() {
        assertEquals(60, service.getTotalDurationMinutes());
    }

    @Test
    void testGetMedicationsForPatient() {
        List<String> meds = service.getMedicationsForPatient(p1);
        assertEquals(1, meds.size());
        assertEquals("парацетамол", meds.get(0));
    }
}