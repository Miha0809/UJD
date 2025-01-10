import Task1.*;
import Task2.*;

public class Main {
    private static final int MAX_CAPACITY = 3;
    private static final int NUM_ELEVATORS = 3;
    private static final int NUM_PEOPLE = 10;

    public static void main(String[] args) {
        // Task 1
        // Ferry ferry = new Ferry();
        // Thread ferryThread = new Thread(new FerryRunnable(ferry));
        // ferryThread.start();

        // for (int i = 1; i <= 10; i++) {
        //     new Thread(new Car(i, ferry)).start();
        // }

        // Task 2
        Building building = new Building(NUM_ELEVATORS, MAX_CAPACITY);
        for (int i = 1; i <= NUM_PEOPLE; i++) {
            new Thread(new Person(i, building)).start();
        }
    }
}