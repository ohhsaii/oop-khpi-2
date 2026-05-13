package ua.khpi.oop.lab06.model;

public class HealthPolicy extends InsurancePolicy {
    private final String hospitalNetwork;

    public HealthPolicy(String policyId, String clientName, boolean active, String hospitalNetwork) {
        super(policyId, clientName, active); // виклик конструктора базового типу [cite: 142]
        this.hospitalNetwork = hospitalNetwork;
    }

    @Override // перевизначення спільного контракту [cite: 130, 152]
    public String calculateCoverage() {
        return active ? "Health coverage for network: " + hospitalNetwork : "No health coverage";
    }
}