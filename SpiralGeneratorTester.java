// import java.awt.geom.Line2D;
// import java.awt.Point;

// /**
//  * This class tests whether the SpiralGenerator generates correct spiral lines by:
//  * - Checking the length of each segment
//  * - Determining whether the segment is vertical or horizontal
//  * - Verifying if the segment is connected and perpendicular to the previous segment
//  */
// public class SpiralGeneratorTester{
//    /**
//     check if a segment vertical or not
//     @param seg a Line2D instance
//     @return true if it is vertical, false if it is not
//     */
//    public static boolean isVertical(Line2D seg){
//       return seg.getX1()==seg.getX2();
//    }

//    /**
//     check if a vertical segment's length correct or not
//     @param seg    a Line2D instance to be checked
//     @param length the expected length to verify against seg's actual length
//     @return true if length is correct, false if it is not
//    */
//    public static boolean lengthVertical(Line2D seg, double length){
//      return Math.abs(seg.getY1() - seg.getY2()) == length;
//    }

//    /**
//     check if a segment horizontal or not
//     @param seg a Line2D instance
//     @return true if it is horizontal, false if it is not
//     */
//    public static boolean isHorizontal(Line2D seg){
//       return seg.getY1()==seg.getY2();
//    }

//    /**
//     check if a horizontal segment's length correct or not
//     @param seg    a Line2D instance to be checked
//     @param length the expected length to verify against seg's actual length
//     @return true if length is correct, false if it is not
//    */
//    public static boolean lengthHorizontal(Line2D seg, double length){
//      return Math.abs(seg.getX1() - seg.getX2()) == length;
//    }

//    /**
//     * test whether two segments are connected each other or not.
//     * @param seg1 first segment to be tested
//     * @param seg2 second segment to be tested
//     * @return true if seg1 and seg2 are connected, false otherwise
//     */
//    public static boolean isConnected(Line2D seg1, Line2D seg2){
//       double x11 = seg1.getX1();
//       double y11 = seg1.getY1();
//       double x12 = seg1.getX2();
//       double y12 = seg1.getY2();

//       double x21 = seg2.getX1();
//       double y21 = seg2.getY1();
//       double x22 = seg2.getX2();
//       double y22 = seg2.getY2();
//       return (x11==x21&&y11==y21)||(x11==x22&&y11==y22)||(x12==x21&&y12==y21)||(x12==x22&&y12==y22);

//     }
//    /**
//     * test whether two segments are perpendicular each other or not.
//     * @param seg1 first segment to be tested
//     * @param seg2 second segment to be tested
//     * @return true if seg1 and seg2 are perpendicular, false otherwise
//     */

// /**
//  * Tests whether a SpiralGenerator produces the correct spiral.
//  * 
//  * This method generates the specified number of segments from the given SpiralGenerator instance,
//  * prints the coordinates of each segment, and checks whether each segment:
//  * 
//  *-has the correct orientation (horizontal or vertical),</li>
//  *-has the correct length,</li>
//  *-is connected to the previous segment, and</li>
//  *-is perpendicular to the previous segment.</li>
//  *
//  * Any failures are printed to the console.
//  *
//  * @param sg the SpiralGenerator instance to be tested
//  * @param numOfSegment the number of segments to generate and test
//  */

//    public static void tester(SpiralGenerator sg, int numOfSegment ){
//       int step=0;
//       int unitLength=sg.getUnitLength();
//       int currLength = unitLength;
//       int startX = sg.getStartX();
//       int startY = sg.getStartY();
//       System.out.println("Making a spiral starting from java.awt.Point[x="+startX+",y="+startY+"]");
//       System.out.println("with a unit length of " + unitLength + ", and made up of " + numOfSegment + " segments");
//       Line2D prevLine = null;
//       Line2D line = null;
//       int count = 1;
//       for(int i=0;i<numOfSegment;i++){
//          line = sg.nextSegment();
//          double x1 = line.getX1();
//          double y1 = line.getY1();
//          double x2 = line.getX2();
//          double y2 = line.getY2();
         
//          boolean isHorizontal=isHorizontal(line);
//          boolean isVertical=isVertical(line);

//          System.out.println("Segment #"+ count +": Point2D.Double[" + x1 + ", " + y1 + "] Point2D.Double[" + x2 + ", " + y2 + "]");
//          if(prevLine != null && isConnected(prevLine, line)){
//             if(step == 0 && !isHorizontal){
//                System.out.println("FAILED: segment is not horizontal, Skipping pair tests");
//             }else if(step == 1 && !isVertical){
//                System.out.println("FAILED: segment is not vertical, Skipping pair tests");
//             }else {
//                if((step==0 && !lengthHorizontal(line,currLength)) || (step==1&&!lengthVertical(line, currLength))){
//                   System.out.println("FAILED: segment length is incorrect");
//                }
//                if(!isConnected(prevLine, line)){
//                   System.out.println("FAILED: last two segments are not connected");
//                }
//                boolean prevHorizontal = isHorizontal(prevLine);
//                boolean prevVertical = isVertical(prevLine);

