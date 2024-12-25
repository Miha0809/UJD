import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Door extends MapSite {
   private Room room1;
   private Room room2;
   private Directions direction;

   public Door(Room room1, Room room2) {
      super(-1, -1);
      this.room1 = room1;
      this.room2 = room2;
   }

   public Door(Room room1, Room room2, Directions direction) {
      super(-1, -1);
      this.room1 = room1;
      this.room2 = room2;
      this.direction = direction;
   }

   public Directions getDirection() {
      return this.direction;
   }

   @Override
   public void draw(Image image) {
      int x1 = room1.getX();
      int y1 = room1.getY();
      int x2 = room2.getX();
      int y2 = room2.getY();
      int x;
      int y;
      Graphics g = image.getGraphics();
      g.setColor(Color.black);
      if (x1 == x2) { // pokoje leżą w pionie, ściana z drzwiami jest pozioma
         y = (y1 > y2) ? y1 : y2;
         g.drawLine(x1, y, x1 + MapSite.LENGTH / 3, y);
         g.drawLine(x1 + 2 * MapSite.LENGTH / 3, y, x1 + MapSite.LENGTH, y);

      } else { // pokoje leżą w poziomie, ściana z drzwiami jest pionowa
         x = (x1 > x2) ? x1 : x2;
         g.drawLine(x, y1, x, y1 + MapSite.LENGTH / 3);
         g.drawLine(x, y1 + 2 * MapSite.LENGTH / 3, x, y1 + MapSite.LENGTH);
      }
   }
}
