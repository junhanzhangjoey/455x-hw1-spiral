import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.Point;

/**
 SpiralComponent is a custom Swing component that visualizes a spiral.
 It takes a SpiralGenerator and number of segments, and draws each segment
 using Java 2D graphics (Graphics2D and Line2D) within the paintComponent method.
*/
public class SpiralComponent extends JComponent{
   private int unitLength;
   private int numOfSegment;
/**
 * create a SpiralComponent with a SpiralGenerator and number of segments need to be generated.
 * @param unitLength a unit length of the Spiral
 * @param numOfSegment number of segments to be generated
 */
   public SpiralComponent(int unitLength, int numOfSegment){
      this.unitLength = unitLength;
      this.numOfSegment=numOfSegment;
   }
/**
 * Overrides the paintComponent method to draw the spiral on this component.
 * Uses the SpiralGenerator to generate each line segment
 * using Graphics2D. Draws the number of segments specified by numOfSegment.
 * @param g graphic instance used for drawing
 */
   public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      int x = getWidth() / 2;
      int y = getHeight() / 2;
      SpiralGenerator sg = new SpiralGenerator(new Point(x,y), unitLength);
      
      for(int i = 0; i < this.numOfSegment; i++){
         Line2D line = sg.nextSegment();
         g2.draw(line);
      }
   }
}
