public class TextAssistant {
    private static String currentData = "";
    private static boolean debugMode = false;

    public static void setDebugMode(boolean mode) {
        debugMode = mode;
    }

    public static void inputData(String data) {
        currentData = data;
        if (debugMode) {
            System.out.println("[DEBUG] Data received: " + data);
        }
    }

    public static void viewData() {
        if (currentData.isEmpty()) {
            System.out.println("No data entered yet.");
        } else {
            System.out.println("Current data: " + currentData);
        }
    }

    public static void processAndShow() {
        if (currentData.isEmpty()) {
            System.out.println("Error: No data to process.");
            return;
        }

        if (debugMode) {
            System.out.println("[DEBUG] Starting word count process...");
        }

        StringBuilder sb = new StringBuilder(currentData);
        String[] words = new String[100];
        int[] counts = new int[100];
        int uniqueWordsCount = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i <= sb.length(); i++) {
            char c = (i < sb.length()) ? sb.charAt(i) : ' ';
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                currentWord.append(c);
            } else {
                if (currentWord.length() > 0) {
                    String word = currentWord.toString().toLowerCase();
                    boolean found = false;
                    for (int j = 0; j < uniqueWordsCount; j++) {
                        if (words[j].equals(word)) {
                            counts[j]++;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        words[uniqueWordsCount] = word;
                        counts[uniqueWordsCount] = 1;
                        uniqueWordsCount++;
                    }
                    currentWord.setLength(0);
                }
            }
        }

        System.out.println("\n Result Table");
        for (int i = 0; i < uniqueWordsCount; i++) {
            System.out.printf("| %-10s | %-5d |%n", words[i], counts[i]);
        }
    }
}