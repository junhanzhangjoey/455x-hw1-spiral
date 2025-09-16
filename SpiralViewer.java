import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Point;
/**
 * this class take I/O input from the user, user need to enter starting coordinate and initial segment length,
   there is a precondition for the length, it has to be greater than zero, it will keep letting user input the length
   until it satisfy the precondition. The user also need to enter number of segments and also have the same precondition(greater than 0).
   we use JFrame(a top-level window in Java Swing that holds components) to displays the spiral.
   How to Run:
   1. compile all needed files javac SpiralViewer.java SpiralGenerator.java SpiralComponent.java
   2. Run the viewer: java SpiralViewer.
   3. Follow prompts in the console to enter coordinates, initial length, and number of segments.
   4. The spiral will be displayed in a window.
 */
public class SpiralViewer{

   public static void main(String[] args){

      Scanner in = new Scanner(System.in);

      System.out.println("Enter the initial position");

      System.out.print("Enter x: ");
      int x=in.nextInt();

      System.out.print("Enter y: ");
      int y=in.nextInt();
      
      int initSegment=0;
      while(true){
         System.out.println("Enter length of initial segment");
         initSegment=in.nextInt();
         
         if(initSegment<=0){
	    System.out.println("Error: value must be > 0");
	 }else{
	    break;
	 }
      }
      int numOfSegment=0;
      while(true){
         System.out.println("Enter number of segments");
         numOfSegment=in.nextInt();

         if(numOfSegment<=0){
            System.out.println("Error: value must be > 0");
         }else{
            break;
         }
      }

      JFrame frame = new JFrame();
      frame.setSize(500,800);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      SpiralGenerator sg = new SpiralGenerator(new Point(x,y),initSegment);
      SpiralComponent sc = new SpiralComponent(sg,numOfSegment);
      frame.add(sc);
      frame.setVisible(true);
   }

}
