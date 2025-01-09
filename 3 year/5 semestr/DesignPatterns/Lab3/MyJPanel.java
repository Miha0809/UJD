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
        Graphics graphics = getImage().getGraphics();
        graphics.clearRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            image = createImage(getWidth(), getHeight());
        } else {
            graphics.drawImage(image, 0, 0, this);
        }
    }
}
