package ua.khpi.oop.lab10.model;

// клас фільму
public class Movie {
    private final String title;
    private final String director;

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    @Override
    public String toString() {
        return "фільм: " + title + " (режисер: " + director + ")";
    }
}