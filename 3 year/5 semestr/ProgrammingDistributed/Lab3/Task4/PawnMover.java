package Task4;

public class PawnMover implements Runnable {
    private Buffer buffer;
    private int positionA = 0;
    private int positionB = 0;

    public PawnMover(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (!buffer.isGameOver()) {
                int[] diceValues = buffer.getDiceValues();
                if (diceValues == null) {
                    break;
                }

                int die1 = diceValues[0];
                int die2 = diceValues[1];
                int sum = die1 + die2;

                if (die1 % 2 == 0) {
                    positionA += sum;
                    System.out.println("Pawn A is moved to a position: " + positionA);
                } else {
                    positionB += sum;
                    System.out.println("Pawn B is moved to a position: " + positionB);
                }

                if (positionA >= 100 || positionB >= 100) {
                    buffer.endGame();
                    System.out.println("Game over!");
                    System.out.println("Final position: A = " + positionA + ", B = " + positionB);
                    break;
                }

                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
