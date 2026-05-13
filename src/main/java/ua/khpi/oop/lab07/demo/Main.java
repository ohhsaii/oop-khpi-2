package ua.khpi.oop.lab07.demo;

import ua.khpi.oop.lab07.contracts.*;
import ua.khpi.oop.lab07.model.*;

public class Main {
    public static void main(String[] args) {
        // обробка через інтерфейс Printable
        Printable[] printableItems = {
                new TranscriptRequest("nikolenko veronika"),
                new EnrollmentCertificate("cert-09")
        };

        for (Printable p : printableItems) {
            System.out.println(p.print());
        }

        // обробка через інтерфейс Archivable
        Archivable[] archivableItems = {
                new InternshipLetter("google kharkiv"),
                new EnrollmentCertificate("cert-09")
        };

        for (Archivable a : archivableItems) {
            System.out.println(a.archive());
        }
    }
}