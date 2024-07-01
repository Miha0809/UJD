package zadanie1;

public class zadanie2 {
    public static <T extends Comparable<T>> int find(T[] array, T target) {
        if (array == null || array.length == 0)
            return -1;

        int lastIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(target) == 0) {
                lastIndex = i;
            }
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 3, 5, 7, 3, 9, 11};
        String[] strings = {"apple", "banana", "orange", "banana", "grape"};

        int lastIndexForNumber = find(numbers, 3);
        int lastIndexForString = find(strings, "banana");

        System.out.println("Last index for number 3: " + lastIndexForNumber);
        System.out.println("Last index for string 'banana': " + lastIndexForString);
    }
}
