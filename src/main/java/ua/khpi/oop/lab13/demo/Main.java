package ua.khpi.oop.lab13.demo;

import ua.khpi.oop.lab13.model.Booking;
import ua.khpi.oop.lab13.service.BookingProcessor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// демонстраційний запуск програми
public class Main {
    public static void main(String[] args) {
        try {
            // зчитування файлу з ресурсної папки
            List<String> lines = readResourceLines("bookings.txt");

            BookingProcessor processor = new BookingProcessor();

            // перетворення тексту на об'єкти
            List<Booking> bookings = processor.parseLines(lines);

            // побудова звіту
            String report = processor.buildReport(bookings);
            System.out.println(report);

        } catch (Exception e) {
            System.out.println("виникла помилка: " + e.getMessage());
        }
    }

    // допоміжний метод для читання файлу
    private static List<String> readResourceLines(String fileName) throws IOException, URISyntaxException {
        URL resource = Main.class.getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new IOException("файл не знайдено: " + fileName);
        }
        return Files.readAllLines(Path.of(resource.toURI()));
    }
}