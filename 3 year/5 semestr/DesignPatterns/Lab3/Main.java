import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame {
    private MyJPanel panel;
    private Image image;
    private final int COUNT_ROOMS = 10;
    private Room[] rooms = new Room[COUNT_ROOMS];
    private int selectedRoomIndex = -1;
    private Timer wallRemovalTimer;
    private List<Integer> visitedRooms = new ArrayList<>();

    public Main() {
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();

        JButton drawMazeButton = new JButton("Draw maze");
        JButton generateBomb = new JButton("generate bomb");
        generateBomb.setEnabled(false);

        drawMazeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        visitedRooms = new ArrayList();
                        image = panel.getImage();
                        panel.clear();
                        buildMaze(100, 100);
                        panel.repaint();
                        generateBomb.setEnabled(true);
                    }
                });

        generateBomb.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generateBomb();
                    }
                });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(drawMazeButton, BorderLayout.NORTH);
        buttonPanel.add(generateBomb, BorderLayout.SOUTH);

        add(buttonPanel, BorderLayout.NORTH);
    }

    private void generateBomb() {
        if (rooms.length == 0) {
            return;
        }

        Random random = new Random();

        do {
            selectedRoomIndex = random.nextInt(COUNT_ROOMS);
        } while (visitedRooms.contains(selectedRoomIndex) && visitedRooms.size() < COUNT_ROOMS);

        if (visitedRooms.size() >= COUNT_ROOMS) {
            System.out.println("Wszystkie pokoje zostały już odwiedzone");
            return;
        }

        panel.clear();

        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (room != null) {
                if (i == selectedRoomIndex) {
                    Graphics graphics = image.getGraphics();
                    graphics.setColor(Color.RED);
                    graphics.drawString(
                            "B" + room.getRoomNumber(),
                            room.getX() + MapSite.LENGTH / 4,
                            room.getY() + MapSite.LENGTH / 2);
                } else {
                    room.draw(image);
                }
            }
        }

        panel.repaint();

        if (wallRemovalTimer != null && wallRemovalTimer.isRunning()) {
            wallRemovalTimer.stop();
        }

        wallRemovalTimer = new Timer(
                300,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (selectedRoomIndex >= 0) {
                            Room selectedRoom = rooms[selectedRoomIndex];

                            if (!visitedRooms.contains(selectedRoomIndex)) {
                                for (Directions direction : Directions.values()) {
                                    if (selectedRoom.getSite(direction) instanceof Wall) {
                                        selectedRoom.setSite(direction, null);
                                    }
                                }
                                visitedRooms.add(selectedRoomIndex);
                            } else {
                                System.out.println(
                                        "Pokój został już odwiedzony: " + selectedRoom.getRoomNumber());
                            }

                            panel.clear();
                            for (Room room : rooms) {
                                if (room != null) {
                                    room.draw(image);
                                }
                            }
                            panel.repaint();
                        }
                    }
                });
        // wallRemovalTimer.setRepeats(false);
        wallRemovalTimer.start();
    }

    private Directions oppositeDirection(Directions direction) {
        switch (direction) {
            case East:
                return Directions.West;
            case West:
                return Directions.East;
            case North:
                return Directions.South;
            case South:
                return Directions.North;
        }

        throw new IllegalArgumentException("Unknown direction: " + direction);
    }

    private boolean isRoomOccupied(int x, int y, Room[] rooms, int count) {
        final int MIN_DISTANCE = 10;
        for (int i = 0; i < count; i++) {
            if (rooms[i] != null) {
                int roomX = rooms[i].getX();
                int roomY = rooms[i].getY();

                if (Math.abs(roomX - x) < MIN_DISTANCE && Math.abs(roomY - y) < MIN_DISTANCE) {
                    return true;
                }
            }
        }
        return false;
    }

    private void buildMaze(int x, int y) {
        int nr = 1;

        int width = panel.getWidth();
        int height = panel.getHeight();

        int currentX = x;
        int currentY = y;

        Directions[] directions = Directions.values();
        rooms[0] = new Room(currentX, currentY, nr++);

        for (int i = 1; i < COUNT_ROOMS; i++) {
            Directions chosenDirection;
            int nextX, nextY;

            do {
                chosenDirection = directions[new Random().nextInt(directions.length)];
                nextX = currentX;
                nextY = currentY;

                switch (chosenDirection) {
                    case East:
                        nextX += MapSite.LENGTH;
                        break;
                    case West:
                        nextX -= MapSite.LENGTH;
                        break;
                    case North:
                        nextY -= MapSite.LENGTH;
                        break;
                    case South:
                        nextY += MapSite.LENGTH;
                        break;
                }
            } while (isRoomOccupied(nextX, nextY, rooms, i)
                    || nextX < 10
                    || nextY < 10
                    || nextX > width - MapSite.LENGTH - 10
                    || nextY > height - MapSite.LENGTH - 10);

            Room newRoom = new Room(nextX, nextY, nr++);
            rooms[i] = newRoom;

            Door door = new Door(rooms[i - 1], newRoom);
            rooms[i - 1].setSite(chosenDirection, door);
            newRoom.setSite(oppositeDirection(chosenDirection), door);

            currentX = nextX;
            currentY = nextY;
        }

        for (Room room : rooms) {
            for (Directions direction : Directions.values()) {
                if (room.getSite(direction) == null) {
                    Wall wall = new Wall(room.getX(), room.getY(), direction);
                    room.setSite(direction, wall);
                }
            }
        }

        for (Room room : rooms) {
            room.draw(image);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        new Main().setVisible(true);
                    }
                });
    }
}
