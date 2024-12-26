import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

public class Main extends JFrame {
    private MyJPanel panel;
    private Image image;
    private final int COUNT_ROOMS = 10;
    private Room[] rooms = new Room[COUNT_ROOMS];
    private int selectedRoomIndex = -1;
    private Timer wallRemovalTimer;
    
    public Main() {
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();

        JButton drawMazeButton = new JButton("Draw maze");
        JButton randomRoom = new JButton("Random room");
        randomRoom.setEnabled(false);

        drawMazeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image = panel.getImage();
                panel.clear();
                buildMaze(100, 100);
                panel.repaint();
                randomRoom.setEnabled(true);
            }
        });

        randomRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomRoom();
            }
        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(drawMazeButton, BorderLayout.NORTH);
        buttonPanel.add(randomRoom, BorderLayout.SOUTH);

        add(buttonPanel, BorderLayout.NORTH);
    }

    private void randomRoom() {
        if (rooms.length == 0) {
            return;
        }

        Random random = new Random();
        selectedRoomIndex = random.nextInt(COUNT_ROOMS);

        panel.clear();

        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (room != null) {
                if (i == selectedRoomIndex) {
                    Graphics graphics = image.getGraphics();
                    graphics.setColor(Color.RED);
                    graphics.drawString(room.getRoomNumber() + "B",
                            room.getX() + MapSite.LENGTH / 4,
                            room.getY() + MapSite.LENGTH / 2);
                } else {
                    room.draw(image);
                }
            }
        }
        
        panel.repaint();
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
            } while (isRoomOccupied(nextX, nextY, rooms, i) ||
                    nextX < 10 ||
                    nextY < 10 ||
                    nextX > width - MapSite.LENGTH - 10 ||
                    nextY > height - MapSite.LENGTH - 10);

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
