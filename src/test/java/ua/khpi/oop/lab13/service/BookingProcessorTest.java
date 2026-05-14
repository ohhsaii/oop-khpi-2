package ua.khpi.oop.lab13.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab13.model.Booking;
import ua.khpi.oop.lab13.model.BookingStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// модульні тести для перевірки логіки обробки
class BookingProcessorTest {

    private final BookingProcessor processor = new BookingProcessor();

    @Test
    void testNormalizeWhitespace() {
        String result = processor.normalize("  2026-05-15   BK-123   Paris   CONFIRMED  ");
        assertEquals("2026-05-15 BK-123 Paris CONFIRMED", result);
    }

    @Test
    void testParseValidLine() {
        Booking booking = processor.parseLine("2026-05-15 BK-12345 London PENDING");
        assertEquals("BK-12345", booking.getBookingNumber());
        assertEquals("London", booking.getDestination());
        assertEquals(BookingStatus.PENDING, booking.getStatus());
    }

    @Test
    void testRejectsInvalidLine() {
        // відсутній префікс BK у номері бронювання
        assertThrows(IllegalArgumentException.class, () -> {
            processor.parseLine("2026-05-15 12345 Paris CONFIRMED");
        });
    }

    @Test
    void testBuildReport() {
        List<Booking> bookings = processor.parseLines(List.of(
                "2026-05-15 BK-111 Rome CONFIRMED",
                "2026-05-16 BK-222 Kyiv CANCELLED"
        ));

        String report = processor.buildReport(bookings);
        assertTrue(report.contains("усього записів: 2"));
        assertTrue(report.contains("підтверджено: 1"));
        assertTrue(report.contains("Rome"));
    }
}