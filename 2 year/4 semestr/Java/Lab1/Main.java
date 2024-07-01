package Lab1;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t\tNAVIGATION");
            System.out.println("task1 - 1");
            System.out.println("task2 - 2");
            System.out.println("task4a - 4");
            System.out.println("task4b - 5");
            System.out.println("task5 - 6");
            System.out.println("task6 - 7");
            System.out.println("exit - other");
            System.out.print(">>> ");
            short task = scanner.nextShort();

            switch (task) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 4:
                    task4a();
                    break;
                case 5:
                    task4b();
                    break;
                case 6:
                    task5();
                    break;
                case 7:
                    task6();
                    break;
                default:
                    scanner.close();
                    return;
            }
        }
    }

    private static void task1() {
        Measurable[] measurables = {new Employee(14), new Employee(19), new Employee(25), new Employee(40)};

        System.out.println(average(measurables));
    }

    private static void task2() {
        Measurable[] measurables = {new Employee(14, "Mark"), new Employee(19, "Witold"), new Employee(25, "Dima"), new Employee(40, "Michał")};

        System.out.println(largest(measurables));
    }

    private static void task4a() {
        IntSequence isc = IntSequence.of(3, 1, 4, 1, 5, 9);

        while (isc.hasNext()) {
            System.out.println(isc.next());
        }
    }

    private static void task4b() {
        // Nie wiem
    }

    private static void task5() {
        // nie wiem
    }

    private static void task6() {
        BigInteger[] numbers = {BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(5), BigInteger.valueOf(6)};
        SquareSequence squareSequence = new SquareSequence(numbers);

        while (squareSequence.hasNext()) {
            System.out.println(squareSequence.next());
        }
    }

    private static double average(Measurable[] objects) {
        double suma = 0;

        if (objects.length == 0) {
            return suma;
        }

        for (Measurable measurable : objects) {
            suma += measurable.getMeasure();
        }

        return suma / objects.length;
    }

    private static Measurable largest(Measurable[] objects) {
        if (objects.length == 0) {
            return null;
        }

        double max = Double.MIN_VALUE;
        Measurable employee = new Employee();

        for (Measurable measurable : objects) {
            if (measurable.getMeasure() > max) {
                max = measurable.getMeasure();
                employee = measurable;
            }
        }

        return employee;
    }
}
