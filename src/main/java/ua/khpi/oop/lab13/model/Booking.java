package ua.khpi.oop.lab13.model;

import java.time.LocalDate;

// клас для зберігання даних про одне бронювання
public class Booking {
    private final LocalDate date;
    private final String bookingNumber;
    private final String destination;
    private final BookingStatus status;

    public Booking(LocalDate date, String bookingNumber, String destination, BookingStatus status) {
        this.date = date;
        this.bookingNumber = bookingNumber;
        this.destination = destination;
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public String getDestination() {
        return destination;
    }

    public BookingStatus getStatus() {
        return status;
    }
}