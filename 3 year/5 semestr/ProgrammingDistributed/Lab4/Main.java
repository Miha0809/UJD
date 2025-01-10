import Task1.*;
import Task2.*;
import Task3.*;

public class Main {


    public static void main(String[] args) {
        // Task 1
        // Ferry ferry = new Ferry();
        // Thread ferryThread = new Thread(new FerryRunnable(ferry));
        // ferryThread.start();

        // for (int i = 1; i <= 10; i++) {
        //     new Thread(new Car(i, ferry)).start();
        // }

        // Task 2
        // final int MAX_CAPACITY = 3;
        // final int NUM_ELEVATORS = 3;
        // final int NUM_PEOPLE = 10;
        // Building building = new Building(NUM_ELEVATORS, MAX_CAPACITY);
        // for (int i = 1; i <= NUM_PEOPLE; i++) {
        //     new Thread(new Person(i, building)).start();
        // }

        // Task 3
        final int RUNWAYS = 3;
        final int PLANES = 10;
        Airport airport = new Airport(RUNWAYS);

        for (int i = 1; i <= PLANES; i++) {
            new Thread(new Plane(i, airport)).start();
        }
    }
}