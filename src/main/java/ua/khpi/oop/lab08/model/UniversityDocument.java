package ua.khpi.oop.lab08.model;

import java.io.Serializable;

// базовий клас для документів, підтримує серіалізацію
public abstract class UniversityDocument implements Serializable {
    protected String documentId;

    public UniversityDocument(String documentId) {
        if (documentId == null || documentId.isBlank()) {
            throw new IllegalArgumentException("ідентифікатор не може бути порожнім");
        }
        this.documentId = documentId;
    }

    public String getDocumentId() {
        return documentId;
    }

    // метод для перетворення об'єкта в рядок тексту для файлу
    public abstract String toTextLine();
}