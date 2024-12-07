package Task4;

import java.util.Random;

public class Buffer {
    private int number1, number2;
    private boolean diceRolled = false;
    private boolean gameOver = false;

    public synchronized void rollDice() throws InterruptedException {
        while (diceRolled && !gameOver) {
            wait();
        }

        if (gameOver) {
            return;
        }

        Random random = new Random();
        number1 = random.nextInt(6) + 1;
        number2 = random.nextInt(6) + 1;
        System.out.println("Dice throw: " + number1 + ", " + number2);
        diceRolled = true;
        notifyAll();
    }

    public synchronized int[] getDiceValues() throws InterruptedException {
        while (!diceRolled && !gameOver) {
            wait();
        }

        if (gameOver) {
            return null;
        }

        diceRolled = false;
        notifyAll();
        return new int[]{number1, number2};
    }

    public synchronized void endGame() {
        gameOver = true;
        notifyAll();
    }

    public synchronized boolean isGameOver() {
        return gameOver;
    }
}
