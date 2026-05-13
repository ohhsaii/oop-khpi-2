package ua.khpi.oop.lab06.model;

public class VehiclePolicy extends InsurancePolicy {
    private final String vehicleNumber;

    public VehiclePolicy(String policyId, String clientName, boolean active, String vehicleNumber) {
        super(policyId, clientName, active);
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String calculateCoverage() {
        return active ? "Vehicle insurance for: " + vehicleNumber : "No vehicle insurance";
    }
}