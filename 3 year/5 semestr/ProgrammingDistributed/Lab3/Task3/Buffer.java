package Task3;

public class Buffer {
    private double a;
    private double b;
    private boolean dataAvailable = false;

    public synchronized void setValues(double a, double b) throws InterruptedException {
        while (dataAvailable) {
            wait();
        }

        this.a = a;
        this.b = b;
        dataAvailable = true;
        notifyAll();
    }

    public synchronized double[] getValues() throws InterruptedException {
        while (!dataAvailable) {
            wait();
        }

        dataAvailable = false;
        notifyAll();

        return new double[] { a, b };
    }
}
