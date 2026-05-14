package ua.khpi.oop.lab14.service;

import ua.khpi.oop.lab14.model.Document;

public class DocumentService {
    // перевірка формату назви документа
    public boolean checkFormat(Document doc) {
        return doc.getTitle() != null && !doc.getTitle().isEmpty();
    }
}