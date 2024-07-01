import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short mode = -1;

        while (mode != 0) {
            System.out.println("\t\tNAVIGATION");
            System.out.println("Enter 3 - task 3");
            System.out.println("Enter 5 - task 5");
            System.out.println("Enter 6 - task 6");
            System.out.println("Enter 7 - task 7");
            System.out.println("Enter 8 - task 8");
            System.out.println("Enter 9 - task 9");
            System.out.println("Enter 0 - EXIT");
            System.out.print("Enter task >>> ");
            mode = scanner.nextShort();

            switch (mode) {
                case 3:
                    task3();
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
                default:
                    break;
            }
        }
    }

    private static void task3() {
        String pesel = "12345678901";
        int age = 30;
        double pow = Math.pow(2, 3);
        float temperature = 0.0f;
        char code = 'X';
        boolean state = true;
        String text = "To jest napis";
        text += " kolejny";
        char symbolFi = '\u03A6';

        // Wyświetlanie zmiennych
        System.out.println("PESEL: " + pesel + " (String)");
        System.out.println("Age: " + age + " (int)");
        System.out.println("pow: " + pow + " (double)");
        System.out.println("Temperature: " + temperature + " (float)");
        System.out.println("Code: " + code + " (char)");
        System.out.println("State (true/false): " + state + " (boolean)");
        System.out.println(text + " (String)");
        System.out.println("Fi: " + symbolFi + " (char)");

        // Zmienne bez inicjalizacji
        int notInitNumber; // Niezainicjalizowana liczba
        char notInitChar; // Niezainicjalizowany znak

//        System.out.println("Niezainicjalizowana liczba: " + notInitNumber + " (int)");
//        System.out.println("Niezainicjalizowany znak: " + notInitChar + " (char)");
    }

    private static void task5() {
        Scanner scanner = new Scanner(System.in);
        final byte maxAge = 100;

        System.out.print("Enter your name: ");
        String name = scanner.next();

        System.out.print("Enter your age: ");
        byte age = scanner.nextByte();
        int result = maxAge - age;

        System.out.println("Hej " + name + " you have " + age + " age, you have left " + result);
    }

    private static void task6() {
        task5();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Next task");
        System.out.println("Real numbers");

        System.out.print("Enter your weight: ");
        float weight = scanner.nextFloat();

        float weight100kg = 100 - weight;
        System.out.println("you are " + weight100kg + " kg short of 100 kg");
    }

    private static void task7() {
        int a = 10, b = 3;

        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + (a / b));
        System.out.println("a = " + a + " -> ++a = " + (++a));
        System.out.println("a = " + a + " -> a++ = " + (a++));
        System.out.println("a = " + a);
    }

    private static void task8() {
        byte var1 = Byte.MAX_VALUE;
        System.out.println(var1 + 1);

        double result = Math.pow(2, 63);
        result *= 2;
        result = Math.pow(result, 1024);
        System.out.println(result);
    }

    private enum Color {
        White,
        Black,
        Blue,
        Yellow
    }

    private static void task9() {
        Color color = Color.Blue;

        switch (color) {
            case White:
                System.out.println("You selected color is White.");
                break;
            case Black:
                System.out.println("You selected color is Black.");
                break;
            case Blue:
                System.out.println("You selected color is Blue.");
                break;
            case Yellow:
                System.out.println("You selected color is Yellow.");
                break;
            default:
                System.out.println("Unknown color.");
                break;
        }
    }
}