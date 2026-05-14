package ua.khpi.oop.lab12.demo;

import ua.khpi.oop.lab12.model.*;
import ua.khpi.oop.lab12.service.MedicalRecordService;
import java.util.Arrays;

// демонстрація роботи програми
public class Main {
    public static void main(String[] args) {
        // створення тестових даних
        Patient p1 = new Patient("олег");
        Patient p2 = new Patient("марія");

        Prescription pr1 = new Prescription("аспірин");
        Prescription pr2 = new Prescription("вітамін с");

        Visit v1 = new Visit(p1, VisitType.CONSULTATION, 30, Arrays.asList(pr1));
        Visit v2 = new Visit(p2, VisitType.EXAMINATION, 45, Arrays.asList(pr2));
        Visit v3 = new Visit(p1, VisitType.TREATMENT, 60, Arrays.asList(pr1, pr2));

        MedicalRecordService service = new MedicalRecordService(Arrays.asList(v1, v2, v3));

        // виведення результатів обробки stream api
        System.out.println("візити типу consultation:");
        service.getVisitsByType(VisitType.CONSULTATION).forEach(System.out::println);

        System.out.println("\nімена пацієнтів:");
        service.getUniquePatientNamesSorted().forEach(System.out::println);

        System.out.println("\nзагальний час візитів: " + service.getTotalDurationMinutes() + " хв");

        System.out.println("\nунікальні ліки для олега:");
        service.getMedicationsForPatient(p1).forEach(System.out::println);
    }
}