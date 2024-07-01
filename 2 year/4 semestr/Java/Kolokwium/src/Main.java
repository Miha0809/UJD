import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 1, 1);
        LocalDate dayProgrammer = date.plusDays(256);
        System.out.println(dayProgrammer);
    }
}