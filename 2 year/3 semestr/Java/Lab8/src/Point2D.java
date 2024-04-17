import java.util.Scanner;

public class Point2D {

    private String name;
    private double x;
    private double y;

    public Point2D() {
        this.name = "Default";
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point2D(String name) {
        this.name = name;
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point2D(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void displayPoint() {
        System.out.println("Point " + name + ": (x = " + x + ", y = " + y + ")");
    }

    public static Point2D readPointFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the point name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the x-coordinate: ");
        double x = scanner.nextDouble();

        System.out.print("Enter the y-coordinate: ");
        double y = scanner.nextDouble();

        return new Point2D(name, x, y);
    }
    
    public Coordinates getCoordinates() {
        return new Coordinates(x, y);
    }

    public void readPoint(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setPoint(String name, double x, double y) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid input for point name.");
            return;
        }
        this.x = x;
        this.y = y;
        System.out.println("Point data set successfully.");
    }
}
