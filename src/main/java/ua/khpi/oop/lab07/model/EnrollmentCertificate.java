package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Archivable;
import ua.khpi.oop.lab07.contracts.Printable;

public class EnrollmentCertificate implements Printable, Archivable {
    private final String certificateId;

    public EnrollmentCertificate(String certificateId) {
        this.certificateId = certificateId;
    }

    @Override
    public String print() {
        return "printing enrollment certificate id: " + certificateId;
    }

    @Override
    public String archive() {
        return "archiving enrollment certificate id: " + certificateId;
    }
}