//                if(!(isHorizontal && prevVertical)&&!(isVertical && prevHorizontal)){
//                   System.out.println("FAILED: last two segments are not perpendicular");
//                }
//             }
//            }
//          if(step == 1){
//             currLength += unitLength;
//          }
//          step = 1-step;
//          count++;
//          prevLine=line;
//       }
//    }

//    public static void main(String[] args){
//       int startx=200;
//       int starty=200;
//       int unitLength=10;
//       SpiralGenerator sg = new SpiralGenerator(new Point(startx,starty),unitLength);
//       int numOfSegment = 100;
//       tester(sg, numOfSegment);   
//    }
// }

import java.awt.geom.Line2D;
import java.awt.Point;

/**
 * This class tests whether the SpiralGenerator generates correct spiral lines by:
 * - Checking the length of each segment
 * - Determining whether the segment is vertical or horizontal
 * - Verifying if the segment is connected and perpendicular to the previous segment
 */
public class SpiralGeneratorTester {

   /** Check if a segment is vertical */
   public static boolean isVertical(Line2D seg) {
      return seg.getX1() == seg.getX2();
   }

   /** Check if a vertical segment has the expected length */
   public static boolean lengthVertical(Line2D seg, double length) {
      return Math.abs(seg.getY1() - seg.getY2()) == length;
   }

   /** Check if a segment is horizontal */
   public static boolean isHorizontal(Line2D seg) {
      return seg.getY1() == seg.getY2();
   }

   /** Check if a horizontal segment has the expected length */
   public static boolean lengthHorizontal(Line2D seg, double length) {
      return Math.abs(seg.getX1() - seg.getX2()) == length;
   }

   /** Check whether two segments are connected */
   public static boolean isConnected(Line2D seg1, Line2D seg2) {
      double x11 = seg1.getX1();
      double y11 = seg1.getY1();
      double x12 = seg1.getX2();
      double y12 = seg1.getY2();

      double x21 = seg2.getX1();
      double y21 = seg2.getY1();
      double x22 = seg2.getX2();
      double y22 = seg2.getY2();

      return (x11 == x21 && y11 == y21) ||
             (x11 == x22 && y11 == y22) ||
             (x12 == x21 && y12 == y21) ||
             (x12 == x22 && y12 == y22);
   }

   /**
    * Test whether a SpiralGenerator produces the correct spiral.
    * 
    * This method generates the specified number of segments from the given SpiralGenerator instance,
    * prints the coordinates of each segment, and checks:
    * - Correct orientation (horizontal/vertical)
    * - Correct length
    * - Connected to the previous segment
    * - Perpendicular to the previous segment
    *
    * Any failures are printed to the console.
    */
   public static void tester(SpiralGenerator sg, int numOfSegment) {
      int step = 0; // 0 = horizontal, 1 = vertical
      int unitLength = sg.getUnitLength();
      int currLength = unitLength;
      int startX = sg.getStartX();
      int startY = sg.getStartY();

      System.out.println("Making a spiral starting from java.awt.Point[x=" + startX + ",y=" + startY + "]");
      System.out.println("with a unit length of " + unitLength + ", and made up of " + numOfSegment + " segments");

      Line2D prevLine = null;

      for (int i = 0; i < numOfSegment; i++) {
         Line2D line = sg.nextSegment();
         double x1 = line.getX1();
         double y1 = line.getY1();
         double x2 = line.getX2();
         double y2 = line.getY2();

         boolean horizontal = isHorizontal(line);
         boolean vertical = isVertical(line);

         System.out.println("Segment #" + (i + 1) + ": Point2D.Double[" + x1 + ", " + y1 + "] Point2D.Double[" + x2 + ", " + y2 + "]");

         if (prevLine != null) {
            // 1. Check orientation
            if (step == 0 && !horizontal) {
               System.out.println("FAILED: segment is not horizontal");
            } else if (step == 1 && !vertical) {
               System.out.println("FAILED: segment is not vertical");
            }

            // 2. Check length
            if ((step == 0 && !lengthHorizontal(line, currLength)) ||
                (step == 1 && !lengthVertical(line, currLength))) {
               System.out.println("FAILED: segment length is incorrect");
            }

            // 3. Check connection
            if (!isConnected(prevLine, line)) {
               System.out.println("FAILED: last two segments are not connected");
            }

            // 4. Check perpendicularity
            boolean prevHorizontal = isHorizontal(prevLine);
            boolean prevVertical = isVertical(prevLine);
            boolean perpendicular = (horizontal && prevVertical) || (vertical && prevHorizontal);

            if (!perpendicular) {
               System.out.println("FAILED: last two segments are not perpendicular");
            }
         }

         // Update state
         if (step == 1) {
            currLength += unitLength;
         }
         step = 1 - step; // alternate between 0 and 1
         prevLine = line;
      }
   }

   public static void main(String[] args) {
      int startx = 200;
      int starty = 200;
      int unitLength = 10;
      SpiralGenerator sg = new SpiralGenerator(new Point(startx, starty), unitLength);
      int numOfSegment = 20;
      tester(sg, numOfSegment);
   }
}
