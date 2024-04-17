package zadanie2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class zadanie3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String numberString = scanner.nextLine();

        Map<Integer, Integer> digitOccurrences = new HashMap<>();

        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            if (Character.isDigit(digitChar)) {
                int digit = Character.getNumericValue(digitChar);
                digitOccurrences.put(digit, digitOccurrences.getOrDefault(digit, 0) + 1);
            }
        }

        System.out.println("Occurrences of digits in the entered number:");
        for (Map.Entry<Integer, Integer> entry : digitOccurrences.entrySet()) {
            System.out.println("Digit: " + entry.getKey() + ", Occurrences: " + entry.getValue());
        }
    }
}
