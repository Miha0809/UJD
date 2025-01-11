package Task2;

import java.util.List;
import java.util.Scanner;

public class TestRunner {
    private static final List<Question> questions = Editor.getQuestions();

    public static void takeQuiz(Scanner scanner) {
        int correctCount = 0;

        for (Question question : questions) {
            System.out.println(question.questionText);
            for (int i = 0; i < question.answers.length; i++) {
                System.out.println((char) ('A' + i) + ") " + question.answers[i]);
            }

            System.out.print("Your answer: ");
            char userAnswer = scanner.nextLine().toUpperCase().charAt(0);
            if (userAnswer == question.correctAnswer) {
                correctCount++;
            }
        }

        double percentage = (double) correctCount / questions.size() * 100;
        System.out.printf("Your score: %.2f%%\n", percentage);
        String grade = getGrade(percentage);
        System.out.println("Grade: " + grade);
    }

    private static String getGrade(double percentage) {
        if (percentage >= 90) {
            return "Excellent";
        }
        
        if (percentage >= 79) {
            return "Very good";
        }

        if (percentage >= 68) {
            return "Good";
        }

        if (percentage >= 57) {
            return "Satisfactory";
        }

        return "Fail";
    }
}
