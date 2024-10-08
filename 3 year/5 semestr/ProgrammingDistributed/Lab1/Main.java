import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    var mode = -1;

    while (mode != 0) {
      System.out.println("\nNAVIGATION");
      System.out.println("Enter 1 - task 1");
      System.out.println("Enter 2 - task 2");
      mode = scanner.nextInt();

      if (mode == 1) {
        task1();
      } else if (mode == 2) {
        task2();
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
}
