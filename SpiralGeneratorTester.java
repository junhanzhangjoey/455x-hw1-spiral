import java.awt.geom.Line2D;
import java.awt.Point;


public class SpiralGeneratorTester{
    public static boolean isVertical(Line2D seg, double length){
        return seg.getX1()==seg.getX2() && Math.abs(seg.getY1() - seg.getY2()) == length;
    }

    public static boolean isHorizontal(Line2D seg, double length){
        return seg.getY1()==seg.getY2() && Math.abs(seg.getX1() - seg.getX2()) == length;
    }

    public static boolean isConnected(Line2D seg1, Line2D seg2){
        double x11 = seg1.getX1();
        double y11 = seg1.getY1();
        double x12 = seg1.getX2();
        double y12 = seg1.getY2();

        double x21 = seg2.getX1();
        double y21 = seg2.getY1();
        double x22 = seg2.getX2();
        double y22 = seg2.getY2();
        return (x11==x21&&y11==y21)||(x11==x22&&y11==y22)||(x12==x21&&y12==y21)||(x12==x22&&y12==y22);

    }

    public static boolean isPerpendicular(Line2D seg1, Line2D seg2){
       double dx1 = seg1.getX2() - seg1.getX1();
       double dy1 = seg1.getY2() - seg1.getY1();

       double dx2 = seg2.getX2() - seg2.getX1();
       double dy2 = seg2.getY2() - seg2.getY1();

       return dx1 * dx2 + dy1 * dy2 == 0;
    }

    public static void main(String[] args){
        int startx=0;
        int starty=0;
        int unitLength=1;
        SpiralGenerator sg = new SpiralGenerator(new Point(startx,starty),unitLength);
        int numOfSegment = 10;
        int step=0;
        int currLength=unitLength;
        System.out.println("Making a spiral starting from java.awt.Point[x="+startx+"],y="+starty+"]");
        System.out.println("With a unit length of " + unitLength + ", and made up of " + numOfSegment + " segments");
        Line2D prevLine = null;
	Line2D line = null;
	int count = 1;
        for(int i=0;i<numOfSegment;i++){
           line = sg.nextSegment();
           double x1 = line.getX1();
      	   double y1 = line.getY1();
           double x2 = line.getX2();
           double y2 = line.getY2();
	   	   
           System.out.println("Segment #"+ count +": Point2D.Double[" + x1 + ", " + y1 + "] Point2D.Double[" + x2 + ", " + y2 + "]");
	   if(prevLine != null && isConnected(prevLine, line)){
	      if(step == 0 && !isHorizontal(line, currLength)){
		      System.out.println("FAILED: segment is not horizontal, Skipping pair tests");
	      }else if(step == 1 && !isVertical(line,currLength)){
	         System.out.println("FAILED: segment is not vertical, Skipping pair tests");
	      }else {
	         if(!isConnected(prevLine, line)){
                    System.out.println("FAILED: last two segments are not connected");
                 }
		 if(!isPerpendicular(prevLine,line)){
		    System.out.println("FAILED: last two segments are not perpendicular");
		 }
	      }
	   }

	   if(step == 1){
	      currLength += unitLength;
	   }
	   step = 1-step;
	   count++;
        }
    }
}
