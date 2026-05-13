package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Archivable;

public class InternshipLetter implements Archivable {
    private final String companyName;

    public InternshipLetter(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String archive() {
        return "archiving internship letter for: " + companyName;
    }
}