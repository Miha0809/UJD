import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    var mode = -1;

    while (mode != 0) {
      System.out.println("\nNAVIGATION");
      System.out.println("Enter 1 - task 1");
      mode = scanner.nextInt();

      if (mode == 1) {
        task1();
      }
    }

    scanner.close();
  }

  private static void task1() {
    var watch = new Watch();
    watch.display();
  }
}
