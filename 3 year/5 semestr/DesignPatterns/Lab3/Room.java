import java.awt.Image;
import java.awt.Graphics;

public class Room extends MapSite {
    private int number;
    private MapSite[] sites = new MapSite[4];

    public Room(int x, int y, int number) {
        super(x, y);
        this.number = number;
    }

    public void setSite(Directions direction, MapSite mapSite) {
        switch (direction) {
            case North, West:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX());
                    mapSite.setY(getY());
                }
                if (direction == direction.North)
                    sites[0] = mapSite;
                else
                    sites[3] = mapSite;
                break;
            case South:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX());
                    mapSite.setY(getY() + LENGTH);
                }
                sites[2] = mapSite;
                break;

            case East:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX() + LENGTH);
                    mapSite.setY(getY());
                }
                break;
            default:
                break;
        }
        sites[direction.ordinal()] = mapSite;
    }

    @Override
    public void draw(Image image) {
        for (MapSite mapSite : sites) {
            if (mapSite != null) {
                mapSite.draw(image);
            }
        }
        Graphics graphics = image.getGraphics();
        graphics.drawString("" + number, getX() + MapSite.LENGTH / 4, getY() + MapSite.LENGTH / 2);

    }

    public int getRoomNumber() {
        return number;
    }

    public MapSite getSite(Directions direction) {
        return sites[direction.ordinal()];
    }
}
