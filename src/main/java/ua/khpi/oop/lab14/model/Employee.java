package ua.khpi.oop.lab14.model;

public class Employee {
    private final String name;
    private final String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        // назва посади та ім'я
        return position + " " + name;
    }
}