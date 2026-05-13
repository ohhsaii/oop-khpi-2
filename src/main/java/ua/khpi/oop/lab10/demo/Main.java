package ua.khpi.oop.lab10.demo;

import ua.khpi.oop.lab10.model.*;
import ua.khpi.oop.lab10.container.JournalContainer;

public class Main {
    public static void main(String[] args) {
        // створюємо контейнер для тренувань
        JournalContainer<Workout> workoutJournal = new JournalContainer<>();

        // додаємо елементи у наш контейнер
        workoutJournal.add(new Workout("ранкова пробіжка"));
        workoutJournal.add(new Workout("силове тренування"));
        workoutJournal.add(new Workout("розтяжка"));

        System.out.println("кількість тренувань у журналі: " + workoutJournal.size());

        // перебираємо елементи за допомогою циклу for-each
        // це працює саме завдяки тому, що ми реалізували інтерфейс iterable та написали свій ітератор
        System.out.println("список тренувань:");
        for (Workout w : workoutJournal) {
            System.out.println(w);
        }

        // перевірка роботи з іншим типом
        JournalContainer<Exercise> exerciseJournal = new JournalContainer<>();
        exerciseJournal.add(new Exercise("присідання"));
        exerciseJournal.add(new Exercise("віджимання"));

        System.out.println("\nкількість вправ: " + exerciseJournal.size());
        for (Exercise e : exerciseJournal) {
            System.out.println(e);
        }
    }
}