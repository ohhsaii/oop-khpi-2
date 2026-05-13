package ua.khpi.oop.lab08.persistence;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import ua.khpi.oop.lab08.exception.InvalidDocumentDataException;
import ua.khpi.oop.lab08.model.*;
import ua.khpi.oop.lab08.service.UniversityDocumentRegistry;

// менеджер для збереження та читання файлів
public class DocumentFileManager {

    // збереження у текстовий файл
    public void saveAsText(UniversityDocumentRegistry registry, Path path) throws IOException {
        List<String> lines = registry.getDocuments().stream()
                .map(UniversityDocument::toTextLine)
                .toList();
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    // читання з текстового файлу
    public UniversityDocumentRegistry loadFromText(Path path) throws IOException, InvalidDocumentDataException {
        UniversityDocumentRegistry registry = new UniversityDocumentRegistry();
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        int lineNumber = 1;
        for (String line : lines) {
            if (line.isBlank()) {
                lineNumber++;
                continue;
            }
            String[] parts = line.split(";", -1);
            if (parts.length < 3) {
                throw new InvalidDocumentDataException("неправильна кількість полів у рядку " + lineNumber);
            }

            try {
                String type = parts[0];
                String id = parts[1];
                String info = parts[2];

                switch (type) {
                    case "TranscriptRequest":
                        registry.addDocument(new TranscriptRequest(id, info));
                        break;
                    case "EnrollmentCertificate":
                        registry.addDocument(new EnrollmentCertificate(id, info));
                        break;
                    case "InternshipLetter":
                        registry.addDocument(new InternshipLetter(id, info));
                        break;
                    default:
                        throw new InvalidDocumentDataException("невідомий тип документа у рядку " + lineNumber);
                }
            } catch (Exception e) {
                throw new InvalidDocumentDataException("помилка даних у рядку " + lineNumber, e);
            }
            lineNumber++;
        }
        return registry;
    }

    // серіалізація колекції у бінарний файл
    public void serialize(UniversityDocumentRegistry registry, Path path) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(registry);
        }
    }

    // десеріалізація з бінарного файлу
    public UniversityDocumentRegistry deserialize(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            return (UniversityDocumentRegistry) in.readObject();
        }
    }
}