import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t\tNAVIGATION");
            System.out.println("Enter 1 - task 0");
            System.out.println("Enter 2 - task 1");
            System.out.println("Enter 3 - task 2");
            System.out.println("Enter 4 - task 3");
            System.out.println("Enter 5 - task 4");
            System.out.println("Enter 6 - task 5");
            System.out.println("Enter 7 - task 6");
            System.out.println("Enter 8 - task 7");
            System.out.println("Enter 9 - task 8");
            System.out.println("Enter 10 - task 9");
            System.out.println("Enter 11 - task 10");
            System.out.println("Enter 12 - task 12");
            System.out.println("Enter 13 - task 13");
            System.out.println("Enter 0 - EXIT");
            System.out.print("Enter task >>> ");
            short mode = scanner.nextShort();

            switch (mode) {
                case 1:
                    task0();
                    break;
                case 2:
                    task1();
                    break;
                case 3:
                    task2();
                    break;
                case 4:
                    task3();
                    break;
                case 5:
                    task4();
                    break;
                case 6:
                    task5();
                    break;
                case 7:
                    task6();
                    break;
                case 8:
                    task7();
                    break;
                case 9:
                    task8();
                    break;
                case 10:
                    task9();
                    break;
                case 11:
                    task10();
                    break;
                case 12:
                    task12();
                    break;
                case 13:
                    task13();
                    break;
                default:
                    return;
            }
        }
    }

    private static void task0() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers you want to input: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer #" + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nEntered numbers:");

        for (int i = 0; i < size; i++) {
            System.out.println("Integer #" + (i + 1) + ": " + numbers[i]);
        }

        System.out.print("\nEnter the new size of the array: ");
        int newSize = scanner.nextInt();
        int[] newNumbers = new int[newSize];

        System.arraycopy(numbers, 0, newNumbers, 0, Math.min(size, newSize));
        numbers = newNumbers;

        System.out.println("\nArray size changed to " + newSize + ".");
        System.out.println("\nNumbers in the updated array:");

        for (int i = 0; i < newSize; i++) {
            System.out.println("Integer #" + (i + 1) + ": " + numbers[i]);
        }
    }

    private static void task1() {
        int size = 10;
        int[][] multiplicationTable = new int[size][size];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                multiplicationTable[i - 1][j - 1] = i * j;
            }
        }

        System.out.println("Multiplication Table:");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%4d", multiplicationTable[i][j]);
            }
            System.out.println();
        }
    }

    private static void task2() {
        int[] numbers = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println("Original Array: " + Arrays.toString(numbers));
        for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        System.out.println("Reversed Array: " + Arrays.toString(numbers));

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        System.out.println("Sum of Elements: " + sum);
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value to find its occurrences: ");

        int userValue = scanner.nextInt();
        int occurrences = 0;
        for (int number : numbers) {
            if (number == userValue) {
                occurrences++;
            }
        }
        System.out.println("Occurrences of " + userValue + ": " + occurrences);
        int[] increasedValuesCopy = Arrays.copyOf(numbers, numbers.length);
        for (int i = 0; i < increasedValuesCopy.length; i++) {
            increasedValuesCopy[i]++;
        }
        System.out.println("Copy with Increased Values: " + Arrays.toString(increasedValuesCopy));
    }

    private static void task3() {
        Scanner scanner = new Scanner(System.in);

        char selectedOption;

        System.out.println("Menu Selection:");
        System.out.println("a. Option A");
        System.out.println("b. Option B");
        System.out.println("c. Option C");
        System.out.println("d. Option D");
        System.out.println("e. Option E");

        System.out.print("Enter a letter from the menu (a - e or A - E): ");
        String input = scanner.next();

        if (input.length() == 1) {
            selectedOption = input.charAt(0);

            if ((selectedOption >= 'a' && selectedOption <= 'e') || (selectedOption >= 'A' && selectedOption <= 'E')) {
                int asciiCode = (int) selectedOption;
                String letterCase = selectedOption >= 'a' ? "lowercase" : "uppercase";

                System.out.println("You selected: " + selectedOption);
                System.out.println("ASCII code: " + asciiCode);
                System.out.println("Letter case: " + letterCase);
            } else {
                System.out.println("Invalid selection. Please choose a letter from the menu.");
            }
        } else {
            System.out.println("Invalid input. Please enter only one character.");
        }
    }

    private static void task4() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence (press Enter to finish):");
        String userInput = scanner.nextLine();

        int letterCount = 0;
        int digitCount = 0;
        int spaceCount = 0;

        for (char ch : userInput.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else if (Character.isWhitespace(ch)) {
                spaceCount++;
            }
        }

        System.out.println("\nCharacter counts:");
        System.out.println("Letters: " + letterCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("Spaces: " + spaceCount);
    }

    private static void task5() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text to reverse: ");
        String userInput = scanner.nextLine();

        String reversedText = "";

        for (int i = userInput.length() - 1; i >= 0; i--) {
            reversedText += userInput.charAt(i);
        }

        System.out.println("\nReversed Text: " + reversedText);

    }

    private static void task6() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        System.out.print("Enter a phrase to search for: ");
        String phrase = scanner.nextLine();

        int position = -1;

        for (int i = 0; i <= text.length() - phrase.length(); i++) {
            boolean found = true;

            for (int j = 0; j < phrase.length(); j++) {
                if (text.charAt(i + j) != phrase.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            System.out.println("\nThe phrase '" + phrase + "' is found in the text.");
            System.out.println("It starts at position: " + position);
        } else {
            System.out.println("\nThe phrase '" + phrase + "' is not found in the text.");
        }
    }

    private static void task7() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();

        System.out.println("\nResult using + operator: " + firstString + secondString);
        System.out.println("Result using concat() method: " + firstString.concat(secondString));
    }

    private static void task8() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer value between 0 and 1000: ");

        int inputValue = scanner.nextInt();

        if (inputValue < 0 || inputValue > 1000) {
            System.out.println("Invalid input. Please enter an integer between 0 and 1000.");
        } else {
            System.out.println("\nOctal representation: " + Integer.toOctalString(inputValue));
            System.out.println("Hexadecimal representation: " + Integer.toHexString(inputValue));
        }
    }

    private static void task9() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text with whitespace characters: ");
        String inputText = scanner.nextLine();

        StringBuilder resultText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);

            if (!isWhitespace(currentChar)) {
                resultText.append(currentChar);
            }
        }

        System.out.println("\nText without whitespace characters: " + resultText);
    }
    private static boolean isWhitespace(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r' || ch == '\f';
    }

    private static void task10() {
        for (int i = 1; i <= 32; i++) {
            BigDecimal result = BigDecimal.ONE.divide(BigDecimal.valueOf(i), 32, BigDecimal.ROUND_HALF_UP);
            System.out.println("1 / " + i + " = " + result);
        }
    }

    private static void task12() {
        int[][] array = new int[10][10];

        fillArrayLeftDiagonal(array);
        fillArrayRightDiagonal(array);

        System.out.println("Filled Array:");
        printArray(array);
    }
    private static void fillArrayLeftDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = i + 1;
            }
        }
    }
    private static void fillArrayRightDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[i].length; j++) {
                array[i][j] = array.length - i;
            }
        }
    }
    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }

    private static void task13() {
        final int length = 10;
        int[][] array = new int[length][length];

        printArray(array);
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            int row = i;
            int col = array.length - 1 - i;

            array[row][col] = 1;
        }

        printArray(array);
    }
}