package ua.khpi.oop.lab08.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import ua.khpi.oop.lab08.exception.InvalidDocumentDataException;
import ua.khpi.oop.lab08.model.*;
import ua.khpi.oop.lab08.persistence.DocumentFileManager;
import ua.khpi.oop.lab08.service.UniversityDocumentRegistry;

public class Main {
    public static void main(String[] args) {
        UniversityDocumentRegistry registry = new UniversityDocumentRegistry();
        registry.addDocument(new TranscriptRequest("tr-01", "ніколенко вероніка"));
        registry.addDocument(new EnrollmentCertificate("ec-02", "комп'ютерні науки"));
        registry.addDocument(new InternshipLetter("il-03", "google kharkiv"));

        DocumentFileManager fileManager = new DocumentFileManager();
        // файли будуть створені прямо в папці твого проєкту
        Path textPath = Path.of("docs.txt");
        Path binaryPath = Path.of("docs.bin");
        Path brokenPath = Path.of("broken.txt");

        try {
            // збереження та читання текстового файлу
            fileManager.saveAsText(registry, textPath);
            UniversityDocumentRegistry textRegistry = fileManager.loadFromText(textPath);
            System.out.println("документи з текстового файлу:");
            textRegistry.getDocuments().forEach(System.out::println);

            // серіалізація та десеріалізація бінарного файлу
            fileManager.serialize(textRegistry, binaryPath);
            UniversityDocumentRegistry binRegistry = fileManager.deserialize(binaryPath);
            System.out.println("\nдокументи з бінарного файлу:");
            binRegistry.getDocuments().forEach(System.out::println);

            // демонстрація обробки помилки
            System.out.println("\nдемонстрація помилки формату (зламаний файл):");
            Files.writeString(brokenPath, "TranscriptRequest;bad-id", StandardCharsets.UTF_8); // тут не вистачає 3-го поля
            fileManager.loadFromText(brokenPath);

        } catch (InvalidDocumentDataException e) {
            System.err.println("помилка даних моделі: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("неочікувана помилка: " + e.getMessage());
        }
    }
}