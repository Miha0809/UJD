package Task1;

public class Car implements Runnable {
    private final int name;
    private final Ferry ferry;
    private boolean onBoard = false;
    private boolean atLeftBank = true;

    public Car(int name, Ferry ferry) {
        this.name = name;
        this.ferry = ferry;
    }

    public int getName() {
        return name;
    }

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public boolean isAtLeftBank() {
        return atLeftBank;
    }

    public void toggleBank() {
        atLeftBank = !atLeftBank;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 4000) + 1000);
                System.out.println("Car: " + name + " is waiting at the " + (atLeftBank ? "left" : "right") + " bank.");
                ferry.load(this);
                ferry.unload();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}