import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t\tNAVIGATION");
            System.out.println("Enter 1 - task 1");
            System.out.println("Enter 2 - task 2");
            System.out.println("Enter 3 - task 3");
            System.out.println("Enter 4 - task 4");
            System.out.println("Enter 5 - task 5");
            System.out.println("Enter 6 - task 6");
            System.out.println("Enter 7 - task 6a");
            System.out.println("Enter 8 - task 6b");
            System.out.println("Enter 9 - task 7");
            System.out.println("Enter 10 - task 8");
            System.out.println("Enter 11 - task 9");
            System.out.println("Enter 12 - task 10");
            System.out.println("Enter 13 - task 11");
            System.out.println("Enter 14 - task 12");
            System.out.println("Enter 0 - EXIT");
            System.out.print("Enter task >>> ");
            short mode = scanner.nextShort();

            switch (mode) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task6a();
                    break;
                case 8:
                    task6b();
                    break;
                case 9:
                    task7();
                    break;
                case 10:
                    task8();
                    break;
                case 11:
                    task9();
                    break;
                case 12:
                    task10();
                    break;
                case 13:
                    task11();
                    break;
                case 14:
                    task12();
                    break;
                default:
                    return;
            }
        }
    }

    private static void task1() {
        double result1 = divide(4.0);
        double result2 = divide(0.0);
        double result3 = divide(-3.0);

        System.out.println("1/x for x = 4.0: " + result1);
        System.out.println("1/x for x = 0.0: " + result2);
        System.out.println("1/x for x = -3.0: " + result3);
    }
    private static double divide(double x) {
        if (x > 0) {
            return 1.0 / x;
        } else if (x == 0) {
            return -1;
        } else {
            return -2;
        }
    }

    private static void task2() {
        String hexValue1 = "1aF";
        String hexValue2 = "XYZ";
        String stringValue = "Hello";

        System.out.println(hexValue1 + " is a hex digit: " + hexOK(hexValue1));
        System.out.println(hexValue2 + " is a hex digit: " + hexOK(hexValue2));

        System.out.println(hexValue1 + " is a hex number: " + isHexNumber(hexValue1));
        System.out.println(hexValue2 + " is a hex number: " + isHexNumber(hexValue2));
        System.out.println(stringValue + " is a hex number: " + isHexNumber(stringValue));
    }
    private static boolean hexOK(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c) && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
                return false;
            }
        }
        return true;
    }
    private static boolean isHexNumber(String value) {
        try {
            Long.parseLong(value, 16);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void task3() {
        int a = 5;
        int b = 10;

        System.out.println("Before swap: a = " + a + ", b = " + b);
        int result = swap(a, b);
        System.out.println("After swap: a = " + a + ", b = " + b);
        System.out.println("Comparison result: " + result);
    }
    private static int swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        if (a == b) {
            return 0;
        } else if (a > b) {
            return 1;
        } else {
            return -1;
        }
    }

    private static void task4() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Calculate area of a square");
            System.out.println("2. Calculate area of a rectangle");
            System.out.println("3. Calculate volume of a cube");
            System.out.println("Other. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the side length of the square:");
                    int sideLength = scanner.nextInt();
                    System.out.println("Area of the square: " + calculateArea(sideLength));
                    break;
                case 2:
                    System.out.println("Enter the length of the rectangle:");
                    double length = scanner.nextDouble();
                    System.out.println("Enter the width of the rectangle:");
                    double width = scanner.nextDouble();
                    System.out.println("Area of the rectangle: " + calculateArea(length, width));
                    break;
                case 3:
                    System.out.println("Enter the side length of the cube:");
                    double cubeSideLength = scanner.nextDouble();
                    System.out.println("Volume of the cube: " + calculateVolume(cubeSideLength));
                    break;
                default:
                    return;
            }
        }
    }
    private static double calculateArea(int sideLength) {
        return sideLength * sideLength;
    }
    private static double calculateArea(double length, double width) {
        return length * width;
    }
    private static double calculateVolume(double sideLength) {
        return sideLength * sideLength * sideLength;
    }

    private static void task5() {
        int[] array = {1, 2, 3, 4, 5, 3, 6, 7, 8, 3, 9};
        int targetValue = 3;
        int[] result = findValueInArray(array, targetValue);

        System.out.println("Number of elements equal to the target value: " + result[0]);
        System.out.println("Index of the first occurrence: " + result[1]);
    }
    private static int[] findValueInArray(int[] arr, int target) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (result[1] == -1) {
                    result[1] = i;
                }
                result[0]++;
            }
        }

        return result;
    }

    private static void task6() {
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        System.out.println("Before reversing:");
        displayArray(myArray);

        reverseArray(myArray);

        System.out.println("After reversing:");
        displayArray(myArray);
    }
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    private static void displayArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void task6a() {
        String binaryValue = "1101";
        int decimalResult = binaryToDecimal(binaryValue);
        System.out.println("Binary to Decimal: " + binaryValue + " = " + decimalResult);

        int decimalValue = 13;
        String binaryResult = decimalToBinary(decimalValue);
        System.out.println("Decimal to Binary: " + decimalValue + " = " + binaryResult);
    }
    private static int binaryToDecimal(String binaryValue) {
        int decimalResult = 0;
        int length = binaryValue.length();

        for (int i = 0; i < length; i++) {
            char digit = binaryValue.charAt(i);
            int power = length - i - 1;
            int value = Character.getNumericValue(digit);
            decimalResult += (int) (value * Math.pow(2, power));
        }

        return decimalResult;
    }
    private static String decimalToBinary(int decimalValue) {
        StringBuilder binaryResult = new StringBuilder();

        while (decimalValue > 0) {
            int remainder = decimalValue % 2;
            binaryResult.insert(0, remainder);
            decimalValue = decimalValue / 2;
        }

        return binaryResult.toString();
    }

    private static void task6b() {
        String hexadecimalValue = "1A";
        int decimalResult = hexToDec(hexadecimalValue);
        System.out.println("Hexadecimal to Decimal: " + hexadecimalValue + " = " + decimalResult);

        int decimalValue = 26;
        String binaryResult = decToBin(decimalValue);
        System.out.println("Decimal to Binary: " + decimalValue + " = " + binaryResult);
    }
    private static int hexToDec(String hexadecimalValue) {
        return Integer.parseInt(hexadecimalValue, 16);
    }
    private static String decToBin(int decimalValue) {
        return Integer.toBinaryString(decimalValue);
    }

    private static void task7() {
        int number = 1234;
        int iterativeSum = iterativeDigitSum(number);
        int recursiveSum = recursiveDigitSum(number);

        System.out.println("Iterative Digit Sum of " + number + ": " + iterativeSum);
        System.out.println("Recursive Digit Sum of " + number + ": " + recursiveSum);
    }
    private static int iterativeDigitSum(int number) {
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
    private static int recursiveDigitSum(int number) {
        if (number == 0) {
            return 0;
        } else {
            return (number % 10) + recursiveDigitSum(number / 10);
        }
    }

    private static void task8() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer N: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Invalid input. Please enter a non-negative integer.");
        } else {
            long iterativeFactorial = iterativeFactorial(n);
            long recursiveFactorial = recursiveFactorial(n);

            System.out.println("Iterative Factorial of " + n + ": " + iterativeFactorial);
            System.out.println("Recursive Factorial of " + n + ": " + recursiveFactorial);
        }
    }
    private static long iterativeFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
    private static long recursiveFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * recursiveFactorial(n - 1);
    }

    private static void task9() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative decimal number: ");
        int decimalNumber = scanner.nextInt();

        if (decimalNumber < 0) {
            System.out.println("Invalid input. Please enter a non-negative integer.");
        } else {
            String binaryRepresentation = decimalToBinary(decimalNumber);
            System.out.println("Binary representation of " + decimalNumber + ": " + binaryRepresentation);
        }
    }

    private static void task10() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } else {
            int sum = calculateRecursiveSum(n);
            System.out.println("Sum of numbers from 1 to " + n + ": " + sum);
        }
    }
    private static int calculateRecursiveSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + calculateRecursiveSum(n - 1);
        }
    }

    private static void task11() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } else {
            reverseNumbers(n);
        }
    }
    private static void reverseNumbers(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            reverseNumbers(n - 1);
        }
    }

    private static void task12() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Invalid input. Please enter a non-negative integer.");
        } else {
            System.out.println("Reverse of " + number + ": " + reverseDigits(number));
        }
    }
    private static String reverseDigits(int number) {
        if (number < 10) {
            return Integer.toString(number);
        } else {
            int lastDigit = number % 10;
            int remainingDigits = number / 10;
            return Integer.toString(lastDigit) + reverseDigits(remainingDigits);
        }
    }
}