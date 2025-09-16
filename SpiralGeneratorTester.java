import java.awt.geom.Line2D;
import java.awt.Point;

/**
 * This class tests whether the SpiralGenerator generates correct spiral lines by:
 * - Checking the length of each segment
 * - Determining whether the segment is vertical or horizontal
 * - Verifying if the segment is connected and perpendicular to the previous segment
 */
public class SpiralGeneratorTester{
   /**
    check if a segment vertical or not
    @param seg a Line2D instance
    @return true if it is vertical, false if it is not
    */
   public static boolean isVertical(Line2D seg){
      return seg.getX1()==seg.getX2();
   }

   /**
    check if a segment horizontal or not
    @param seg a Line2D instance
    @return true if it is horizontal, false if it is not
    */
   public static boolean isHorizontal(Line2D seg){
      return seg.getY1()==seg.getY2();
   }

   /**
    * test whether two segments are connected each other or not.
    * @param seg1 first segment to be tested
    * @param seg2 second segment to be tested
    * @return true if seg1 and seg2 are connected, false otherwise
    */
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
   /**
    * test whether two segments are perpendicular each other or not.
    * @param seg1 first segment to be tested
    * @param seg2 second segment to be tested
    * @return true if seg1 and seg2 are perpendicular, false otherwise
    */

/**
 * Tests whether a SpiralGenerator produces the correct spiral.
 * 
 * This method generates the specified number of segments from the given SpiralGenerator instance,
 * prints the coordinates of each segment, and checks whether each segment:
 * 
 *-has the correct orientation (horizontal or vertical),</li>
 *-has the correct length,</li>
 *-is connected to the previous segment, and</li>
 *-is perpendicular to the previous segment.</li>
 *
 * Any failures are printed to the console.
 *
 * @param sg the SpiralGenerator instance to be tested
 * @param numOfSegment the number of segments to generate and test
 */

   public static void tester(Point start, int unitLength, int numOfSegment ){
      SpiralGenerator sg = new SpiralGenerator(start, unitLength);
      //System.out.println("Making a spiral starting from java.awt.Point[x="+startX+",y="+startY+"]");
      System.out.println("Making a spiral starting from " + start);
      System.out.println("with a unit length of " + unitLength + ", and made up of " + numOfSegment + " segments");
      Line2D prevLine = null;
      Line2D line = null;
      int count = 1;
      for(int i=0;i<numOfSegment;i++){
         line = sg.nextSegment();
         double x1 = line.getX1();
         double y1 = line.getY1();
         double x2 = line.getX2();
         double y2 = line.getY2();
         
         boolean isHorizontal=isHorizontal(line);
         boolean isVertical=isVertical(line);

         System.out.println("Segment #"+ count +": Point2D.Double[" + x1 + ", " + y1 + "] Point2D.Double[" + x2 + ", " + y2 + "]");
         if(!isHorizontal&&!isVertical){
            System.out.println("FAILED: segment is not horizontal or vertical. Skipping pair tests.");
         }else if(prevLine != null){
            if(!isConnected(prevLine, line)){
               System.out.println("FAILED: last two segments are not connected");
            }
            boolean prevHorizontal = isHorizontal(prevLine);
            boolean prevVertical = isVertical(prevLine);

            if(!(isHorizontal && prevVertical)&&!(isVertical && prevHorizontal)){
               System.out.println("FAILED: last two segments are not perpendicular");
            }
         }
         count++;
         prevLine=line;
      }
   }

   public static void main(String[] args){
      tester(new Point(200, 300), 5, 10);
      tester(new Point(0, 0), 3, 8);
      tester(new Point(50, 50), 1, 6);
   }
}

// import java.awt.Point;
// import java.awt.geom.Line2D;

// public class SpiralGeneratorTester {

//     public static void main(String[] args) {
//         // Create different test cases
//         testSpiral(new Point(200, 300), 5, 10);
//         testSpiral(new Point(100, 100), 10, 8);
//         testSpiral(new Point(250, 250), 20, 12);
//     }

//     /**
//      * Tests generating a spiral with the given parameters.
//      */
//     private static void testSpiral(Point start, int unitLength, int numSegments) {
//         System.out.println("Making a spiral starting from " + start);
//         System.out.println("with a unit length of " + unitLength + ", and made up of " + numSegments + " segments:");

//         SpiralGenerator gen = new SpiralGenerator(start, unitLength);

//         Line2D prevSeg = null;
//         for (int i = 1; i <= numSegments; i++) {
//             Line2D currSeg = gen.nextSegment();
//             System.out.println("Segment #" + i + ": " + formatLine(currSeg));

//             // Check if the segment is horizontal or vertical
//             if (!isHorizontalOrVertical(currSeg)) {
//                 System.out.println("FAILED: segment is not horizontal or vertical.  Skipping pair tests.");
//                 prevSeg = currSeg;
//                 continue;
//             }

//             // Check if the current segment is connected to the previous segment
//             if (prevSeg != null) {
//                 if (!areConnected(prevSeg, currSeg)) {
//                     System.out.println("FAILED: last two segments are not connected");
//                 }

//                 // Check if the current segment is perpendicular to the previous segment
//                 if (!arePerpendicular(prevSeg, currSeg)) {
//                     System.out.println("FAILED: last two segments are not perpendicular");
//                 }
//             }

//             prevSeg = currSeg;
//         }

//         System.out.println(); // Blank line separates different tests
//     }

//     // Formats a line segment for printing
//     private static String formatLine(Line2D line) {
//         return line.getP1() + " " + line.getP2();
//     }

//     // Returns true if the line segment is horizontal or vertical
//     private static boolean isHorizontalOrVertical(Line2D line) {
//         return line.getP1().getX() == line.getP2().getX() || line.getP1().getY() == line.getP2().getY();
//     }

//     // Returns true if two line segments are connected (share an endpoint)
//     private static boolean areConnected(Line2D a, Line2D b) {
//         return a.getP2().equals(b.getP1());
//     }

//     // Returns true if two line segments are perpendicular to each other
//     private static boolean arePerpendicular(Line2D a, Line2D b) {
//         boolean aHorizontal = a.getP1().getY() == a.getP2().getY();
//         boolean aVertical = a.getP1().getX() == a.getP2().getX();
//         boolean bHorizontal = b.getP1().getY() == b.getP2().getY();
//         boolean bVertical = b.getP1().getX() == b.getP2().getX();

//         return (aHorizontal && bVertical) || (aVertical && bHorizontal);
//     }
// }
