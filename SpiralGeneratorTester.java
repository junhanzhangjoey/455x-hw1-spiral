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
//    public static boolean isPerpendicular(Line2D seg1, Line2D seg2){
//       double dx1 = seg1.getX2() - seg1.getX1();
//       double dy1 = seg1.getY2() - seg1.getY1();

//       double dx2 = seg2.getX2() - seg2.getX1();
//       double dy2 = seg2.getY2() - seg2.getY1();

//       return dx1 * dx2 + dy1 * dy2 < 1e-6;
//     }

//    /**
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
//       System.out.println("With a unit length of " + unitLength + ", and made up of " + numOfSegment + " segments");
//       Line2D prevLine = null;
//       Line2D line = null;
//       int count = 1;
//       for(int i=0;i<numOfSegment;i++){
//          line = sg.nextSegment();
//          double x1 = line.getX1();
//          double y1 = line.getY1();
//          double x2 = line.getX2();
//          double y2 = line.getY2();

//          System.out.println("Segment #"+ count +": Point2D.Double[" + x1 + ", " + y1 + "] Point2D.Double[" + x2 + ", " + y2 + "]");
//          if(prevLine != null && isConnected(prevLine, line)){
//             if(step == 0 && !isHorizontal(line)){
//                System.out.println("FAILED: segment is not horizontal, Skipping pair tests");
//             }else if(step == 1 && !isVertical(line)){
//                System.out.println("FAILED: segment is not vertical, Skipping pair tests");
//             }else {
//                if((step==0 && !lengthHorizontal(line,currLength)) || (step==1&&!lengthVertical(line, currLength))){
//                   System.out.println("FAILED: segment length is incorrect");
//                }
//                if(!isConnected(prevLine, line)){
//                   System.out.println("FAILED: last two segments are not connected");
//                }
//                if(!isPerpendicular(prevLine,line)){
//                   System.out.println("FAILED: last two segments are not perpendicular");
//                }
//             }
//            }
//          if(step == 1){
//             currLength += unitLength;
//          }
//          step = 1-step;
//          count++;
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

// Name: Chunho Lin
// USC NetID: 3226964170
// CS 455 PA1
// Fall 2025

import java.awt.Point;
import java.awt.geom.Line2D;

/**
 * A comprehensive tester class for the SpiralGenerator class.
 * This program generates multiple spirals with different parameters and
 * validates
 * that each generated segment meets the requirements:
 * - Each segment is either horizontal or vertical
 * - Consecutive segments are properly connected (end of one = start of next)
 * - Consecutive segments are perpendicular to each other
 * 
 * To run this tester:
 * 1. Compile: javac SpiralGeneratorTester.java
 * 2. Run: java SpiralGeneratorTester
 * 
 * The program will automatically test several spiral configurations and report
 * any failures in the console output.
 */
public class SpiralGeneratorTester {

   /**
    * Main method that runs multiple test cases for the SpiralGenerator.
    * Tests spirals with different starting positions, unit lengths, and segment
    * counts
    * to ensure the generator works correctly across various configurations.
    * 
    * @param args command line arguments (not used)
    */
   public static void main(String[] args) {
      testSpiral(new Point(200, 300), 5, 10);
      testSpiral(new Point(0, 0), 3, 8);
      testSpiral(new Point(50, 50), 1, 6);
   }

   /**
    * Tests the SpiralGenerator by generating a spiral and printing segment
    * details.
    * It checks that each segment is either horizontal or vertical, that
    * consecutive
    * segments are connected, and that they are perpendicular to each other.
    * 
    * @param start       the starting point of the spiral
    * @param unitLength  the length of the first segment
    * @param numSegments the total number of segments to generate
    */
   private static void testSpiral(Point start, int unitLength, int numSegments) {
      System.out.println("Making a spiral starting from " + start);
      System.out.println("with a unit length of " + unitLength + ", and made up of " + numSegments + " segments:");

      SpiralGenerator spiral = new SpiralGenerator(start, unitLength);
      Line2D prevSegment = null;

      for (int i = 1; i <= numSegments; i++) {
         Line2D seg = spiral.nextSegment();

         System.out.printf(
               "Segment #%d: Point2D.Double[%.1f, %.1f] Point2D.Double[%.1f, %.1f]%n",
               i, seg.getX1(), seg.getY1(), seg.getX2(), seg.getY2());

         boolean isHorizontal = seg.getY1() == seg.getY2();
         boolean isVertical = seg.getX1() == seg.getX2();

         if (!isHorizontal && !isVertical) {
            System.out.println("FAILED: segment is not horizontal or vertical. Skipping pair tests.");
         } else if (prevSegment != null) {
            boolean connected = (prevSegment.getX2() == seg.getX1() && prevSegment.getY2() == seg.getY1());
            if (!connected) {
               System.out.println("FAILED: last two segments are not connected");
            }

            boolean prevHorizontal = prevSegment.getY1() == prevSegment.getY2();
            boolean prevVertical = prevSegment.getX1() == prevSegment.getX2();
            boolean perpendicular = (prevHorizontal && isVertical) || (prevVertical && isHorizontal);
            if (!perpendicular) {
               System.out.println("FAILED: last two segments are not perpendicular");
            }
         }

         prevSegment = seg;
      }

      System.out.println();
   }
}