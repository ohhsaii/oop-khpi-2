package ua.khpi.oop.lab08.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ua.khpi.oop.lab08.model.UniversityDocument;

// клас для зберігання списку документів у пам'яті
public class UniversityDocumentRegistry implements Serializable {
    private final List<UniversityDocument> documents = new ArrayList<>();

    public void addDocument(UniversityDocument document) {
        documents.add(document);
    }

    public List<UniversityDocument> getDocuments() {
        return documents;
    }
}