package Task1;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileManager {
    private static final List<Question> questions = Editor.getQuestions();

    public static void loadQuizFromFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            questions.clear();
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            StringBuilder questionText = new StringBuilder();
            String[] answers = new String[3];
            char correctAnswer = ' ';
            int answerIndex = 0;

            for (String line : lines) {
                if (line.trim().isEmpty()) {
                    if (questionText.length() > 0 && correctAnswer != ' ') {
                        questions.add(new Question(questionText.toString(), answers, correctAnswer));
                        questionText.setLength(0);
                        answers = new String[3];
                        correctAnswer = ' ';
                        answerIndex = 0;
                    }
                    continue;
                }

                if (line.startsWith("# Question: ")) {
                    questionText.append(line.substring(11).trim());
                } else if (line.startsWith("* Correct: ")) {
                    correctAnswer = line.substring(10).trim().charAt(0);
                } else if (line.matches("[A-C]\\) .*")) {
                    answers[answerIndex++] = line.substring(3).trim();
                }
            }

            System.out.println("Quiz successfully loaded.");
        } catch (IOException e) {
            System.out.println("Error while loading the file: " + e.getMessage());
        }
    }

    public static void saveQuizToFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Question question : questions) {
                writer.write("# Question: " + question.questionText);
                writer.newLine();
                for (int i = 0; i < question.answers.length; i++) {
                    writer.write((char) ('A' + i) + ") " + question.answers[i]);
                    writer.newLine();
                }
                writer.write("* Correct: " + question.correctAnswer);
                writer.newLine();
                writer.newLine();
            }
            System.out.println("Quiz successfully saved.");
        } catch (IOException e) {
            System.out.println("Error while saving the file: " + e.getMessage());
        }
    }
}
