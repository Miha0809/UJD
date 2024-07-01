import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    private static void formatDateTime(LocalDateTime dateTime, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy HH:mm:ss", locale);
        ZoneId zoneId = ZoneId.of("UTC+0");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
        System.out.println("Locale: " + locale + " - Formatted Date and Time: " + formatter.format(zonedDateTime));
    }
    private static void Task1() {
        LocalDateTime now = LocalDateTime.now();
        formatDateTime(now, Locale.FRANCE);
        formatDateTime(now, Locale.CHINA);
        formatDateTime(now, new Locale("th", "TH"));
    }

    private static void Task2() {}

    private static void Task3() {}

    private static void Task4() {
        Set<String> availableLanguages = Arrays.stream(Locale.getAvailableLocales())
                .map(Locale::getDisplayLanguage)
                .filter(language -> !language.isEmpty())
                .collect(Collectors.toSet());

        System.out.println("Lista wszystkich języków:");
        availableLanguages.forEach(System.out::println);
    }

    private static void Task5() {
        Set<String> availableCurrencies = Currency.getAvailableCurrencies().stream()
                .map(Currency::getDisplayName)
                .filter(currency -> !currency.isEmpty())
                .collect(Collectors.toSet());

        System.out.println("Lista wszystkich walut:");
        availableCurrencies.forEach(System.out::println);
    }

    private static void Task6() {}

    private static void Task7() {
        Locale[] locales = Locale.getAvailableLocales();
        Map<String, String> monthNames = new TreeMap<>();

        for (Locale locale : locales) {
            DateFormatSymbols symbols = new DateFormatSymbols(locale);
            String[] months = symbols.getMonths();

            boolean allNumeric = Arrays.stream(months).allMatch(s -> s.matches("\\d+"));

            if (!allNumeric) {
                String monthNamesStr = Arrays.toString(months);
                monthNames.put(locale.getDisplayName(), monthNamesStr);
            }
        }

        monthNames.forEach((locale, names) -> {
            System.out.println("Lokalizacja: " + locale);
            System.out.println("Miesiące: " + names);
            System.out.println();
        });
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
            System.out.println("Task 7 - enter 7");
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
                case 7: {
                    Task7();
                    break;
                }
                default:
                    scanner.close();
                    break;
            }
        }
    }
}