import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {
    private static void Task1() {
        ZoneId franceZone = ZoneId.of("Europe/Paris");
        ZoneId chinaZone = ZoneId.of("Asia/Shanghai");
        ZoneId thailandZone = ZoneId.of("Asia/Bangkok");
        ZonedDateTime franceDateTime = ZonedDateTime.now(franceZone);
        ZonedDateTime chinaDateTime = ZonedDateTime.now(chinaZone);
        ZonedDateTime thailandDateTime = ZonedDateTime.now(thailandZone);

        System.out.println("Data i czas we Francji:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy, HH:mm:ss", Locale.FRANCE);
        String formattedDateTime = franceDateTime.format(formatter);
        System.out.println(formattedDateTime);

        System.out.println("\nData i czas w Chinach:");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy, HH:mm:ss", Locale.CHINA);
        String formattedDateTime2 = chinaDateTime.format(formatter2);
        System.out.println(formattedDateTime2);

        System.out.println("\nData i czas w Tajlandii (z cyframi tajskimi):");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy, HH:mm:ss", new Locale("th", "TH"));
        String formattedDateTime3 = thailandDateTime.format(formatter3);
        System.out.println(formattedDateTime3);
    }

    private static void Task2() {
        Locale[] locales = Locale.getAvailableLocales();

        for (Locale locale : locales) {
            try {
                DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);
                char zeroDigit = symbols.getZeroDigit();
                if (Character.UnicodeBlock.of(zeroDigit) != Character.UnicodeBlock.BASIC_LATIN) {
                    System.out.println(locale + " uses non-Western digits: " + zeroDigit);
                }
            } catch (Exception e) {
            }
        }
    }

    private static void Task3() {
        List<Locale> locales = Arrays.asList(Locale.getAvailableLocales());

        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

        for (Locale locale : locales) {
            try {
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
                if (df instanceof SimpleDateFormat) {
                    SimpleDateFormat sdf = (SimpleDateFormat) df;
                    if (sdf.toPattern().equals("M/d/yyyy")) {
                        System.out.println(locale + " uses the same date format as the United States");
                    }
                }
            } catch (Exception e) {
                // Ignore locales that cause exceptions (not supported or invalid)
            }
        }
    }

    private static void Task4() {
        Locale[] locales = Locale.getAvailableLocales();
        Set<String> uniqueLanguageNames = new HashSet<>();

        for (Locale locale : locales) {
            String language = locale.getDisplayLanguage();
            uniqueLanguageNames.add(language);
        }

        for (String languageName : uniqueLanguageNames) {
            System.out.println(languageName);
        }
    }

    private static void Task5() {
        Currency[] currencies = Currency.getAvailableCurrencies().toArray(new Currency[0]);
        Set<String> uniqueCurrencyNames = new HashSet<>();

        for (Currency currency : currencies) {
            for (Locale locale : Locale.getAvailableLocales()) {
                String currencyName = currency.getDisplayName(locale);
                uniqueCurrencyNames.add(currencyName);
            }
        }

        for (String currencyName : uniqueCurrencyNames) {
            System.out.println(currencyName);
        }
    }

    private static void Task6() {
        Currency[] currencies = Currency.getAvailableCurrencies().toArray(new Currency[0]);
        Set<Currency> currenciesWithDifferentSymbols = new HashSet<>();

        for (Currency currency : currencies) {
            Set<String> uniqueSymbols = new HashSet<>();

            for (Locale locale : Locale.getAvailableLocales()) {
                String symbol = currency.getSymbol(locale);
                uniqueSymbols.add(symbol);
            }

            if (uniqueSymbols.size() > 1) {
                currenciesWithDifferentSymbols.add(currency);
            }
        }

        for (Currency currency : currenciesWithDifferentSymbols) {
            System.out.println(currency.getCurrencyCode() + ": " + currency.getDisplayName() + " - " + currency.getSymbol());
        }
    }

    private static boolean areMonthNamesDigits(String[] months) {
        for (String month : months) {
            if (!month.matches("\\d+")) {
                return false;
            }
        }
        return true;
    }
    private static void Task7() {
        Locale[] locales = Locale.getAvailableLocales();
        List<String> differentMonthNames = new ArrayList<>();
        DateFormatSymbols standardSymbols = new DateFormatSymbols(Locale.ENGLISH);
        String[] standardMonths = standardSymbols.getMonths();

        for (Locale locale : locales) {
            DateFormatSymbols symbols = new DateFormatSymbols(locale);
            String[] months = symbols.getMonths();

            boolean different = false;
            for (int i = 0; i < months.length; i++) {
                if (!months[i].equals(standardMonths[i])) {
                    different = true;
                    break;
                }
            }

            if (different && !areMonthNamesDigits(months)) {
                differentMonthNames.add(locale.getDisplayName() + " (" + locale + ")");
            }
        }

        for (String name : differentMonthNames) {
            System.out.println(name);
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