import java.awt.Image;

public class Director {
    private Maze aMaze;
    private int x;
    private int y;

    public Maze createMaze(int x, int y, Image image) {
        if (aMaze == null)
        {
            aMaze = new Maze();
        }

        int nr = 1;
        Room r1 = new Room(x, y, nr++);
        Room r2 = new Room(x + MapSite.LENGTH, y, nr++);
        Door theDoor = new Door(r1, r2);

        r1.setSite(Directions.North, new Wall(Directions.North));
        r1.setSite(Directions.North, new Wall(Directions.North));

        return aMaze;
    }

    public Maze createMaze(ConcreteMazeBuild builder) {
        if (aMaze == null) {
            aMaze = new Maze();
        }

        
    }
}
