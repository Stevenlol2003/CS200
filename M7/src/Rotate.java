import java.util.Scanner;

public class Rotate {
   
   public static void rotateLeft3 (int[] rotating) {
      int temp0 = rotating[0];
      int temp1 = rotating[1];
      int temp2 = rotating[2];
      rotating[0] = temp1;
      rotating[1] = temp2;
      rotating[2] = temp0;
   }
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); 
      int[] nValues = new int[3]; 
      
      nValues[0] = scnr.nextInt(); 
      nValues[1] = scnr.nextInt(); 
      nValues[2] = scnr.nextInt(); 
      
      rotateLeft3(nValues); 
      
      System.out.println(nValues[0] + " " + nValues[1] + " " + nValues[2]); 
   }
}
