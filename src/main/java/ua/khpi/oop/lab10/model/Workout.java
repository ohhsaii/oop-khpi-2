package ua.khpi.oop.lab10.model;

// клас тренування
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