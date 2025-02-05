package Task2;

import java.util.Random;

public class Elevator implements Runnable {
    private final int maxCapacity;
    private final int elevatorId;
    private int currentCapacity = 0;
    private final Random random = new Random();

    public Elevator(int maxCapacity, int elevatorId) {
        this.maxCapacity = maxCapacity;
        this.elevatorId = elevatorId;
    }

    public synchronized boolean hasSpace() {
        return currentCapacity < maxCapacity;
    }

    public synchronized void enterElevator() throws InterruptedException {
        while (currentCapacity >= maxCapacity) {
            wait();
        }
        currentCapacity++;
        System.out.println("Person entered elevator " + elevatorId + ". Current capacity: " + currentCapacity);
    }

    public synchronized void exitElevator() throws InterruptedException {
        currentCapacity--;
        System.out.println("Person exited elevator " + elevatorId + ". Current capacity: " + currentCapacity);
        notifyAll();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(3000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}