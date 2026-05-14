package ua.khpi.oop.lab11.model;

import java.util.Objects;

public class Document {
    private final String docId;
    private final String title;

    public Document(String docId, String title) {
        this.docId = docId;
        this.title = title;
    }

    public String getDocId() {
        return docId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(docId, document.docId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId);
    }

    @Override
    public String toString() {
        return "документ [" + docId + "] '" + title + "'";
    }
}