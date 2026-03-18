import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Обработка параметров командной строки
        for (String arg : args) {
            if (arg.equals("-h") || arg.equals("-help")) {
                System.out.println("Author: Veronika Nikolenko, Group 924B");
                System.out.println("Task: Count word occurrences and display as a table.");
                System.out.println("Menu points: Input, View, Calculate, Exit.");
                System.out.println("Params: -h (help), -d (debug mode).");
                return;
            }
            if (arg.equals("-d") || arg.equals("-debug")) {
                TextAssistant.setDebugMode(true);
                System.out.println("Debug mode enabled.");
            }
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Input data");
            System.out.println("2. View data");
            System.out.println("3. Calculate and Show result");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter text: ");
                    TextAssistant.inputData(sc.nextLine());
                    break;
                case "2":
                    TextAssistant.viewData();
                    break;
                case "3":
                    TextAssistant.processAndShow();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}