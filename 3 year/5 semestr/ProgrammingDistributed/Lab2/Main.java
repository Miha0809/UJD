import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws InterruptedException {
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

  private static void task1() throws InterruptedException {
    Timer timer1 = new Timer(10);
    Timer timer2 = new Timer(5);

    timer1.start();
    timer2.start();

    Thread.sleep(3000);
    timer1.pause();
    System.out.println("Timer 1 on breaks.");

    Thread.sleep(2000);
    timer1.resume();
    System.out.println("Timer 1 has been resumed.");

    Thread.sleep(4000);
    timer2.stop();
    System.out.println("Timer 2 is stopped.");
  }
}
