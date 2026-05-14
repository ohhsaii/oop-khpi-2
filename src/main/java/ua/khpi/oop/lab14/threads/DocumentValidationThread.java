package ua.khpi.oop.lab14.threads;

import ua.khpi.oop.lab14.model.Document;
import java.util.List;

public class DocumentValidationThread extends Thread {
    private final List<Document> documents;

    public DocumentValidationThread(List<Document> documents) {
        this.documents = documents;
        // ім'я потоку для діагностики
        setName("потік-валідації");
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] перевірка документів розпочата");
        try {
            for (Document doc : documents) {
                // імітуємо тривалу операцію
                Thread.sleep(800);
                doc.setValid(true);
                System.out.println("[" + getName() + "] документ " + doc.getId() + " перевірено");
            }
        } catch (InterruptedException e) {
            // обробка переривання потоку
            Thread.currentThread().interrupt();
        }
        System.out.println("[" + getName() + "] перевірка завершена");
    }
}