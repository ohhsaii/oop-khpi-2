package ua.khpi.oop.lab08.model;

public class EnrollmentCertificate extends UniversityDocument {
    private final String faculty;

    public EnrollmentCertificate(String documentId, String faculty) {
        super(documentId);
        this.faculty = faculty;
    }

    @Override
    public String toTextLine() {
        return "EnrollmentCertificate;" + documentId + ";" + faculty;
    }

    @Override
    public String toString() {
        return "довідка про навчання [" + documentId + "], факультет: " + faculty;
    }
}
