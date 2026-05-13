package ua.khpi.oop.lab08.model;

public class InternshipLetter extends UniversityDocument {
    private final String companyName;

    public InternshipLetter(String documentId, String companyName) {
        super(documentId);
        this.companyName = companyName;
    }

    @Override
    public String toTextLine() {
        return "InternshipLetter;" + documentId + ";" + companyName;
    }

    @Override
    public String toString() {
        return "направлення на практику [" + documentId + "] до: " + companyName;
    }
}