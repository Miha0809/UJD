public interface MazeBuilder {
    void buildMaze();
    void buildRoom(int room, int x, int y);
    void buildDoor(int roomFrom, int roomTo);
    Maze getMaze();
}