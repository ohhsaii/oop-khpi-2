package ua.khpi.oop.lab14.demo;

import ua.khpi.oop.lab14.model.*;
import ua.khpi.oop.lab14.threads.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("лабораторна робота 14. варіант 9. Николенко Вероніка\n");

        List<Document> docs = Arrays.asList(
                new Document("док-1", "звіт за березень"),
                new Document("док-2", "наказ про відпустку")
        );
        Employee director = new Employee("Іванов І.І.", "директор");

        // створення об'єктів потоків
        DocumentValidationThread valThread = new DocumentValidationThread(docs);
        Thread routeThread = new Thread(new RoutePreparationTask(docs.get(0), director), "потік-маршруту");

        // запуск паралельного виконання
        valThread.start();
        routeThread.start();

        System.out.println("[main] очікуємо завершення потоків...");

        // чекаємо на результат
        valThread.join();
        routeThread.join();

        System.out.println("\n[main] всі роботи завершено");
        for (Document d : docs) {
            System.out.println("результат: " + d);
        }
    }
}