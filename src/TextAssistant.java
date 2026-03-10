public class TextAssistant {
    public static void countWords(String text) {
        StringBuilder sb = new StringBuilder(text);

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

        System.out.println("-");
        System.out.printf("| %-10s | %-5s |%n", "Word", "Count");
        System.out.println("-");
        for (int i = 0; i < uniqueWordsCount; i++) {
            System.out.printf("| %-10s | %-5d |%n", words[i], counts[i]);
        }
        System.out.println("-");
    }
}
