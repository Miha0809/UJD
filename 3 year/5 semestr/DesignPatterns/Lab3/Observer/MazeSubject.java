import java.util.ArrayList;
import java.util.List;

public class MazeSubject extends Subject {
    private final List<Room> rooms = new ArrayList<>();
    private int selectedRoomIndex = -1;

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getSelectedRoomIndex() {
        return selectedRoomIndex;
    }

    public void setSelectedRoomIndex(int selectedRoomIndex) {
        this.selectedRoomIndex = selectedRoomIndex;
    }
}
