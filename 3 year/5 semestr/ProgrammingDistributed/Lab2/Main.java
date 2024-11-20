import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws InterruptedException {
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
      } else if (mode == 3) {
        task3();
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

  private static void task2() throws InterruptedException {
    Stoper stoper1 = new Stoper(1);
    Stoper stoper2 = new Stoper(2);

    stoper1.start();
    stoper2.start();

    Thread.sleep(3000);
    stoper1.pause();
    System.out.println("Stoper 1 on breaks.");

    Thread.sleep(2000);
    stoper1.resume();
    System.out.println("Stoper 1 has been resumed.");

    Thread.sleep(4000);
    stoper2.reset();
    System.out.println("Stoper 2 is stopped.");
  }

  private static void task3() {
    Clock clock1 = new Clock();
    clock1.format(false);
    clock1.setTime(22, 2, 2);
    clock1.tick();
    clock1.tick();
    clock1.tick();
    clock1.start5sec();

    System.out.println();

    Clock clock2 = new Clock();
    clock2.format(true);
    clock2.setTime(22, 2, 2);
    clock2.tick();
    clock2.tick();
    clock2.tick();
    clock2.start5sec();
  }
}
