import java.awt.Image;
import java.util.ArrayList;

class Maze {
    private ArrayList<Room> rooms = new ArrayList<>();

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

    public Image drawMaze(Image image) {
        for (Room room : rooms) {
            room.draw(image);
        }
        return image;
    }
};