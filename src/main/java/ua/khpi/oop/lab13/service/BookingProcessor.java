package ua.khpi.oop.lab13.service;

import ua.khpi.oop.lab13.model.Booking;
import ua.khpi.oop.lab13.model.BookingStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// сервіс для текстової обробки записів бронювання
public class BookingProcessor {

    // регулярний вираз для валідації: дата, номер броні bk-числа, місто, статус
    private static final Pattern BOOKING_PATTERN = Pattern.compile(
            "^(\\d{4}-\\d{2}-\\d{2}) (BK-\\d{3,5}) ([a-zA-Z]+) (CONFIRMED|PENDING|CANCELLED)$"
    );

    // очищення рядка від зайвих пробілів на початку, в кінці та між словами
    public String normalize(String line) {
        if (line == null) {
            return "";
        }
        return line.trim().replaceAll("\\s+", " ");
    }

    // розбір одного текстового рядка в об'єкт бронювання
    public Booking parseLine(String rawLine) {
        String normalized = normalize(rawLine);
        Matcher matcher = BOOKING_PATTERN.matcher(normalized);

        // перевірка формату регулярним виразом
        if (!matcher.matches()) {
            throw new IllegalArgumentException("невалідний формат запису: " + rawLine);
        }

        // вилучення груп із тексту
        LocalDate date = LocalDate.parse(matcher.group(1));
        String number = matcher.group(2);
        String dest = matcher.group(3);
        BookingStatus status = BookingStatus.valueOf(matcher.group(4));

        return new Booking(date, number, dest, status);
    }

    // обробка списку сирих рядків
    public List<Booking> parseLines(List<String> lines) {
        List<Booking> bookings = new ArrayList<>();
        for (String line : lines) {
            String norm = normalize(line);
            if (!norm.isBlank()) {
                bookings.add(parseLine(norm));
            }
        }
        return bookings;
    }

    // формування звіту за допомогою stringbuilder
    public String buildReport(List<Booking> bookings) {
        StringBuilder report = new StringBuilder();
        report.append("звіт по туристичним бронюванням\n");
        report.append("===============================\n");

        int confirmedCount = 0;

        for (Booking b : bookings) {
            report.append("дата: ").append(b.getDate())
                    .append(" | номер: ").append(b.getBookingNumber())
                    .append(" | напрямок: ").append(b.getDestination())
                    .append(" | статус: ").append(b.getStatus())
                    .append("\n");

            if (b.getStatus() == BookingStatus.CONFIRMED) {
                confirmedCount++;
            }
        }

        report.append("===============================\n");
        report.append("усього записів: ").append(bookings.size()).append("\n");
        report.append("підтверджено: ").append(confirmedCount).append("\n");

        return report.toString();
    }
}