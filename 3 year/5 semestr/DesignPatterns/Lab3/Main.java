import javax.swing.JFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Main extends JFrame {
    private MyJPanel panel;
    private Image image;
    private final int COUNT_ROOMS = 10;

    public Main() {
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button = new JButton("Draw maze");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 10;
                int y = 10;

                image = panel.getImage();
                buildMaze(100, 100);
                panel.repaint();
            }
        });
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(button, Directions.North.toString());
    }

    public void buildMaze(int x, int y) {
        Room[] rooms = new Room[COUNT_ROOMS];
        int nr = 1;
        for (int i = 0; i < COUNT_ROOMS; i++) {
            int currentX = x + i * MapSite.LENGTH;

            Wall eastWall = new Wall(currentX, y, Directions.East);
            Wall northWall = new Wall(currentX, y, Directions.North);
            Wall southWall = new Wall(currentX, y, Directions.South);
            Wall westWall = new Wall(currentX, y, Directions.West);

            rooms[i] = new Room(currentX, y, nr++);
            rooms[i].setSite(Directions.East, eastWall);
            rooms[i].setSite(Directions.North, northWall);
            rooms[i].setSite(Directions.South, southWall);
            rooms[i].setSite(Directions.West, westWall);

            // Заміна стіни дверима для сусідніх кімнат
            if (i > 0) {
                Door door = new Door(rooms[i - 1], rooms[i] /*, рандомний керунок */);
                
                // вибрати правильну протилежну дверку.
                switch (door.getDirection()) {
                    case Directions.East: {
                        rooms[i - 1].setSite(Directions.East, door);
                        rooms[i].setSite(Directions.West, door);
                    }
                    default:
                        break;
                }

                rooms[i - 1].setSite(Directions.East, door);
                rooms[i].setSite(Directions.West, door);
            }
        }

        for (Room room : rooms) {
            room.draw(image);
        }

        // Wall myWall11 = new Wall(x, y, Directions.East);
        // Wall myWall12 = new Wall(x, y, Directions.North);
        // Wall myWall13 = new Wall(x, y, Directions.South);
        // Wall myWall14 = new Wall(x, y, Directions.West);

        // Room room1 = new Room(x, y, nr++);
        // room1.setSite(Directions.East, myWall11);
        // room1.setSite(Directions.North, myWall12);
        // room1.setSite(Directions.South, myWall13);
        // room1.setSite(Directions.West, myWall14);

        // Wall myWall21 = new Wall(x + MapSite.LENGTH, y, Directions.East);
        // Wall myWall22 = new Wall(x + MapSite.LENGTH, y, Directions.North);
        // Wall myWall23 = new Wall(x + MapSite.LENGTH, y, Directions.South);
        // Wall myWall24 = new Wall(x + MapSite.LENGTH, y, Directions.West);

        // Room room2 = new Room(x + MapSite.LENGTH, y, nr++);
        // room2.setSite(Directions.East, myWall21);
        // room2.setSite(Directions.North, myWall22);
        // room2.setSite(Directions.South, myWall23);
        // room2.setSite(Directions.West, myWall24);

        // Room room3 = new Room(x + MapSite.LENGTH*2, y, nr++);
        // Wall myWall31 = new Wall(x + MapSite.LENGTH, y, Directions.East);
        // Wall myWall32 = new Wall(x + MapSite.LENGTH, y, Directions.North);
        // Wall myWall33 = new Wall(x + MapSite.LENGTH, y, Directions.South);
        // Wall myWall34 = new Wall(x + MapSite.LENGTH, y, Directions.West);
        // room3.setSite(Directions.East, myWall31);
        // room3.setSite(Directions.North, myWall32);
        // room3.setSite(Directions.South, myWall33);
        // room3.setSite(Directions.West, myWall34);

        // Door door1 = new Door(room1, room2);
        // Door door2 = new Door(room2, room3);

        // room1.setSite(Directions.East, door1);
        // room2.setSite(Directions.West, door1);
        // room2.setSite(Directions.East, door2);
        // room3.setSite(Directions.West, door2);

        // room1.draw(image);
        // room2.draw(image);
        // room3.draw(image);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
