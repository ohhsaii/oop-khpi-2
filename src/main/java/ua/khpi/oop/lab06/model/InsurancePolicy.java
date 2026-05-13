package ua.khpi.oop.lab06.model;

// абстрактний базовий клас зі спільним станом [cite: 79, 81]
public abstract class InsurancePolicy {
    protected final String policyId;
    protected final String clientName;
    protected boolean active;

    protected InsurancePolicy(String policyId, String clientName, boolean active) {
        this.policyId = policyId; // ініціалізація спільного стану [cite: 82, 111]
        this.clientName = clientName;
        this.active = active;
    }

    public String summary() {
        return "Policy: " + policyId + ", Client: " + clientName + ", Active: " + active;
    }

    // абстрактний метод для поліморфної операції [cite: 84, 198]
    public abstract String calculateCoverage();
}