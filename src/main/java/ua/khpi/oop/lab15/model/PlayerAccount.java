package ua.khpi.oop.lab15.model;

public class PlayerAccount {
    private final String username;
    private int experience = 0;

    public PlayerAccount(String username) {
        this.username = username;
    }

    // небезпечний метод без синхронізації
    // розбито на кроки, щоб штучно збільшити шанс стану перегонів
    public void addExperienceUnsafe(int amount) {
        int currentExp = experience;
        int newExp = currentExp + amount;
        experience = newExp;
    }

    // безпечний метод із синхронізацією (критична секція)
    public synchronized void addExperienceSafe(int amount) {
        experience += amount;
    }

    public int getExperience() {
        return experience;
    }

    public void reset() {
        experience = 0;
    }

    public String getUsername() {
        return username;
    }
}