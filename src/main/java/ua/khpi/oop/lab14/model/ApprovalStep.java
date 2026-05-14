package ua.khpi.oop.lab14.model;

public class ApprovalStep {
    private final Document document;
    private final Employee approver;
    private boolean isApproved;

    public ApprovalStep(Document document, Employee approver) {
        this.document = document;
        this.approver = approver;
        this.isApproved = false;
    }

    public void approve() {
        this.isApproved = true;
    }

    @Override
    public String toString() {
        // статус етапу погодження
        return "етап погодження: " + document.getId() + ", відповідальний: " + approver + ", погоджено: " + isApproved;
    }
}