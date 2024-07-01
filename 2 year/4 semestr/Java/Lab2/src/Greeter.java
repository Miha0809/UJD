public class Greeter implements Runnable {
    private final String targer;
    private final int n;

    public Greeter(String target, int n)
    {
        this.targer = target;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.n; i++)
        {
            System.out.println("Witaj, " + this.targer);
        }
    }
}
