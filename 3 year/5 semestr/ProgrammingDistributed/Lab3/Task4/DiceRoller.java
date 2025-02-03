package Task4;

public class DiceRoller implements Runnable {
    private Buffer buffer;

    public DiceRoller(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (!buffer.isGameOver()) {
                buffer.rollDice();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
