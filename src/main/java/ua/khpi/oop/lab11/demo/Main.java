package ua.khpi.oop.lab11.demo;

import ua.khpi.oop.lab11.model.*;
import ua.khpi.oop.lab11.service.DocumentService;

public class Main {
    public static void main(String[] args) {
        DocumentService service = new DocumentService();
        Employee director = new Employee("директор");
        Employee manager = new Employee("менеджер");

        Document doc1 = new Document("d-1", "наказ про відпустку");
        Document doc2 = new Document("d-2", "звіт за місяць");

        service.registerDocument(doc1);
        service.registerDocument(doc2);

        System.out.println("документів у черзі: " + service.getPendingCount());

        service.processNext(manager, "погоджено");
        service.processNext(director, "затверджено");

        System.out.println("документів у черзі після обробки: " + service.getPendingCount());

        System.out.println("\nісторія погоджень для першого документа:");
        for (ApprovalStep step : service.getHistory(doc1)) {
            System.out.println(step);
        }
    }
}