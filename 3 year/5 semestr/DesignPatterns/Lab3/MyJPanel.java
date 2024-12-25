import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class MyJPanel extends JPanel {
    private Image image;

    public MyJPanel() {
        super();
    }

    public Image getImage() {
        return image;
    }

    public void clear() {
        Graphics g = getImage().getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void paint(Graphics g) {
        if (image == null) {
            image = createImage(getWidth(), getHeight());
        } else {
            g.drawImage(image, 0, 0, this);
        }
    }
}
