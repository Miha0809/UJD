import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
  private static void Task1() {
    int year = 2024;

    LocalDate programmersDay = LocalDate.of(year, 1, 1).plusDays(255);

    System.out.println("Dzień Programisty w roku " + year + " to: " + programmersDay);
  }

  private static void Task2() {
    LocalDate date = LocalDate.of(2000, 2, 29);
    LocalDate nextYear = date.plusYears(1);
    System.out.println("Data po dodaniu jednego roku: " + nextYear);
  }

  private static void Task3() {}

  private static void Task4(String[] args) {
    if (args.length < 2) {
      System.out.println("Użycie: java Cal <miesiąc> <rok>");
      return;
    }

    int month = Integer.parseInt(args[0]);
    int year = Integer.parseInt(args[1]);

    LocalDate date = LocalDate.of(year, month, 1);
    int daysInMonth = date.lengthOfMonth();
    DayOfWeek firstDayOfMonth = date.getDayOfWeek();

    System.out.println("Pon Wt Śr Czw Pt Sob Nie");

    int offset = firstDayOfMonth.getValue() % 7;
    int weeks = (offset + daysInMonth) / 7 + ((offset + daysInMonth) % 7 == 0 ? 0 : 1);
    int day = 1;

    for (int i = 0; i < weeks; i++) {
      for (int j = 0; j < 7; j++) {
        if (i == 0 && j < offset) {
          System.out.print("   ");
        } else {
          if (day <= daysInMonth) {
            System.out.printf("%2d ", day);
            day++;
          }
        }
      }
      System.out.println();
    }
  }

  private static void Task5() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Podaj datę urodzenia (RRRR-MM-DD): ");
    String birthDateString = scanner.nextLine();

    LocalDate birthDate = LocalDate.parse(birthDateString);

    long daysAlive = ChronoUnit.DAYS.between(birthDate, LocalDate.now());

    System.out.println("Żyjesz już " + daysAlive + " dni.");
  }

  private static void Task6() {
    LocalDate startDate = LocalDate.of(1900, Month.JANUARY, 13);
    LocalDate endDate = LocalDate.of(1999, Month.DECEMBER, 13);
    LocalDate date = startDate;

    while (!date.isAfter(endDate)) {
      if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
        System.out.println(date);
      }
      date = date.plusMonths(1);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int task = -1;

    while (task != 0) {
      System.out.println("\n\t\tNAVIGATION");
      System.out.println("Task 1 - enter 1");
      System.out.println("Task 2 - enter 2");
      System.out.println("Task 3 - enter 3");
      System.out.println("Task 4 - enter 4");
      System.out.println("Task 5 - enter 5");
      System.out.println("Task 6 - enter 6");
      System.out.println("EXIT - enter 0");
      task = scanner.nextInt();

      switch (task) {
        case 1:
          {
            Task1();
            break;
          }
        case 2:
          {
            Task2();
            break;
          }
        case 3:
          {
            Task3();
            break;
          }
        case 4:
          {
            Task4(args);
            break;
          }
        case 5:
          {
            Task5();
            break;
          }
        case 6:
          {
            Task6();
            break;
          }
        default:
          scanner.close();
          break;
      }
    }
  }
}
