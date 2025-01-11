package Task2;

import java.util.Random;

public class Building {
    private final Elevator[] elevators;
    private final Random random = new Random();

    public Building(int numElevators, int maxCapacity) {
        elevators = new Elevator[numElevators];
        for (int i = 0; i < numElevators; i++) {
            elevators[i] = new Elevator(maxCapacity, i + 1);
            new Thread(elevators[i]).start();
        }
    }

    public synchronized Elevator getAvailableElevator() {
        for (Elevator elevator : elevators) {
            if (elevator.hasSpace()) {
                return elevator;
            }
        }
        return null;
    }

    public int getRandomFloor() {
        return random.nextInt(10) + 1;
    }
}