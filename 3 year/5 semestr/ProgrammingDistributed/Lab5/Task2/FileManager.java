package Task2;

import java.io.*;
import java.util.*;

public class FileManager {
    private static final List<Question> questions = Editor.getQuestions();

    public static void loadQuizFromFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Question> loadedQuestions = (List<Question>) ois.readObject();
            questions.clear();
            questions.addAll(loadedQuestions);
            System.out.println("Quiz successfully loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading the file: " + e.getMessage());
        }
    }

    public static void saveQuizToFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(questions);
            System.out.println("Quiz successfully saved.");
        } catch (IOException e) {
            System.out.println("Error while saving the file: " + e.getMessage());
        }
    }
}
