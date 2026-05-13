package ua.khpi.oop.lab09.model;

public class Exercise {
    private final String name;

    public Exercise(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "вправа: " + name;
    }
}