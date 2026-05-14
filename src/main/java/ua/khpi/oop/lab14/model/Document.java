package ua.khpi.oop.lab14.model;

public class Document {
    private final String id;
    private final String title;
    private boolean isValid;

    public Document(String id, String title) {
        this.id = id;
        this.title = title;
        this.isValid = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isValid() { return isValid; }
    public void setValid(boolean valid) { isValid = valid; }

    @Override
    public String toString() {
        // статус валідності документа
        return "документ " + id + ": " + title + " (валідність: " + isValid + ")";
    }
}