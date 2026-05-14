package ua.khpi.oop.lab14.threads;

import ua.khpi.oop.lab14.model.Document;
import ua.khpi.oop.lab14.model.Employee;

public class RoutePreparationTask implements Runnable {
    private final Document document;
    private final Employee manager;

    public RoutePreparationTask(Document document, Employee manager) {
        this.document = document;
        this.manager = manager;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] готуємо маршрут для " + document.getId());
        try {
            // імітація підготовки маршруту
            Thread.sleep(1200);
            System.out.println("[" + threadName + "] маршрут готовий. відповідальний: " + manager);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}