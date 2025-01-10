package Task3;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Airport {
    private final int runways;
    private int occupiedRunways = 0; // Tracks the number of busy runways
    private final PriorityBlockingQueue<PlaneRequest> runwayQueue = new PriorityBlockingQueue<>(10, Comparator.comparingInt(PlaneRequest::getPriority));

    public Airport(int runways) {
        this.runways = runways;
    }

    public synchronized boolean requestRunway(PlaneRequest request) throws InterruptedException {
        runwayQueue.put(request);
        while (!runwayQueue.peek().equals(request) || occupiedRunways >= runways) {
            wait(); // Wait if this plane's request is not the highest priority or no runways are free
        }
        runwayQueue.poll(); // Remove the plane from the queue
        occupiedRunways++;
        return true;
    }

    public synchronized void releaseRunway() {
        occupiedRunways--;
        notifyAll(); // Notify all waiting planes
    }
}
