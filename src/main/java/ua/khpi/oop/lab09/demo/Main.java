package ua.khpi.oop.lab09.demo;

import ua.khpi.oop.lab09.model.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // створення сутностей
        Workout morningCardio = new Workout("ранкове кардіо");
        Exercise pushUps = new Exercise("віджимання");

        // використання узагальненого класу з різними типами (String та Integer)
        ProgressEntry<Workout, String> workoutProgress = new ProgressEntry<>(morningCardio, "виконано відмінно");
        ProgressEntry<Exercise, Integer> exerciseProgress = new ProgressEntry<>(pushUps, 50);

        System.out.println(workoutProgress);
        System.out.println(exerciseProgress);

        // використання узагальненого методу з числами
        List<Integer> calories = Arrays.asList(300, 450, 200, 500);
        Integer maxCalories = FitnessAnalyzer.findBestResult(calories);
        System.out.println("найбільше спалено калорій: " + maxCalories);

        // використання узагальненого методу з рядками
        List<String> levels = Arrays.asList("аматор", "професіонал", "новачок");
        String bestLevel = FitnessAnalyzer.findBestResult(levels);
        System.out.println("найвищий рівень (за алфавітом): " + bestLevel);
    }
}