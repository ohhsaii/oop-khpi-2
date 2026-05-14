package ua.khpi.oop.lab11.service;

import ua.khpi.oop.lab11.model.*;
import java.util.*;

public class DocumentService {
    // словник для швидкого пошуку документа за його id
    private final Map<String, Document> documentRegistry = new HashMap<>();

    // черга документів, що очікують на розгляд
    private final Queue<Document> pendingQueue = new LinkedList<>();

    // словник, що зберігає історію погоджень для кожного документа
    private final Map<Document, List<ApprovalStep>> approvalHistory = new HashMap<>();

    public void registerDocument(Document doc) {
        if (!documentRegistry.containsKey(doc.getDocId())) {
            documentRegistry.put(doc.getDocId(), doc);
            pendingQueue.offer(doc); // додаємо в кінець черги
            approvalHistory.put(doc, new ArrayList<>());
        }
    }

    public void processNext(Employee approver, String resolution) {
        Document doc = pendingQueue.poll(); // беремо і видаляємо з початку черги
        if (doc != null) {
            approvalHistory.get(doc).add(new ApprovalStep(approver, resolution));
        }
    }

    public Document findById(String id) {
        return documentRegistry.get(id);
    }

    public List<ApprovalStep> getHistory(Document doc) {
        return approvalHistory.getOrDefault(doc, Collections.emptyList());
    }

    public int getPendingCount() {
        return pendingQueue.size();
    }
}