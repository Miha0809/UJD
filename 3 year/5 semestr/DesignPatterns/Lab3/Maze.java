import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

class Maze {
    private ArrayList<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomNo(int nr) {
        Iterator<Room> it = rooms.iterator();
        Room r;
        while (it.hasNext()) {
            r = it.next();
            if (r.getRoomNumber() == nr)
                return r;
        }
        return null;
    }

    public Image drawMaze(Image image) {
        Iterator<Room> it = rooms.iterator();
        Room r;
        
        while (it.hasNext()) {
            r = it.next();
            r.draw(image);
        }

        return image;
    }
};