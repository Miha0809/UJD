package zadanie1;

import java.util.Arrays;

public class zadanie1 {
    private static <T extends Comparable<T>> T theSecend(T[] obj) {
        Arrays.sort(obj);
        return obj[obj.length - 2];
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer number = theSecend(numbers);
        System.out.println("Number: " + number);

        String[] names = {"A", "B", "C", "D"};
        String name = theSecend(names);
        System.out.println("Name: " + name);
    }
}
