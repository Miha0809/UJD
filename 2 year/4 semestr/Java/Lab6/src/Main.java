import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static void Task1() {
        String input = "Hello, world!";
        IntStream codePointsStream = IntStream.iterate(0, i -> i + 1)
                .limit(input.length())
                .map(input::codePointAt);

        codePointsStream.forEach(item -> System.out.println(Integer.toHexString(item)));
    }

    private static void Task2() {
        System.out.println("Hello".codePoints()
                .allMatch(Character::isAlphabetic));
        System.out.println("Hello123".codePoints()
                .allMatch(Character::isAlphabetic));
        System.out.println("Hello123".codePoints()
                .skip(1)
                .allMatch(Character::isJavaIdentifierPart));
        System.out.println("123Hello".codePoints()
                .skip(1)
                .allMatch(Character::isJavaIdentifierPart));
        System.out.println("Hello_123".codePoints()
                .skip(1)
                .allMatch(Character::isJavaIdentifierPart));
        System.out.println("Hello-123".codePoints()
                .skip(1)
                .allMatch(Character::isJavaIdentifierPart));
    }

    public static boolean isJavaIdentifier(String str) {
        if (str.isEmpty() || !Character.isJavaIdentifierStart(str.codePointAt(0))) {
            return false;
        }

        for (int i = 1; i < str.length(); i++) {
            if (!Character.isJavaIdentifierPart(str.codePointAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static void Task3(String fileName) {
        List<String> tokens = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineTokens = line.split("\\s+");
                for (String token : lineTokens) {
                    tokens.add(token);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> words = tokens.stream()
                .filter(str -> str.codePoints().allMatch(Character::isAlphabetic))
                .limit(100)
                .collect(Collectors.toList());

        System.out.println("Pierwsze 100 tokenów, które są słowami:");

        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int task = -1;

        while (task != 0) {
            System.out.println("\n\t\tNAVIGATION");
            System.out.println("Task 1 - enter 1");
            System.out.println("Task 2 - etner 2");
            System.out.println("Task 3 - etner 3");
            System.out.println("EXIT - etner 0");
            task = scanner.nextInt();

            switch (task) {
                case 1: {
                    Task1();
                    break;
                }
                case 2: {
                    Task2();
                    break;
                }
                case 3: {
                    Task3(args[0]);
                    break;
                }
                default:
                    break;
            }
        }
    }
}