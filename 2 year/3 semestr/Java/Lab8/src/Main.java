import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t\tNAVIGATION");
            System.out.println("Enter 1 - task 1");
            System.out.println("Enter 2 - task 2");
            System.out.println("Enter 3 - task 3");
            System.out.println("Enter 4 - task 4");
            System.out.println("Enter 5 - task 5");
            System.out.println("Enter 0 - EXIT");
            System.out.print("Enter task >>> ");
            short mode = scanner.nextShort();

            switch (mode) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
               case 3:
                   task3();
                   break;
               case 4:
                   task4();
                   break;
               case 5:
                   task5();
                   break;
                default:
                    return;
            }
        }
    }

    private static void task1() {
        Point2D point1 = new Point2D("First", 13.0, 5.5);
        Point2D point2 = new Point2D("Second", -21.0, 3.7);

        point1.displayPoint();
        point2.displayPoint();

        Point2D userPoint = Point2D.readPointFromUser();
        userPoint.displayPoint();
    }

    private static void task2() {
        Scanner scanner = new Scanner(System.in);
        Point2D point1 = new Point2D("First", 3.0, 5.0);
        Point2D point2 = new Point2D("Second", -1.0, 2.5);

        point1.displayPoint();
        point2.displayPoint();

        System.out.println("Enter new data for a point");
        System.out.print("Enter the point name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter the x-coordinate: ");
        double newX = scanner.nextDouble();

        System.out.print("Enter the y-coordinate: ");
        double newY = scanner.nextDouble();

        point1.setPoint(newName, newX, newY);
        point1.displayPoint();
    }

    private static void task3() {
        Point2D point1 = new Point2D("First", 3.0, 5.0);

        point1.displayPoint();

        Coordinates coordinates = point1.getCoordinates();
        System.out.println("Coordinates: (x = " + coordinates.getX() + ", y = " + coordinates.getY() + ")");
    }

    private static void task4() {
        Point2D defaultPoint = new Point2D();
        Point2D namedPoint = new Point2D("CustomPoint");
        Point2D specificPoint = new Point2D("First", 3.0, 5.0);

        defaultPoint.displayPoint();
        namedPoint.displayPoint();
        specificPoint.displayPoint();
    }

    private static void task5() {
        Point2D pointFirst = new Point2D("First", 3.0, 5.0);
        Point2D pointSecond = new Point2D("Second", 7.0, 8.0);
        Line line1and2 = new Line(pointFirst, pointSecond);

        System.out.println("Line first and second");
        System.out.println("Point First: " + line1and2.getPointA().getName());
        System.out.println("Point Second: " + line1and2.getPointB().getName());
        System.out.println("Length: " + line1and2.getLength());
        System.out.println("Angle with X axis: " + line1and2.calculateAngleWithXAxis());
    }
}