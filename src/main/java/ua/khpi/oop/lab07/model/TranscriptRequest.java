package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Printable;

public class TranscriptRequest implements Printable {
    private final String studentName;

    public TranscriptRequest(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String print() {
        return "printing transcript request for student: " + studentName;
    }
}