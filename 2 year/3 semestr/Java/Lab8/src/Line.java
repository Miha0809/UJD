public class Line {
    private Point2D pointA;
    private Point2D pointB;
    private double length;

    public Line(Point2D pointA, Point2D pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.length = calculateLength();
    }

    private double calculateLength() {
        double deltaX = pointB.getX() - pointA.getX();
        double deltaY = pointB.getY() - pointA.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double getLength() {
        return length;
    }

    public Point2D getPointA() {
        return pointA;
    }

    public Point2D getPointB() {
        return pointB;
    }

    public double calculateAngleWithXAxis() {
        double deltaX = pointB.getX() - pointA.getX();
        double deltaY = pointB.getY() - pointA.getY();
        double angleRad = Math.atan2(deltaY, deltaX);
        double angleDegrees = Math.toDegrees(angleRad);

        if (angleDegrees < 0) {
            angleDegrees += 360;
        }

        return angleDegrees;
    }
}




