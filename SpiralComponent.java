import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import java.awt.Point;
public class SpiralComponent extends JComponent{
   private SpiralGenerator sg;
   private int numOfSegment;

   public SpiralComponent(SpiralGenerator sg, int numOfSegment){
      this.sg=sg;
      this.numOfSegment=numOfSegment;
   }

   public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      
      for(int i = 0; i<this.numOfSegment; i++){
         Line2D line = sg.nextSegment();
         g2.draw(line);
      }
   }
   //public static void main(String[] args){
     // JFrame frame = new JFrame();
      //frame.setSize(400,400);
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //SpiralGenerator sg = new SpiralGenerator(new Point(200,200),10);
      //SpiralComponent sc = new SpiralComponent(sg,30);
      //frame.add(sc);
      //frame.setVisible(true);
   //}
}
