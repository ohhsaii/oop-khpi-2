package ua.khpi.oop.lab12.service;

import ua.khpi.oop.lab12.model.*;
import java.util.*;
import java.util.stream.Collectors;

// сервіс обробки записів через stream api
public class MedicalRecordService {
    private final List<Visit> visits;

    public MedicalRecordService(List<Visit> visits) {
        this.visits = new ArrayList<>(visits);
    }

    // 1. filter + tolist: пошук візитів за типом
    public List<Visit> getVisitsByType(VisitType type) {
        return visits.stream()
                .filter(v -> v.getType() == type)
                .collect(Collectors.toList());
    }

    // 2. map + sorted + distinct: унікальні імена пацієнтів за алфавітом
    public List<String> getUniquePatientNamesSorted() {
        return visits.stream()
                .map(v -> v.getPatient().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    // 3. groupingby: групування візитів за типом
    public Map<VisitType, List<Visit>> groupVisitsByType() {
        return visits.stream()
                .collect(Collectors.groupingBy(Visit::getType));
    }

    // 4. maptoint + sum: загальна тривалість усіх візитів
    public int getTotalDurationMinutes() {
        return visits.stream()
                .mapToInt(Visit::getDurationMinutes)
                .sum();
    }

    // 5. flatmap + collect: усі призначені ліки для конкретного пацієнта (складний конвеєр)
    public List<String> getMedicationsForPatient(Patient patient) {
        return visits.stream()
                .filter(v -> v.getPatient().equals(patient))
                .flatMap(v -> v.getPrescriptions().stream())
                .map(Prescription::getMedicationName)
                .distinct()
                .collect(Collectors.toList());
    }
}