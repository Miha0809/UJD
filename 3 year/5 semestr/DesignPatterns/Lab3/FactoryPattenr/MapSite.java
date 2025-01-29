import java.awt.Image;

public abstract class MapSite {
    public static final int LENGTH = 50;

    private int x, y;

    public MapSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void draw(Image image) {
    }
}