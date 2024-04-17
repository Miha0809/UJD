package zadanie2;

import java.util.Scanner;
import java.util.Stack;

public class zadanie4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number: ");
        int number = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        while (number > 0) {
            stack.push(number % 10);
            number /= 10;
        }

        String numbers = "";

        while (!stack.isEmpty()) {
            int _number = (Integer) stack.pop();
            numbers += _number;

            if (stack.size() != 0) {
                numbers += "-";
            }
        }

        System.out.println(numbers);
    }
}
