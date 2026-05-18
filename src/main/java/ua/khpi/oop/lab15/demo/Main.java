package ua.khpi.oop.lab15.demo;

import ua.khpi.oop.lab15.model.PlayerAccount;
import ua.khpi.oop.lab15.model.Reward;
import ua.khpi.oop.lab15.task.RewardTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("лабораторна робота 15. варіант 9. Николенко Вероніка\n");

        int threadsCount = 4;
        int iterations = 100_000;
        Reward reward = new Reward(1); // 1 одиниця досвіду за раз
        int expectedTotal = threadsCount * iterations * reward.getAmount();

        PlayerAccount account = new PlayerAccount("gamer999");

        // 1. демонстрація стану перегонів (небезпечно)
        System.out.println("1. запуск без синхронізації (unsafe)...");
        runThreads(account, reward, threadsCount, iterations, false);
        System.out.println("очікуваний досвід: " + expectedTotal);
        System.out.println("фактичний досвід:  " + account.getExperience());
        System.out.println("втрачено досвіду:  " + (expectedTotal - account.getExperience()) + "\n");

        // 2. демонстрація коректної роботи (безпечно)
        account.reset();
        System.out.println("2. запуск із синхронізацією (safe)...");
        runThreads(account, reward, threadsCount, iterations, true);
        System.out.println("очікуваний досвід: " + expectedTotal);
        System.out.println("фактичний досвід:  " + account.getExperience());
        System.out.println("втрачено досвіду:  " + (expectedTotal - account.getExperience()) + "\n");

        // 3. порівняння часу
        measureTime();
    }

    private static void runThreads(PlayerAccount account, Reward reward, int threadsCount, int iterations, boolean safe) throws InterruptedException {
        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Thread(new RewardTask(account, reward, iterations, safe));
        }

        for (Thread t : threads) { t.start(); }
        for (Thread t : threads) { t.join(); }
    }

    private static void measureTime() throws InterruptedException {
        System.out.println("3. вимірювання продуктивності...");
        int totalOps = 400_000;
        Reward rew = new Reward(1);

        // послідовне виконання в одному потоці
        PlayerAccount accSeq = new PlayerAccount("seq");
        long startSeq = System.nanoTime();
        for (int i = 0; i < totalOps; i++) {
            accSeq.addExperienceSafe(rew.getAmount());
        }
        long timeSeq = (System.nanoTime() - startSeq) / 1_000_000;
        System.out.println("послідовне виконання: " + timeSeq + " мс");

        // паралельне виконання (4 потоки)
        PlayerAccount accPar = new PlayerAccount("par");
        long startPar = System.nanoTime();
        runThreads(accPar, rew, 4, 100_000, true);
        long timePar = (System.nanoTime() - startPar) / 1_000_000;
        System.out.println("паралельне виконання: " + timePar + " мс");

        System.out.println("примітка: для таких коротких операцій блокування монітора");
        System.out.println("робить паралельний код часто повільнішим за послідовний.");
    }
}