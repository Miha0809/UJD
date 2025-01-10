import Task1.Car;
import Task1.Ferry;
import Task1.FerryRunnable;

public class Main {
    public static void main(String[] args) {
        Ferry ferry = new Ferry();
        Thread ferryThread = new Thread(new FerryRunnable(ferry));
        ferryThread.start();

        for (int i = 1; i <= 10; i++) {
            new Thread(new Car(i, ferry)).start();
        }
    }
}