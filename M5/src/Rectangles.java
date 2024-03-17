import java.util.Scanner;
import static java.lang.Math.abs;


public class Rectangles {
   
   public static boolean firstRectangleSmaller(int r1p1, int r1p2, int r1p3, int r1p4,
                                        int r2p1, int r2p2, int r2p3, int r2p4) {
      int r1area = Math.abs((r1p3 - r1p1) * (r1p4 - r1p2));
      int r2area = Math.abs((r2p3 - r2p1) * (r2p4 - r2p2));
      if (r1area < r2area) {
         return true;
      }
      else {
         return false;
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); 
      int r1xul, r1yul, r1xbr, r1ybr; // x upper-left, y upper-left, x bottom-right, y bottom-right
      int r2xul, r2yul, r2xbr, r2ybr;
      
      r1xul = scnr.nextInt(); r1yul = scnr.nextInt(); r1xbr = scnr.nextInt(); r1ybr =
              scnr.nextInt();
      r2xul = scnr.nextInt(); r2yul = scnr.nextInt(); r2xbr = scnr.nextInt(); r2ybr = scnr.nextInt(); 
   
      System.out.println(firstRectangleSmaller(r1xul, r1yul, r1xbr, r1ybr, r2xul, r2yul, r2xbr, r2ybr)); 
   }
}
