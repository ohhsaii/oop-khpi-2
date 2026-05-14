package ua.khpi.oop.lab12.model;

import java.util.Objects;

// клас пацієнта
public class Patient {
    private final String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}