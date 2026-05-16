package ua.khpi.oop.lab16;

public class ThresholdFilter {
    // звичайна java-реалізація порогової фільтрації
    public int[] filter(int[] input, int threshold) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[i] >= threshold ? 1 : 0;
        }
        return result;
    }
}