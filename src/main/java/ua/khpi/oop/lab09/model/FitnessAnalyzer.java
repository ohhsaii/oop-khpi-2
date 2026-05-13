package ua.khpi.oop.lab09.model;

import java.util.List;

public class FitnessAnalyzer {

    // узагальнений метод з обмеженням типу для пошуку найкращого результату
    public static <T extends Comparable<T>> T findBestResult(List<T> results) {
        if (results == null || results.isEmpty()) {
            return null;
        }

        T best = results.get(0);
        for (T item : results) {
            if (item.compareTo(best) > 0) {
                best = item;
            }
        }
        return best;
    }
}