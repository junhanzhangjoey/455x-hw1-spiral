// Name:
// USC NetID:
// CS 455 PA1
// Spring 2025


import java.awt.geom.Line2D;
import java.awt.Point;

/**
   class SpiralGenerator
   
   Generates a "rectangular" spiral, using Java display coordinate system, moving 
   outward from the center of the spiral in a counter-clockwise direction.
   That is, it will head rightward on screen, then, upward, then left, then down, etc.
  
   Length of initial line is unitLength.
   Padding between "layers" of the spiral is also unitLength.
   
   NOTE: we have provided the public interface for this class.  Do not change
   the public interface.  You can add private instance variables, constants, 
   and private methods to the class.  You will also be completing the 
   implementation of the methods given. 
   
 */
public class SpiralGenerator {
   private Point startPosition;
   private int nextLength;
   private int step;
   private int direction;
   private int unitLength;


   /**
      Creates a SpiralGenerator starting at startPosition, with length of first segnment and 
      distance between "layers" both given as unitLength.  Both values are assuming the Java 
      graphics coordinate system.
      @param startPosition starting point of the first segment in the spiral
      @param unitLength in pixels, must be > 0
   */
   public SpiralGenerator(Point startPosition, int unitLength) {
      this.startPosition=startPosition;
      this.nextLength=unitLength;
      this.direction=0;
      this.step=0;
      this.unitLength=unitLength;
   }

   /**
      Return the coordinates of the next line segment in the spiral.
      
    */
   public Line2D nextSegment() {
      int dx=0;
      int dy=0;
      Point endPoint;
      if(direction==0){
         dx=nextLength;
	 direction=1;
      }else if(direction==1){
         dy=-nextLength;
	 direction=2;
      }else if(direction==2){
         dx=-nextLength;
	 direction=3;
      }else{
         dy=nextLength;
	 direction=0;
      }
      endPoint = new Point(this.startPosition.x + dx,this.startPosition.y + dy);
      Line2D res = new Line2D.Double(this.startPosition, endPoint);
      startPosition=endPoint;
      if(step == 1){
         this.nextLength+=this.unitLength;
	 step=0;
      }else{
         step=1;  
      }
      return res;

   }

   //public static void main(String[] args){
     // SpiralGenerator sg =new SpiralGenerator(new Point(0,0),10);
      //for(int i=0;i<10;i++){
         //Line2D line=sg.nextSegment();
	 //System.out.println(line.getX1()+" "+line.getY1()+" "+line.getX2()+" "+line.getY2());
      //}
   //}
}

