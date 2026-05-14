package ua.khpi.oop.lab12.model;

import java.util.List;
import java.util.Objects;

// клас запису про візит
public class Visit {
    private final Patient patient;
    private final VisitType type;
    private final int durationMinutes;
    private final List<Prescription> prescriptions;

    public Visit(Patient patient, VisitType type, int durationMinutes, List<Prescription> prescriptions) {
        this.patient = patient;
        this.type = type;
        this.durationMinutes = durationMinutes;
        this.prescriptions = prescriptions;
    }

    public Patient getPatient() {
        return patient;
    }

    public VisitType getType() {
        return type;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    @Override
    public String toString() {
        return "візит: " + patient.getName() + " (" + type + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return durationMinutes == visit.durationMinutes &&
                Objects.equals(patient, visit.patient) &&
                type == visit.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, type, durationMinutes);
    }
}