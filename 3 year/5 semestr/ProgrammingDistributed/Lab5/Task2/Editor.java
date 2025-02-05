package Task2;

import java.util.*;

public class Editor {
    private static final List<Question> questions = new ArrayList<>();

    public static List<Question> getQuestions() {
        return questions;
    }

    public static void editQuiz(Scanner scanner) {
        System.out.println("1. Add a question");
        System.out.println("2. Remove a question");
        System.out.println("3. Modify a question");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> addQuestion(scanner);
            case 2 -> removeQuestion(scanner);
            case 3 -> modifyQuestion(scanner);
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void addQuestion(Scanner scanner) {
        System.out.print("Enter the question text: ");
        String questionText = scanner.nextLine();

        String[] answers = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter answer " + (char) ('A' + i) + ": ");
            answers[i] = scanner.nextLine();
        }

        System.out.print("Enter the correct answer (A, B, C): ");
        char correctAnswer = scanner.nextLine().toUpperCase().charAt(0);

        questions.add(new Question(questionText, answers, correctAnswer));
        System.out.println("Question added successfully.");
    }

    private static void removeQuestion(Scanner scanner) {
        displayQuestions();
        System.out.print("Enter the question number to remove: ");
        int questionIndex = scanner.nextInt() - 1;

        if (questionIndex >= 0 && questionIndex < questions.size()) {
            questions.remove(questionIndex);
            System.out.println("Question removed.");
        } else {
            System.out.println("Invalid question number.");
        }
    }

    private static void modifyQuestion(Scanner scanner) {
        displayQuestions();
        System.out.print("Enter the question number to modify: ");
        int questionIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (questionIndex >= 0 && questionIndex < questions.size()) {
            Question question = questions.get(questionIndex);

            System.out.print("New question text (leave blank to keep unchanged): ");
            String newText = scanner.nextLine();
            if (!newText.isEmpty()) question.questionText = newText;

            for (int i = 0; i < 3; i++) {
                System.out.print("New answer " + (char) ('A' + i) + " (leave blank to keep unchanged): ");
                String newAnswer = scanner.nextLine();
                if (!newAnswer.isEmpty()) question.answers[i] = newAnswer;
            }

            System.out.print("New correct answer (A, B, C, leave blank to keep unchanged): ");
            String newCorrectAnswer = scanner.nextLine();
            if (!newCorrectAnswer.isEmpty()) question.correctAnswer = newCorrectAnswer.toUpperCase().charAt(0);

            System.out.println("Question modified.");
        } else {
            System.out.println("Invalid question number.");
        }
    }

    private static void displayQuestions() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i).questionText);
        }
    }
}
