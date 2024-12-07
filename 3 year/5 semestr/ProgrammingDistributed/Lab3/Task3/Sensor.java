package Task3;

import java.util.Random;

public class Sensor implements Runnable {
    private Buffer buffer;
    private boolean isSensorA;
    private int maxReads;
    private Random random = new Random();

    public Sensor(Buffer buffer, boolean isSensorA, int maxReads) {
        this.buffer = buffer;
        this.isSensorA = isSensorA;
        this.maxReads = maxReads;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < maxReads; i++) {
                double value = random.nextDouble();
                
                if (isSensorA) {
                    buffer.setValues(value, 0);
                } else {
                    buffer.setValues(0, value);
                }
                
                Thread.sleep(random.nextInt(1000) + 500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}