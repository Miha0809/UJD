import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class App extends JFrame {
    private MyJPanel panel;
    private Image image;

    public App() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button = new JButton("Draw naze");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final int x = 50;
                final int y = 100;
                buildMaze();
                // image = drawPanel.getImage();
                Director director = new Director();
                Maze aMaze = director.createMaze(x, y, image);
                aMaze.drawMaze(image);
                // panel.repaint();

                // ConcreteMazeBuild builder = new ConcreteMazeBuild();
                // Maze aMaze2 = director.createMaze(builde);
                // aMaze2.drawMaze(image);
                
                panel.repaint();
            }
        });
    }
}