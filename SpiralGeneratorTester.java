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

import java.awt.geom.Line2D;
import java.awt.Point;

/**
 * SpiralGeneratorTester tests SpiralGenerator objects by:
 * - Printing SpiralGenerator info
 * - Printing each generated segment
 * - Checking if segments are horizontal or vertical
 * - Checking if consecutive segments are connected and perpendicular
 */
public class SpiralGeneratorTester {

    // 判断线段是否垂直
    public static boolean isVertical(Line2D seg) {
        return seg.getX1() == seg.getX2();
    }

    // 判断线段是否水平
    public static boolean isHorizontal(Line2D seg) {
        return seg.getY1() == seg.getY2();
    }

    // 判断两条线段是否相连
    public static boolean isConnected(Line2D seg1, Line2D seg2) {
        return (seg1.getX1() == seg2.getX1() && seg1.getY1() == seg2.getY1())
            || (seg1.getX1() == seg2.getX2() && seg1.getY1() == seg2.getY2())
            || (seg1.getX2() == seg2.getX1() && seg1.getY2() == seg2.getY1())
            || (seg1.getX2() == seg2.getX2() && seg1.getY2() == seg2.getY2());
    }

    // 判断两条线段是否垂直（利用向量点积）
    public static boolean isPerpendicular(Line2D seg1, Line2D seg2) {
        double dx1 = seg1.getX2() - seg1.getX1();
        double dy1 = seg1.getY2() - seg1.getY1();
        double dx2 = seg2.getX2() - seg2.getX1();
        double dy2 = seg2.getY2() - seg2.getY1();
        return Math.abs(dx1 * dx2 + dy1 * dy2) < 1e-6;
    }

    // Tester 方法：生成 spiral 并检查
    public static void tester(SpiralGenerator sg, int numOfSegment) {
        int step = 0; // 用于判断 horizontal / vertical 轮流
        int unitLength = sg.getUnitLength();
        int currLength = unitLength;
        int startX = sg.getStartX();
        int startY = sg.getStartY();

        System.out.println("Making a spiral starting from java.awt.Point[x=" + startX + ",y=" + startY + "]");
        System.out.println("with a unit length of " + unitLength + ", and made up of " + numOfSegment + " segments:");

        Line2D prevLine = null;
        int count = 1;

        for (int i = 0; i < numOfSegment; i++) {
            Line2D line = sg.nextSegment();
            double x1 = line.getX1();
            double y1 = line.getY1();
            double x2 = line.getX2();
            double y2 = line.getY2();

            System.out.println("Segment #" + count + ": Point2D.Double[" + x1 + ", " + y1 + "] Point2D.Double[" + x2 + ", " + y2 + "]");

            // 检查水平/垂直
            boolean horizontal = isHorizontal(line);
            boolean vertical = isVertical(line);

            if (!horizontal && !vertical) {
                System.out.println("FAILED: segment is not horizontal or vertical.  Skipping pair tests.");
            } else if (prevLine != null) {
                // 只在前一个段存在且当前段水平或垂直时做 pair 测试
                if (!isConnected(prevLine, line)) {
                    System.out.println("FAILED: last two segments are not connected");
                }
                if (!isPerpendicular(prevLine, line)) {
                    System.out.println("FAILED: last two segments are not perpendicular");
                }
            }

            // 更新长度和 step
            if (step == 1) {
                currLength += unitLength;
            }
            step = 1 - step;
            prevLine = line;
            count++;
        }
        System.out.println(); // 每个 SpiralGenerator 测试后换行
    }

    public static void main(String[] args) {
        // 测试不同参数
        SpiralGenerator sg1 = new SpiralGenerator(new Point(200, 200), 10);
        SpiralGenerator sg2 = new SpiralGenerator(new Point(100, 100), 5);
        SpiralGenerator sg3 = new SpiralGenerator(new Point(50, 50), 1);

        // 测试每个 SpiralGenerator
        tester(sg1, 10);
        tester(sg2, 8);
        tester(sg3, 6);
    }
}
