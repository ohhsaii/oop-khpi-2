package ua.khpi.oop.lab09.model;

public class Workout {
    private final String title;

    public Workout(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "тренування: " + title;
    }
}