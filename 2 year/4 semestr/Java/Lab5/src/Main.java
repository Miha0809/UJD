import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static void Task1() throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(text);
        AtomicInteger filterCount = new AtomicInteger(0);
        List<String> result = wordList.stream()
                                      .flatMap(line -> Stream.of(line.split("\\s+")))
                                      .filter(word -> {
                                            filterCount.incrementAndGet();
                                            System.out.println("Filter called for: " + word);
                                            return word.length() > 5;
                                       })
                                       .limit(5)
                                       .collect(Collectors.toList());

        System.out.println("Result" + result);
        System.out.println("Total filter calls: " + filterCount.get());
    }

    private static void Task2() throws IOException
    {
        String text = new String(Files.readAllBytes(
            Paths.get("alice.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(text.split("\\PL+"));
        
        // for stream
        long startFirstTime = System.currentTimeMillis();
        long first = wordList.stream()
                             .filter(word -> word.length() > 12)
                             .count();
        long endFirstTime = System.currentTimeMillis();

        // for parallelStream
        long startSecondTime = System.currentTimeMillis();
        long second = wordList.parallelStream()
                              .filter(word -> word.length() > 12)
                              .count();
        long endSecondTime = System.currentTimeMillis();

        System.out.println("stream count: " + first);
        System.out.println("parallelStream count: " + second);
    
        System.out.println("stream: " + (endFirstTime - startFirstTime));
        System.out.println("parallelStream: " + (endSecondTime - startSecondTime));
    }

    private static void Task3() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        Arrays.stream(numbers).forEach(System.out::println);
    } 

    private static void Task4() {
        long a = 25214903917L;
        long c = 11;
        long m = (1L << 48);
        long seed = System.currentTimeMillis() & ((1L << 48) - 1);

        Stream<Long> randomStream = lcg(a, c, m, seed);
        
        randomStream.limit(10).forEach(System.out::println);
    }

    private static Stream<Long> lcg(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int task = -1;

        while (task != 0) {
            System.out.println("\n\t\tNAVIGATION");
            System.out.println("Task 1 - enter 1");
            System.out.println("Task 2 - etner 2");
            System.out.println("Task 3 - etner 3");
            System.out.println("Task 4 - etner 4");
            System.out.println("EXIT - etner 0");
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
                default:
                    break;
            }
        }
    }
}