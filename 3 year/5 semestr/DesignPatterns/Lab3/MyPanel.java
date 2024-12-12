import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class MyPanel extends JPanel {
    private Image image;

    public MyPanel() {
        super();
    }
    
    public Image getImage() {
        return image;
    }

    @Override
    public void paint(Graphics g) {
        if (image == null) {
            image = createImage(getWidth(), getHeight());
        }
        else {
            g.drawImage(image, 0, 0, this);
        }
    }
}