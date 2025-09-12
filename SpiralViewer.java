import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Point;

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
