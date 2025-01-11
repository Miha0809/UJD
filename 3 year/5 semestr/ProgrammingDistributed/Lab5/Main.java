import java.util.Scanner;

import Task1.Editor;
import Task1.FileManager;
import Task1.TestRunner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Application!");

        while (true) {
            System.out.println("\n1. Load quiz from file");
            System.out.println("2. Save quiz to file");
            System.out.println("3. Edit quiz");
            System.out.println("4. Take the quiz");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> FileManager.loadQuizFromFile(scanner);
                case 2 -> FileManager.saveQuizToFile(scanner);
                case 3 -> Editor.editQuiz(scanner);
                case 4 -> TestRunner.takeQuiz(scanner);
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
