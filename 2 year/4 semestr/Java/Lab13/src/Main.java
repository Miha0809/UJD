import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  private static void Task1() {
    LocalTime start = LocalTime.now();
    LocalTime end = start.plusHours(1);
    var timeInterval = new TimeInterval(start, end);
    System.out.println(timeInterval.overlapsWith(timeInterval));
  }

  private static void Task2() {
    Set<String> zoneIds = ZoneId.getAvailableZoneIds();

    LocalDate today = LocalDate.now();

    zoneIds.stream()
        .map(ZoneId::of)
        .forEach(
            zone -> {
              int offset = today.atStartOfDay(zone).getOffset().getTotalSeconds() / 3600;
              System.out.println(
                  "Strefa czasowa: " + zone + ", Przesunięcie: " + offset + " godzin");
            });
  }

  private static void Task3() {
    Set<String> zoneIds = ZoneId.getAvailableZoneIds();

    zoneIds.stream()
        .map(ZoneId::of)
        .filter(
            zone -> zone.getRules()
                .getOffset(
                    zone.getRules()
                        .getTransition(
                            LocalDate.now().atStartOfDay(zone).toLocalDateTime())
                        .getInstant())
                .getTotalSeconds()
                % 3600 != 0)
        .forEach(System.out::println);
  }

  private static void Task4() {
    ZoneId losAngelesZone = ZoneId.of("America/Los_Angeles");
    ZoneId frankfurtZone = ZoneId.of("Europe/Berlin");
    LocalDateTime departureDateTime = LocalDateTime.of(2024, 6, 16, 15, 5);

    Duration flightDuration = Duration.ofHours(10).plusMinutes(50);
    ZonedDateTime departureZonedDateTime = departureDateTime.atZone(losAngelesZone);
    ZonedDateTime arrivalZonedDateTime = departureZonedDateTime.plus(flightDuration);
    ZonedDateTime arrivalInFrankfurt = arrivalZonedDateTime.withZoneSameInstant(frankfurtZone);

    System.out.println("Data i czas odlotu z Los Angeles: " + departureZonedDateTime);
    System.out.println("Data i czas przylotu do Frankfurtu: " + arrivalInFrankfurt);
  }

  private static void Task5() {
    ZoneId frankfurtZone = ZoneId.of("Europe/Berlin");
    ZoneId losAngelesZone = ZoneId.of("America/Los_Angeles");
    LocalDateTime departureDateTime = LocalDateTime.of(2024, 6, 20, 14, 5); // 20 czerwca 2024 o 14:05 czasu
    // lokalnego we Frankfurcie
    LocalDateTime arrivalDateTime = LocalDateTime.of(2024, 6, 20, 16, 40); // 20 czerwca 2024 o 16:40 czasu
    // lokalnego w Los Angeles

    ZonedDateTime departureZonedDateTime = departureDateTime.atZone(frankfurtZone);
    ZonedDateTime arrivalZonedDateTime = arrivalDateTime.atZone(losAngelesZone);

    Duration flightDuration = Duration.between(departureZonedDateTime, arrivalZonedDateTime);

    System.out.println("Data i czas odlotu z Frankfurtu: " + departureZonedDateTime);
    System.out.println("Data i czas przylotu do Los Angeles: " + arrivalZonedDateTime);

    long hours = flightDuration.toHours();
    long minutes = flightDuration.toMinutesPart();
    System.out.println("Czas trwania lotu: " + hours + " godzin " + minutes + " minut");
  }

  private static void Task6() {
    List<ZonedDateTime> meetings = new ArrayList<>();
    meetings.add(
        ZonedDateTime.of(LocalDateTime.of(2024, 6, 16, 9, 0), ZoneId.of("America/Los_Angeles")));
    meetings.add(
        ZonedDateTime.of(LocalDateTime.of(2024, 6, 16, 11, 30), ZoneId.of("Europe/Berlin")));
    meetings.add(ZonedDateTime.of(LocalDateTime.of(2024, 6, 16, 14, 45), ZoneId.of("Asia/Tokyo")));
    meetings.add(
        ZonedDateTime.of(LocalDateTime.of(2024, 6, 16, 18, 15), ZoneId.of("Australia/Sydney")));
    ZonedDateTime currentDateTime = ZonedDateTime.now();
    ZonedDateTime oneHourLater = currentDateTime.plusHours(1);

    System.out.println("Spotkania rozpoczynające się w ciągu najbliższej godziny:");

    for (ZonedDateTime meeting : meetings) {
      if (meeting.isAfter(currentDateTime) && meeting.isBefore(oneHourLater)) {
        String formattedMeeting = meeting.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z"));
        System.out.println(" - " + formattedMeeting);
      }
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
        case 6: {
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
