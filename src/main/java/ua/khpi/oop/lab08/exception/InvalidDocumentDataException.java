package ua.khpi.oop.lab08.exception;

// користувацький виняток для помилок формату даних [cite: 6561, 6564]
public class InvalidDocumentDataException extends Exception {
    public InvalidDocumentDataException(String message) {
        super(message);
    }

    public InvalidDocumentDataException(String message, Throwable cause) {
        super(message, cause);
    }
}