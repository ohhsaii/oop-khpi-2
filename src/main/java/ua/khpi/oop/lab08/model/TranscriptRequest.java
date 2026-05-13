package ua.khpi.oop.lab08.model;

public class TranscriptRequest extends UniversityDocument {
    private final String studentName;

    public TranscriptRequest(String documentId, String studentName) {
        super(documentId);
        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("ім'я студента обов'язкове");
        }
        this.studentName = studentName;
    }

    @Override
    public String toTextLine() {
        return "TranscriptRequest;" + documentId + ";" + studentName;
    }

    @Override
    public String toString() {
        return "виписка оцінок [" + documentId + "] для: " + studentName;
    }
}