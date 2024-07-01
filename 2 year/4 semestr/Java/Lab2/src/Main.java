import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int mode = -1;

        while (mode != 0)
        {
            System.out.println("NAVIGATION");
            System.out.println("Enter 1 - task7");
            System.out.println("Enter 2 - task8");
            System.out.println("Enter 3 - task9");
            System.out.println("Enter 4 - task10");
            mode = scanner.nextInt();

            switch (mode) {
                case 2: {
                    ArrayList<String> strings = new ArrayList<>();

                    strings.add("a");
                    strings.add("aa");
                    strings.add("aaa");
                    strings.add("aaaa");

                    Comparator<String> comp = new Comparator<String>() {
                        @Override
                        public int compare(String arg0, String arg1) {
                            if (arg0.length() < arg1.length())
                            {
                                return -1;
                            }
                            else if (arg0.length() > arg1.length())
                            {
                                return 1;
                            }

                            return 0;
                        }
                        
                    };

                    luckySort(strings, comp);

                    break;
                }
                case 3: {
                    var first = new Greeter("first", 5);
                    var second = new Greeter("second", 5);
            
                    var firstThread = new Thread(first);
                    var secondThread = new Thread(second);
                    
                    firstThread.start();
                    secondThread.start();
                    break;
                }
                case 4: {
                    Runnable task1 = () -> System.out.println("Task1");
                    Runnable task2 = () -> System.out.println("Task2");
                    Runnable task3 = () -> System.out.println("Task3");
                    Runnable task4 = () -> System.out.println("Task4");

                    runTogether(task1, task2, task3, task4);
                    runInOrder(task1, task2, task3, task4);
                    break;
                }
                default:
                    break;
            }
        }
    }

    private static void luckySort(ArrayList<String> strings, Comparator<String> comp)
    {
        strings.sort(comp);
        Collections.shuffle(strings);
        strings.forEach(System.out::println);
    }

    public static void runTogether(Runnable... tasks)
    {
        final int length = tasks.length;
        Thread[] threads = new Thread[length];

        for (int i = 0; i < length; i++)
        {
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (int i = 0; i < length; i++)
        {
            try {
                threads[i].join();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void runInOrder(Runnable... tasks)
    {
        for (Runnable run : tasks)
        {
            run.run();
        }
    }
}