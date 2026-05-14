package ua.khpi.oop.lab11.model;

public class ApprovalStep {
    private final Employee approver;
    private final String resolution;

    public ApprovalStep(Employee approver, String resolution) {
        this.approver = approver;
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return approver.getName() + " > " + resolution;
    }
}