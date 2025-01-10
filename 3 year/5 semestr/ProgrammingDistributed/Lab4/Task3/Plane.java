package Task3;

import java.util.Random;

public class Plane implements Runnable {
    private final int id;
    private final Airport airport;
    private final Random random = new Random();

    public Plane(int id, Airport airport) {
        this.id = id;
        this.airport = airport;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Simulate flight or ground operations
                if (random.nextBoolean()) {
                    fly();
                } else {
                    prepareForTakeoff();
                }
            } catch (InterruptedException e) {
                System.out.println("Plane " + id + " encountered an error.");
            }
        }
    }

    private void fly() throws InterruptedException {
        int fuel = random.nextInt(5) + 1; // Random fuel level between 1 and 5
        System.out.println("Plane " + id + " is flying with fuel level: " + fuel);

        // Simulate flight duration
        while (fuel > 0) {
            Thread.sleep(1000);
            fuel--;
            System.out.println("Plane " + id + " fuel remaining: " + fuel);
        }

        System.out.println("Plane " + id + " is low on fuel and requesting landing...");
        PlaneRequest request = new PlaneRequest(id, true, fuel);
        if (airport.requestRunway(request)) {
            System.out.println("Plane " + id + " is landing...");
            Thread.sleep(2000); // Simulate landing duration
            System.out.println("Plane " + id + " has landed.");
            airport.releaseRunway();
        } else {
            System.out.println("Plane " + id + " crashed due to lack of fuel!");
        }
    }

    private void prepareForTakeoff() throws InterruptedException {
        System.out.println("Plane " + id + " is preparing for takeoff.");
        PlaneRequest request = new PlaneRequest(id, false, Integer.MAX_VALUE);
        if (airport.requestRunway(request)) {
            System.out.println("Plane " + id + " is taking off...");
            Thread.sleep(2000); // Simulate takeoff duration
            System.out.println("Plane " + id + " has taken off.");
            airport.releaseRunway();
        }
    }
}