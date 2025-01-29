public class MazeGame {
    public Maze makeMaze() {
        return new Maze();
    }

    public Room makeRoom(int x, int y, int number) {
        return new Room(x, y, number);
    }

    public Wall makeWall(int x, int y, Directions direction) {
        return new Wall(x, y, direction);
    }

    public Door makeDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }
}