package Task2;
import java.util.Random;

public class Producer implements Runnable {
    private Buffer buffer;
    private int end;

    public Producer(Buffer buffer, int end) {
        this.buffer = buffer;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < end; i++) {
                Thread.sleep(1000);
                Integer randomNumber = new Random().nextInt(0, 9);
                buffer.produce(randomNumber);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
