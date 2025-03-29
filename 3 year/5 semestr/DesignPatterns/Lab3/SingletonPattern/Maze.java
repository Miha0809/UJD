import java.awt.Image;
import java.util.ArrayList;

class Maze {
    private static Maze instance;
    private ArrayList<Room> rooms = new ArrayList<>();

    private Maze() {}

    public static Maze getInstance() {
        if (instance == null) {
            instance = new Maze();
        }
        return instance;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void resetMaze() {
        rooms.clear();
    }

    public Image drawMaze(Image image) {
        for (Room room : rooms) {
            room.draw(image);
        }
        return image;
    }
}
