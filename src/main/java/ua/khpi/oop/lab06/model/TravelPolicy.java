package ua.khpi.oop.lab06.model;

public class TravelPolicy extends InsurancePolicy {
    private final String destination;

    public TravelPolicy(String policyId, String clientName, boolean active, String destination) {
        super(policyId, clientName, active);
        this.destination = destination;
    }

    @Override
    public String calculateCoverage() {
        return active ? "Travel coverage for: " + destination : "No travel coverage";
    }
}