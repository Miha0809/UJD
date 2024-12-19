import java.awt.Image;
import java.awt.Graphics;

public class Room extends MapSite {
    private int nr;
    private MapSite[] sites = new MapSite[4];

    public Room(int x, int y, int nr) {
        super(x, y);
        this.nr = nr;
    }

    public void setSite(Directions d, MapSite mapSite) {
        switch (d) {
            case North, West:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX());
                    mapSite.setY(getY());
                }
                if (d == d.North)
                    sites[0] = mapSite;
                else
                    sites[3] = mapSite;
                break;
            case South:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX());
                    mapSite.setY(getY() + LENGTH);
                    // sites[2] = mapSite;
                }
                break;
            case East:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX() + LENGTH);
                    mapSite.setY(getY());
                    // sites[1] = mapSite;

                }
                break;
            default: // West
                break;
        }
        sites[d.ordinal()] = mapSite;
    }

    @Override
    public void draw(Image image) {
        for (MapSite mapSite : sites)
            if (mapSite != null)
                mapSite.draw(image);
        Graphics g = image.getGraphics();
        g.drawString("" + nr, getX() + MapSite.LENGTH / 4, getY() + MapSite.LENGTH / 2);

    }

    public int getRoomNumber() {
        return nr;
    }
}
