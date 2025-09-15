import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;

/**
 SpiralComponent is a custom Swing component that visualizes a spiral.
 It takes a SpiralGenerator and number of segments, and draws each segment
 using Java 2D graphics (Graphics2D and Line2D) within the paintComponent method.
*/
public class SpiralComponent extends JComponent{
   private SpiralGenerator sg;
   private int numOfSegment;
/**
 * create a SpiralComponent with a SpiralGenerator and number of segments need to be generated.
 * @param sg a SpiralGenerator instance
 * @param numOfSegment number of segments to be generated
 */
   public SpiralComponent(SpiralGenerator sg, int numOfSegment){
      this.sg=sg;
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
      
      for(int i = 0; i<this.numOfSegment; i++){
         Line2D line = sg.nextSegment();
         g2.draw(line);
      }
   }
}
