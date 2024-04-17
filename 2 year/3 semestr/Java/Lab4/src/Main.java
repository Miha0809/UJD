import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t\tNAVIGATION");
            System.out.println("Enter 1 - task A0");
            System.out.println("Enter 2 - task A0a");
            System.out.println("Enter 3 - task A1");
            System.out.println("Enter 4 - task A2");
            System.out.println("Enter 5 - task A4");
            System.out.println("Enter 6 - task A5");
            System.out.println("Enter 7 - task B1");
            System.out.println("Enter 8 - task B2");
            System.out.println("Enter 9 - task B3");
            System.out.println("Enter 10 - task B4");
            System.out.println("Enter 11 - task B5");
            System.out.println("Enter 12 - task B6");
            System.out.println("Enter 13 - task B7");
            System.out.println("Enter 14 - task B8");
            System.out.println("Enter 15 - task B9");
            System.out.println("Enter 16 - task B10");
            System.out.println("Enter 17 - task B11");
            System.out.println("Enter 18 - task B12");
            System.out.println("Enter 19 - task B13");
            System.out.println("Enter 20 - task B14");
            System.out.println("Enter 21 - task B15");
            System.out.println("Enter 22 - task C1");
            System.out.println("Enter 23 - task C2");
            System.out.println("Enter 0 - EXIT");
            System.out.print("Enter task >>> ");
            short mode = scanner.nextShort();

            switch (mode) {
                case 1:
                    taskA0();
                    break;
                case 2:
                    System.out.println(taskA0a());
                    break;
                case 3:
                    taskA1();
                    break;
                case 4:
                    taskA2();
                    break;
                case 5:
                    taskA4();
                    break;
                case 6: {
                    double pngSize = taskA5("PNG", 800, 600, 24, 1.0);
                    double bmpSize = taskA5("BMP", 1024, 768, 32, 1.0);
                    double customSize = taskA5("Custom", 500, 300, 16, 1.5);

                    System.out.printf("PNG Size: %.2f kB\n", pngSize);
                    System.out.printf("BMP Size: %.2f kB\n", bmpSize);
                    System.out.printf("Custom Size: %.2f kB\n", customSize);
                }
                    break;
                case 7:
                    taskB1();
                    break;
                case 8:
                    taskB2();
                    break;
                case 9:
                    taskB3();
                    break;
                case 10:
                    taskB4();
                    break;
                case 11:
                    taskB5();
                    break;
                case 12:
                    taskB6();
                    break;
                case 13:
                    taskB7();
                    break;
                case 14:
                    taskB8();
                    break;
                case 15:
                    taskB9();
                    break;
                case 16:
                    taskB10();
                    break;
                case 17:
                    taskB11();
                    break;
                case 18:
                    taskB12();
                    break;
                case 19:
                    taskB13();
                    break;
                case 20:
                    taskB14();
                    break;
                case 21:
                    taskB15();
                    break;
                case 22:
                    taskC1();
                    break;
                case 23:
                    taskC2();
                    break;
                default:
                    return;
            }
        }
    }

    private static void taskA0() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter you age: ");
        int age = scanner.nextInt();

        System.out.println("First");

        if (age >= 18) {
            System.out.println("YES");
        }

        System.out.println("Second");

        if (age >= 18) {
            System.out.println("YES");
        } else {
            System.out.println("No");
        }
    }

    private static double taskA0a() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length: ");
        double length = scanner.nextDouble();

        while (true) {
            System.out.println("1 - km per mile");
            System.out.println("2 - mile per km");
            short mode = scanner.nextShort();

            if (mode == 1) {
                return length * 0.621371;
            } else if (mode == 2) {
                return length * 1.60934;
            }

            System.out.println("NOK");
        }
    }

    private static void taskA1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the weight of your luggage: ");
        double weight = scanner.nextDouble();

        if (weight < 0) {
            System.out.println("Error weight");
            return;
        } else if (weight > 20) {
            final short rate = 10;
            double pay = (weight - 20) * rate;

            System.out.println("Please pay extra for the excess kilogram of " + pay);
        } else if (weight < 20) {
            System.out.println("Remaining to maximum weight of " + (20 - weight));
        } else {
            System.out.println("Information about reaching the maximum weight of luggage");
        }
    }

    private static void taskA2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the vehicle weight (in tons): ");
        double vehicleWeight = scanner.nextDouble();

        System.out.print("Enter the vehicle type (p - passenger, c - cargo): ");
        char vehicleType = scanner.next().charAt(0);

        double toll;

        if (vehicleType == 'p') {
            if (vehicleWeight <= 3.5) {
                toll = 10;
            } else {
                toll = 10 + (vehicleWeight - 3.5);
            }
        } else if (vehicleType == 'c') {
            if (vehicleWeight >= 3.5 && vehicleWeight <= 8) {
                toll = 20;
            } else if (vehicleWeight > 8) {
                toll = 20 + 2 * (vehicleWeight - 8);
            } else {
                System.out.println("Error: Cargo vehicle with weight < 3.5T. Toll is 10 PLN.");
                return;
            }
        } else {
            System.out.println("Error: Unknown vehicle type.");
            return;
        }

        System.out.println("The road toll is: " + toll + " PLN");
    }

    private static void taskA4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many years of experience: ");
        double experience = scanner.nextDouble();

        System.out.print("How many hours did you work: ");
        double hoursWord = scanner.nextDouble();

        double basicRatePerHour = 30;
        double basicHours = 5 * 8;
        final double OM = 2; // MN
        final double RM = 1.2; // MS
        double salary = basicRatePerHour * basicHours;

        if (experience >= 5) {
            salary *= RM;
        }

        if (hoursWord > basicRatePerHour) {
            salary += (hoursWord - basicRatePerHour) * OM;
        }

        System.out.println("Salary: " + salary);
    }

    private static double taskA5(String fileType,
                                 int width,
                                 int height,
                                 int colorDepth,
                                 double compressionRatio) {
        int headerSize = 0;

        if ("PNG".equals(fileType)) {
            headerSize = 32;
        } else if ("BMP".equals(fileType)) {
            headerSize = 24;
        }

        double dataSize = width * height * (colorDepth / 8.0);
        double totalSize;

        if (headerSize > 0) {
            double compressedSize = dataSize / compressionRatio;
            totalSize = headerSize + compressedSize;
        } else {
            totalSize = dataSize;
        }

        double sizeInKB = totalSize / 1024.0;

        return sizeInKB;
    }

    private static void taskB1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter i (begin): ");
        int begin = scanner.nextInt();

        System.out.print("Enter n (end): ");
        int end = scanner.nextInt();

        double reuslt = 1;

        for (int i = begin; i <= end; i++) {
            reuslt *= i;
        }

        System.out.println("Suma: " + reuslt);
    }

    private static void taskB2() {
        int i = 1;
        int basis = 2;
        int exponent = 3;
        long result = 1;

        do {
            result = result * basis;
            i++;
        } while (i <= exponent);

        System.out.println("result = " + result + " i = " + i);

        i = 1;
        result = 1;
        while (i <= exponent)
        {
            result = result * basis;
            i++;
        }

        System.out.println("result = " + result + " i = " + i);

        result = 1;
        for (i = 1; i <= exponent; i++) {
            result = result * basis;
        }

        System.out.println("result = " + result + " i = " + i);
    }

    private static void taskB3() {
        Scanner scanner = new Scanner(System.in);

        int countEvents = 0;
        int countTens = 0;
        int countNumbers = 0;
        double suma = 0;
        int number;

        do {
            System.out.print("Enter number: ");
            number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (number % 10 == 0 ) {
                countTens++;
            } else if (number % 2 == 0) {
                countEvents++;
            }

            suma += number;
            countNumbers++;
        } while (number != 0);

        double average = suma / countNumbers;

        System.out.println("countEvents: " + countEvents);
        System.out.println("countTens: " + countTens);
        System.out.println("countNumbers: " + countNumbers);
        System.out.println("suma: " + suma);
        System.out.println("Average: " + average);
    }

    private static void taskB4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the range (x): ");
        int x = scanner.nextInt();

        System.out.print("Enter the range (y): ");
        int y = scanner.nextInt();

        System.out.print("Enter the number of draws: ");
        int numberOfDraws = scanner.nextInt();

        System.out.print("Enter a number to check repetition: ");
        int numberToCheck = scanner.nextInt();

        System.out.println("Repeated Draws:");
        int repeatedOccurrences = performDraws(x, y, numberOfDraws, true, numberToCheck);
        System.out.println("Number " + numberToCheck + " repeated " + repeatedOccurrences + " times.");

        System.out.println("\nDraws without Repetition:");
        performDraws(x, y, numberOfDraws, false, 0);

        System.out.print("\nEnter the number of repeated draw statistics: ");
        int numberOfStats = scanner.nextInt();
        generalStatistics(x, y, numberOfDraws, numberOfStats);
    }
    private static int performDraws(int x, int y, int numberOfDraws, boolean withRepetition, int numberToCheck) {
        Random random = new Random();
        Set<Integer> drawnNumbers = new HashSet<>();
        int repeatedOccurrences = 0;

        for (int i = 0; i < numberOfDraws; i++) {
            int drawnNumber;

            if (withRepetition) {
                drawnNumber = random.nextInt(y - x + 1) + x;
                if (drawnNumber == numberToCheck) {
                    repeatedOccurrences++;
                }
            } else {
                do {
                    drawnNumber = random.nextInt(y - x + 1) + x;
                } while (drawnNumbers.contains(drawnNumber));
                drawnNumbers.add(drawnNumber);
            }

            System.out.print(drawnNumber + " ");
        }

        return repeatedOccurrences;
    }
    private static void generalStatistics(int x, int y, int numberOfDraws, int numberOfStats) {
        System.out.println("\nGeneral Statistics for Repeated Draws:");
        Map<Integer, Integer> occurrencesMap = new HashMap<>();

        for (int i = 0; i < numberOfStats; i++) {
            int repeatedOccurrences = performDraws(x, y, numberOfDraws, true, 0);
            occurrencesMap.put(i + 1, repeatedOccurrences);
        }

        for (Map.Entry<Integer, Integer> entry : occurrencesMap.entrySet()) {
            System.out.println("Number " + entry.getKey() + " repeated " + entry.getValue() + " times.");
        }
    }

    private static void taskB5() {
        final short count = 10;
        for (int row = 1; row <= count; row++) {
            for (int column = 1; column <= count; column++) {
                System.out.printf("%4d", (row * column));
            }

            System.out.println();
        }
    }

    private static void taskB6() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter binary digits (0 or 1) separated by spaces. Press Enter to finish:");

        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s+");

        int onesCount = 0;
        int errorsCount = 0;

        for (String digit : inputArray) {
            if (digit.matches("[01]")) {
                int binaryDigit = Integer.parseInt(digit);
                onesCount += binaryDigit;
            } else {
                errorsCount++;
            }
        }

        if (errorsCount > 0) {
            System.out.println("Warning: " + errorsCount + " invalid input(s) detected and ignored.");
        }

        int result = onesCount % 2;

        System.out.println("\nSummary:");
        System.out.println("Ones Count: " + onesCount);
        System.out.println("Errors Count: " + errorsCount);
        System.out.println("XOR Result: " + result);
    }

    private static void taskB7() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter binary digits (0 or 1) without pressing Enter. Press Enter to finish:");

        StringBuilder inputBuilder = new StringBuilder();
        int onesCount = 0;
        int errorsCount = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }

            char lastChar = input.charAt(input.length() - 1);

            if (lastChar == '0' || lastChar == '1') {
                inputBuilder.append(lastChar);
                int binaryDigit = Character.getNumericValue(lastChar);
                onesCount += binaryDigit;
            } else {
                errorsCount++;
            }
        }

        if (errorsCount > 0) {
            System.out.println("Warning: " + errorsCount + " invalid input(s) detected and ignored.");
        }

        int result = onesCount % 2;

        System.out.println("\nSummary:");
        System.out.println("Ones Count: " + onesCount);
        System.out.println("Errors Count: " + errorsCount);
        System.out.println("XOR Result: " + result);
    }

    private static void taskB8() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber, number, count = 0;

        randomNumber = random.nextInt(1, 100 + 1);
        System.out.println(randomNumber);

        do {
            System.out.print("Enter number: ");
            number = scanner.nextInt();

            if (number < randomNumber) {
                System.out.println("Too small a number");
            }
            else if (number > randomNumber) {
                System.out.println("Too much a number");
            }
            else {
                System.out.println("Yes, this is the number");
            }

            count++;
        } while (number != randomNumber);

        System.out.println("Counter: " + count);
    }

    private static void taskB9() {
        Scanner scanner = new Scanner(System.in);

        int number, suma = 0, count = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double average = 0;

        do {
            System.out.print("Enter number: ");
            number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            count++;
            suma += number;
            max = max(number, max);
            min = min(number, min);
        } while(true);

        average = (double) suma / count;

        System.out.println("Count: " + count);
        System.out.println("Suma: " + suma);
        System.out.println("Average: " + average);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
    private static int min(int number, int min) {
        if (number < min) {
            return number;
        }

        return min;
    }
    private static int max(int number, int max) {
        if (number > max) {
            return number;
        }

        return max;
    }

    private static void taskB10() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check for primality: ");
        long numberToCheck = scanner.nextLong();

        long startTime = System.currentTimeMillis();
        boolean isPrime = isPrimeNumber(numberToCheck);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("\nSummary:");
        System.out.println(numberToCheck + " is " + (isPrime ? "prime" : "not prime"));
        System.out.println("Time elapsed: " + elapsedTime + " milliseconds");
    }
    private static boolean isPrimeNumber(long number) {
        if (number <= 1) {
            return false;
        }

        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void taskB11() {
        Scanner scanner = new Scanner(System.in);

        int totalMatches = 11;
        int matchesToRemove;
        int currentPlayer = 1;
        int player1Matches = 0;
        int player2Matches = 0;

        long startTime = System.currentTimeMillis();

        while (totalMatches > 0) {
            System.out.println("Player " + currentPlayer + ", there are " + totalMatches + " matches left.");
            System.out.print("How many matches do you want to remove (1-3)? ");

            matchesToRemove = scanner.nextInt();

            if (matchesToRemove < 1 || matchesToRemove > 3 || matchesToRemove > totalMatches) {
                System.out.println("Invalid move. Please choose 1, 2, or 3 matches.");
                continue;
            }

            if (currentPlayer == 1) {
                player1Matches += matchesToRemove;
            } else {
                player2Matches += matchesToRemove;
            }

            totalMatches -= matchesToRemove;
            currentPlayer = 3 - currentPlayer;

            System.out.println();
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Game Over!");
        System.out.println("Player 1 matches: " + player1Matches);
        System.out.println("Player 2 matches: " + player2Matches);
        System.out.println("Total time: " + elapsedTime / 1000 + " seconds");
    }

    private static void taskB12() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int number2 = scanner.nextInt();

        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }

        int gcd = Math.abs(number1);

        System.out.println("GCD of " + number1 + " and " + number2 + " is: " + gcd);
    }

    private static void taskB13() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of m: ");
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int fib = m <= 1 ? m : fibonacci(m);
            System.out.println(fib + " ");
            m++;
        }
    }
    private static int fibonacci(int n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static void taskB14() {
        int n = 1000;
        int[] results = new int[6];
        Random random = new Random();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            int rollResult = random.nextInt(6) + 1;
            results[rollResult - 1]++;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Dice Roll Statistics (100% = " + n + " rolls):");
        for (int i = 0; i < 6; i++) {
            int percentage = results[i] * 100 / n;
            String bar = repeatCharacter('*', percentage);
            System.out.printf("%d: %3d%% | %s\n", i + 1, percentage, bar);
        }

        System.out.println("\nTime elapsed: " + elapsedTime + " milliseconds");
    }
    private static String repeatCharacter(char character, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(character);
        }
        return result.toString();
    }

    private static void taskB15() {
        Scanner scanner = new Scanner(System.in);
        char choice;

        infiniteLoop:
        for (int number = 0; ; number++) {
            System.out.println("Current number: " + number);
            System.out.print("Do you want to continue? (Press 'k' to exit): ");
            choice = scanner.next().toLowerCase().charAt(0);

            if (number % 27 == 0) {
                System.out.println("Divisible by 27");
            }

            if (number % 127 == 0) {
                System.out.println("Divisible by 127. Exiting the loop.");
                break infiniteLoop;
            }

            if (number % 59 == 0) {
                System.out.println("Divisible by 59. Going to the beginning of the loop.");
                continue infiniteLoop;
            }

            if (choice == 'k') {
                System.out.println("Exiting the loop by user request.");
                break;
            }
        }
    }

    private static void taskC1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a shape to calculate the area:");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Circle");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculateSquareArea();
                break;
            case 2:
                calculateRectangleArea();
                break;
            case 3:
                calculateCircleArea();
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }
    private static void calculateSquareArea() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the side length of the square: ");
        double sideLength = scanner.nextDouble();

        double area = sideLength * sideLength;

        System.out.println("The area of the square is: " + area);
    }
    private static void calculateRectangleArea() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();

        double area = length * width;

        System.out.println("The area of the rectangle is: " + area);
    }
    private static void calculateCircleArea() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        double area = Math.PI * radius * radius;

        System.out.println("The area of the circle is: " + area);
    }

    private static void taskC2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performAddition(num1, num2);
                break;
            case 2:
                performSubtraction(num1, num2);
                break;
            case 3:
                performMultiplication(num1, num2);
                break;
            case 4:
                performDivision(num1, num2);
                break;
            case 5:
                performExponentiation(num1, num2);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }
    private static void performAddition(double num1, double num2) {
        double result = num1 + num2;
        System.out.println("Result of addition: " + result);
    }
    private static void performSubtraction(double num1, double num2) {
        double result = num1 - num2;
        System.out.println("Result of subtraction: " + result);
    }
    private static void performMultiplication(double num1, double num2) {
        double result = num1 * num2;
        System.out.println("Result of multiplication: " + result);
    }
    private static void performDivision(double num1, double num2) {
        if (num2 != 0) {
            double result = num1 / num2;
            System.out.println("Result of division: " + result);
        } else {
            System.out.println("Cannot divide by zero.");
        }
    }
    private static void performExponentiation(double base, double exponent) {
        double result = Math.pow(base, exponent);
        System.out.println("Result of exponentiation: " + result);
    }
}