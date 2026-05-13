package ua.khpi.oop.lab10.model;

// клас вправи
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