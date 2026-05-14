package ua.khpi.oop.lab10.model;

// клас подкасту
public class Podcast {
    private final String title;
    private final String host;

    public Podcast(String title, String host) {
        this.title = title;
        this.host = host;
    }

    @Override
    public String toString() {
        return "подкаст: " + title + " (ведучий: " + host + ")";
    }
}