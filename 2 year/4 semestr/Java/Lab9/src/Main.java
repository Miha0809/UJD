import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.math.BigInteger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static void Task1() {
List<ArrayList<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        listOfLists.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        listOfLists.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        List<Integer> result1 = listOfLists.stream()
                .reduce(
                        new ArrayList<>(),
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        },
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        });

        System.out.println("Metoda 1:");
        System.out.println("Wynik: " + result1);

        List<Integer> result2 = listOfLists.stream()
                .reduce(
                        new ArrayList<>(),
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        });

        System.out.println("Metoda 2:");
        System.out.println("Wynik: " + result2);

        List<Object> result3 = listOfLists.stream()
                .reduce(
                        Stream.empty(),
                        (s1, s2) -> Stream.concat(s1, s2.stream()),
                        Stream::concat)
                .toList();

        System.out.println("Metoda 3:");
        System.out.println("Wynik: " + result3);

    }

    private static void Task2() {
        Stream<Double> doubleStream = Stream.of(1.5, 2.5, 3.5, 4.5, 5.5);

        double average = doubleStream
                .reduce(
                        new AverageAccumulator(0, 0),
                        AverageAccumulator::accumulate,
                        AverageAccumulator::combine)
                .average();

        System.out.println("Średnia: " + average);
    }

    private static class AverageAccumulator {
        private int count;
        private double sum;

        public AverageAccumulator(int count, double sum) {
            this.count = count;
            this.sum = sum;
        }

        public AverageAccumulator accumulate(Double value) {
            return new AverageAccumulator(count + 1, sum + value);
        }

        public AverageAccumulator combine(AverageAccumulator other) {
            return new AverageAccumulator(count + other.count, sum + other.sum);
        }

        public Double average() {
            return count > 0 ? sum / count : 0.0;
        }
    }

    private static void Task3() {
        long startTime = System.currentTimeMillis();

        List<BigInteger> primes = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE))
                .filter(n -> n.isProbablePrime(100))
                .limit(500)
                .toList();

        long endTime = System.currentTimeMillis();

        System.out.println("Pierwsze 500 liczb pierwszych:");
        primes.forEach(System.out::println);
        System.out.println("Czas wykonania (ms): " + (endTime - startTime));
    }

    private static void Task4() throws IOException {
        final String filePath = "";
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        String text = String.join(" ", lines);

        List<String> longestStrings = text.codePoints()
                .parallel()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingByConcurrent(s -> s, Collectors.counting()))
                .entrySet()
                .parallelStream()
                .sorted(Comparator.comparingLong(e -> -e.getValue()))
                .limit(500)
                .map(Map.Entry::getKey)
                .toList();

        longestStrings.forEach(System.out::println);
    }

    private static void Task5() {}

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int task = -1;

        while (task != 0) {
            System.out.println("\n\t\tNAVIGATION");
            System.out.println("Task 1 - enter 1");
            System.out.println("Task 2 - enter 2");
            System.out.println("Task 3 - enter 3");
            System.out.println("Task 4 - enter 4");
            System.out.println("Task 5 - enter 5");
            System.out.println("EXIT - enter 0");
            task = scanner.nextInt();

            switch (task) {
                case 1: {
                    Task1();
                    break;
                }
                case 2: {
                    Task2();
                    break;
                }
                case 3: {
                    Task3();
                    break;
                }
                case 4: {
                    Task4();
                    break;
                }
                case 5: {
                    Task5();
                    break;
                }
                default:
                    break;
            }
        }

    }
}