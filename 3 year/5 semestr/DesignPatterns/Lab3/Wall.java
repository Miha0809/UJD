import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Wall extends MapSite {
	private Directions direction;

	public Wall(int x, int y, Directions d) {
		super(x, y);
		direction = d;
	}

	public Wall(Directions d) {
		super(-1, -1);
		direction = d;
	}

	public Directions getDirection() {
		return direction;
	}

	@Override
	public void draw(Image image) {
		Graphics g = image.getGraphics();
		int x = getX();
		int y = getY();
		g.setColor(Color.black);
		switch (direction) {
			case North, South:
				g.drawLine(x, y, x + MapSite.LENGTH, y);
				break;
			default:
				g.drawLine(x, y, x, y + MapSite.LENGTH);
				break;
		}
	}
}
