package ua.khpi.oop.lab12.model;

import java.util.Objects;

// клас медичного рецепта
public class Prescription {
    private final String medicationName;

    public Prescription(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationName() {
        return medicationName;
    }

    @Override
    public String toString() {
        return medicationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(medicationName, that.medicationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationName);
    }
}