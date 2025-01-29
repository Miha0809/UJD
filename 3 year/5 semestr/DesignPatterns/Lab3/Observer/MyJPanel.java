import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class MyJPanel extends JPanel implements Observer {
    private Image image;
    private MazeSubject mazeSubject;

    public MyJPanel() {
        super();
    }

    public Image getImage() {
        if (image == null) {
            image = createImage(getWidth(), getHeight());
        }
        return image;
    }

    public void clear() {
        if (image != null) {
            Graphics graphics = image.getGraphics();
            graphics.clearRect(0, 0, getWidth(), getHeight());
        }
    }    

    @Override
    public void update() {
        if (mazeSubject != null) {
            clear();
            Graphics g = getImage().getGraphics();

            for (Room room : mazeSubject.getRooms()) {
                room.draw(image);
            }

            int selectedIndex = mazeSubject.getSelectedRoomIndex();
            if (selectedIndex >= 0) {
                Room selectedRoom = mazeSubject.getRooms().get(selectedIndex);
                g.setColor(Color.RED);
                g.drawString(
                        "B" + selectedRoom.getRoomNumber(),
                        selectedRoom.getX() + MapSite.LENGTH / 4,
                        selectedRoom.getY() + MapSite.LENGTH / 2);
            }

            repaint();
        }
    }

    public void setMazeSubject(MazeSubject mazeSubject) {
        this.mazeSubject = mazeSubject;
    }

    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            image = createImage(getWidth(), getHeight());
        }
        graphics.drawImage(image, 0, 0, this);
    }
}
