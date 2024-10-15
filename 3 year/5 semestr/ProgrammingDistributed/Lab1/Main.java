import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    var mode = -1;

    while (mode != 0) {
      System.out.println("\nNAVIGATION");
      System.out.println("Enter 1 - task 1");
      System.out.println("Enter 2 - task 2");
      System.out.println("Enter 3 - task 3");
      System.out.println("Enter 4 - task 4");
      mode = scanner.nextInt();

      if (mode == 1) {
        task1();
      } else if (mode == 2) {
        task2();
      } else if (mode == 3) {
        task3();
      } else if (mode == 4) {
        task4();
      }
    }

    scanner.close();
  }

  private static void task1() {
    var watch = new Watch();
    watch.display();
  }

  private static void task2() {
    Scanner scanner = new Scanner(System.in);
    var watch = new Watch();
    System.out.print("Start time: ");
    var startTime = scanner.nextInt();
    watch.display(startTime);
    scanner.close();
  }

  private static void task3() {
    Clock clock = new Clock();
    clock.setTime(12, 25, 40);
    clock.display();
  }

  private static void task4() {
    Clock clock1 = new Clock();
    clock1.format(false);
    clock1.setTime(22, 2, 2);
    System.out.println(clock1.display());
    clock1.tick();
    System.out.println(clock1.display());
    clock1.tick();
    System.out.println(clock1.display());
    clock1.tick();
    System.out.println(clock1.display());
    clock1.start5sec();
    System.out.println(clock1.display());

    System.out.println();

    Clock clock2 = new Clock();
    clock2.format(true);
    clock2.setTime(22, 2, 2);
    System.out.println(clock2.display());
    clock2.tick();
    System.out.println(clock2.display());
    clock2.tick();
    System.out.println(clock2.display());
    clock2.tick();
    System.out.println(clock2.display());
    clock2.start5sec();
    System.out.println(clock2.display());
  }
}
