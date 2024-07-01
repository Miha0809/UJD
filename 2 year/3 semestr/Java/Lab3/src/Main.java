import java.util.Scanner;

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
            System.out.println("Enter 7 - task 7");
            System.out.println("Enter 8 - task 8");
            System.out.println("Enter 9 - task 9");
            System.out.println("Enter 10 - task 10");
            System.out.println("Enter 11 - task 11");
            System.out.println("Enter 12 - task 12");
            System.out.println("Enter 13 - task 13");
            System.out.println("Enter 14 - task test");
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
                    task7();
                    break;
                case 8:
                    task8();
                    break;
                case 9:
                    task9();
                    break;
                case 10:
                    task10();
                    break;
                case 11:
                    task11();
                    break;
                case 12:
                    task12();
                    break;
                case 13:
                    task13();
                    break;
                case 14:
                    test();
                    break;
                default:
                    break;
            }
        }
    }

    private static void task1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int integerVariable = scanner.nextInt();

        System.out.print("Enter a real number: ");
        double realVariable = scanner.nextDouble();

        int preIncrementedInteger = ++integerVariable;
        int postIncrementedInteger = integerVariable++;
        double preIncrementedReal = ++realVariable;
        double postIncrementedReal = realVariable++;

        System.out.println("Result of pre-increment on integer: " + preIncrementedInteger);
        System.out.println("Result of post-increment on integer: " + postIncrementedInteger);
        System.out.println("Result of pre-increment on real number: " + preIncrementedReal);
        System.out.println("Result of post-increment on real number: " + postIncrementedReal);

        int sum = integerVariable + (int) realVariable;
        int difference = integerVariable - (int) realVariable;
        int product = integerVariable * (int) realVariable;
        double quotient = integerVariable / realVariable;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }

    private static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is not even");
        }
    }

    private static void task3() {
        int binaryVariable = 0b10000001;
        int hexadecimalValue = 0x11;

        System.out.println("Binary Variable: " + Integer.toBinaryString(binaryVariable));
        System.out.println("Hex Variable: " + Integer.toHexString(hexadecimalValue));

        ++binaryVariable;
        hexadecimalValue--;

        double result = ++binaryVariable - hexadecimalValue--;

        System.out.println("Wynik operacji: " + result);
        System.out.println("Nowa wartość Binary Variable: " + Integer.toBinaryString(binaryVariable));
        System.out.println("Nowa wartość Hex Variable: " + Integer.toHexString(hexadecimalValue));
    }

    private static void task4() {
        byte min = -128;
        int convert = Byte.toUnsignedInt(min);

        System.out.println("Byte type: " + min);
        System.out.println("Integer type: " + convert);
    }

    private static void task5() {
        int first = -5;
        int second = -10;

        System.out.println("First: " + first);
        System.out.println("Second: " + second);

        int division = first / second;

        System.out.println("Division: " + division);

        long unsignedFirstValue = Integer.toUnsignedLong(first);
        long unsignedSecondValue = Integer.toUnsignedLong(second);

        System.out.println("unsignedFirstValue: " + unsignedFirstValue);
        System.out.println("unsignedSecondValue: " + unsignedSecondValue);
    }

    private static void task6() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        if (number >= 10 && number <= 22) {
            System.out.println("The value is in the range <-10..22)");
        }
        else {
            System.out.println("The value is not in the range <-10..22)");
        }

        if ((number >= -10 && number <= 22) || (number > 36 && number <= 50)) {
            System.out.println("The value is in the range <-10..22) or (36..50>.");
        }
        else {
            System.out.println("The value is not in the range <-10..22) or (36..50>.");
        }

        scanner.close();
    }

    private static void task7() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        System.out.println(number >= 10 && number <= 22 ? "The value is in the range <-10..22)" : "The value is not in the range <-10..22)");
        System.out.println((number >= -10 && number <= 22) || (number > 36 && number <= 50) ? "The value is in the range <-10..22) or (36..50>." : "The value is not in the range <-10..22) or (36..50>.");

        scanner.close();
    }

    private static void task8() {
        int x = 10;
        int y = ~x;

        System.out.println("x: " + x);
        System.out.println("x: " + Integer.toBinaryString(x));
        System.out.println("y: " + y);
        System.out.println("y: " + Integer.toBinaryString(y));
    }

    private static void task9() {
        byte byteValue = 10;

        System.out.println("Bitwise shift operations on a byte variable (value 10):");
        for (int i = 0; i < 8; i++) {
            byteValue = (byte) (byteValue >> 1);
            System.out.printf("Right Shift %d: %3d (Binary: %s)%n", i + 1, byteValue, Long.toBinaryString(byteValue));

            byteValue = (byte) (byteValue << 1);
            System.out.printf("Left Shift %d:  %3d (Binary: %s)%n", i + 1, byteValue, Long.toBinaryString(byteValue));
        }

        int intValue = -10;

        System.out.println("\nBitwise shift operations on an int variable (value -10):");
        for (int i = 0; i < 8; i++) {
            intValue = intValue >> 1;
            System.out.printf("Right Shift %d: %11d (Binary: %s)%n", i + 1, intValue, Long.toBinaryString(intValue));

            intValue = intValue << 1;
            System.out.printf("Left Shift %d:  %11d (Binary: %s)%n", i + 1, intValue, Long.toBinaryString(intValue));
        }
    }

    private static void task10() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (0 to 127): ");
        int number = scanner.nextInt();

        System.out.println("Binary representation: " + Long.toBinaryString(number));
        System.out.print("Enter the number of bits to shift: ");
        int shiftBits = scanner.nextInt();

        int leftShifted = number << shiftBits;
        System.out.println("After left shifting by " + shiftBits + " bits: " + Long.toBinaryString(leftShifted));

        int rightShifted = number >> shiftBits;
        System.out.println("After right shifting by " + shiftBits + " bits: " + Long.toBinaryString(rightShifted));

        System.out.print("Enter the bit position to test: ");
        int testBit = scanner.nextInt();
        boolean isBitSet = ((number >> testBit) & 1) == 1;
        System.out.println("Bit at position " + testBit + " is set: " + isBitSet);

        System.out.print("Enter the bit position to set: ");
        int setBit = scanner.nextInt();
        number |= (1 << setBit);
        System.out.println("After setting bit at position " + setBit + ": " + Long.toBinaryString(number));

        System.out.print("Enter the bit position to clear (zero): ");
        int clearBit = scanner.nextInt();
        number &= ~(1 << clearBit);
        System.out.println("After clearing bit at position " + clearBit + ": " + Long.toBinaryString(number));

        scanner.close();
    }
    private static void task11() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        double x = scanner.nextFloat();
        double y = (Math.sqrt(Math.pow(x, 2) + 7) / 4 - Math.pow(x, 2) + Math.sin(Math.toDegrees(x) / 6));

        System.out.println("Y = " + y );

        double a = 4.146524;
        System.out.println(a);
    }

    private static void task12() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter seconds: ");
        long seconds = scanner.nextInt();

        scanner.close();

        long days = seconds / (24 * 3600);
        long remainingSeconds = seconds % (24 * 3600);
        long hours = remainingSeconds / 3600;
        remainingSeconds %= 3600;
        long minutes = remainingSeconds / 60;
        long remainingSecondsFinal = remainingSeconds % 60;

        System.out.println(seconds + " seconds is it " + days + ":" + hours + ":" + minutes + ":" + remainingSecondsFinal);
    }

    private static void task13() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("km: ");
        double km = scanner.nextDouble();

        System.out.print("l: ");
        double l = scanner.nextDouble();

        double result = l / km * 100;

        String stringFormat = String.format("%.2f", result);
        System.out.println(stringFormat);
    }

    private static void test() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        double x = scanner.nextDouble(); // 3.29383

        System.out.print("Enter a: ");
        double a = scanner.nextDouble(); // 7.39434

        double y = (((Math.sqrt(Math.pow(x, 2) + x)) / (Math.pow(x, 3) - a)) - (1 / Math.pow(x, 2)) + (Math.tan(x) / (2 * a)));

        String stringFormat = String.format("%.4f", y);
        System.out.println(stringFormat);

    }
}