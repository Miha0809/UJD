import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task0b(args);
        // Scanner scanner = new Scanner(System.in);

        // while (true) {
        //     System.out.println("\t\tNAVIGATION");
        //     System.out.println("Enter 1 - task 0a");
        //     System.out.println("Enter 2 - task 0b");
        //     System.out.println("Enter 3 - task 1");
        //     System.out.println("Enter 4 - task 2");
        //     System.out.println("Enter 5 - task 3");
        //     System.out.println("Enter 6 - task 4");
        //     System.out.println("Enter 7 - task 5");
        //     System.out.println("Enter 8 - task 6");
        //     System.out.println("Enter 9 - task 7");
        //     System.out.println("Enter 0 - EXIT");
        //     System.out.print("Enter task >>> ");
        //     short mode = scanner.nextShort();

        //     switch (mode) {
        //         case 1:
        //             task0a(args);
        //             break;
        //         case 2:
        //             task0b(args);
        //             break;
        //         case 3:
        //             task1();
        //             break;
        //         case 4:
        //             task2(args);
        //             break;
        //         case 5:
        //             task3();
        //             break;
        //         case 6:
        //             task4(args);
        //             break;
        //         case 7:
        //             task5();
        //             break;
        //         case 8:
        //             task6();
        //             break;
        //         case 9:
        //             task7();
        //             break;
        //         default:
        //             return;
        //     }
        // }
    }

    private static void task0a(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DisplayTextFile <filename>");
            return;
        }

        String filename = args[0];

        try {
            displayFileContent(filename);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    private static void displayFileContent(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void task0b(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileStatistics <filename> <includeConjunctions>");
            return;
        }

        String filename = args[0];
        boolean includeConjunctions = args[1].equals("1");

        try {
            analyzeFile(filename, includeConjunctions);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    private static void analyzeFile(String filename, boolean includeConjunctions) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int charCount = 0;
            int uppercaseCount = 0;
            int lowercaseCount = 0;
            int wordCount = 0;

            while ((line = reader.readLine()) != null) {
                charCount += line.length();

                for (char c : line.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        uppercaseCount++;
                    } else if (Character.isLowerCase(c)) {
                        lowercaseCount++;
                    }
                }

                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (isWord(word, includeConjunctions)) {
                        wordCount++;
                    }
                }
            }

            System.out.println("Character count: " + charCount);
            System.out.println("Uppercase letters count: " + uppercaseCount);
            System.out.println("Lowercase letters count: " + lowercaseCount);
            System.out.println("Word count: " + wordCount);
        }
    }
    private static boolean isWord(String word, boolean includeConjunctions) {
        if (word.length() > 1) {
            return true;
        }

        return includeConjunctions && !word.matches("[a-zA-Z]");
    }

    private static void task1() {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = null;

        try {
            System.out.print("Enter the filename for the text file: ");
            String filename = scanner.nextLine();

            writer = new BufferedWriter(new FileWriter(filename));

            System.out.println("Enter text (press Enter to finish):");
            String line;

            while (!(line = scanner.nextLine()).isEmpty()) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Data saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error while writing to the file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the file: " + e.getMessage());
            }
        }
    } 

    private static void task2(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ReadFileCharacterByCharacter <filename>");
            return;
        }

        String filename = args[0];

        try (Reader reader = new FileReader(filename)) {
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void task3() {
        generateAndSaveMultiplicationTable("multiplication_table.txt");
        readAndDisplayMultiplicationTable("multiplication_table.txt");
    }
    private static void generateAndSaveMultiplicationTable(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    writer.write(i + " * " + j + " = " + (i * j) + "\t");
                }
                writer.newLine();
            }
            System.out.println("Multiplication table saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    private static void readAndDisplayMultiplicationTable(String filename) {
        Path path = Paths.get(filename);

        try (Reader reader = Files.newBufferedReader(path)) {
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void task4(String[] args) {
        String filename;

        if (args.length == 1) {
            filename = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the name of the text file: ");
            filename = scanner.nextLine();
        }

        try {
            displayFileContent(filename);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void task5() {
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = null;

        try {
            System.out.print("Enter the binary file name: ");
            String filename = scanner.nextLine();

            dataOutputStream = new DataOutputStream(new FileOutputStream(filename, true));

            while (true) {
                System.out.print("Enter a number (or 'q' to exit): ");
                String input = scanner.next();

                if ("q".equalsIgnoreCase(input)) {
                    break;
                }

                try {
                    double number = Double.parseDouble(input);
                    dataOutputStream.writeDouble(number);
                } catch (NumberFormatException e) {
                    System.out.println("Error! Input is not a number.");
                }
            }

            System.out.println("Data saved to binary file: " + filename);
        } catch (IOException e) {
            System.out.println("Error while writing to the file: " + e.getMessage());
        } finally {
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the stream: " + e.getMessage());
            }
        }
    }

    private static void task6() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the binary file name: ");
        String filename = scanner.nextLine();
        
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filename))) {
            int elementsCount = 0;
            try {
                while (true) {
                    double number = dataInputStream.readDouble();
                    System.out.println(number);
                    elementsCount++;
                }
            } catch (IOException e) {
            }

            System.out.println("Number of elements read: " + elementsCount);
        } catch (IOException e) {
            System.out.println("Error while reading the binary file: " + e.getMessage());
        }
    }

    private static void task7() {
        generateAndSaveMultiplicationTable("multiplication_table.bin");
        readAndDisplayMultiplicationTable("multiplication_table.bin");
    }
}