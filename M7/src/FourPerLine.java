import java.util.Scanner;

public class FourPerLine {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int[] yearlyValues = new int[12];
      int i;
      int userNum;
      
      // Get array values
      for (i = 0; i < 12; ++i) {
         yearlyValues[i] = scnr.nextInt();
      }
      
      for (i = 0; i < 12; i+=4) {
         System.out.println(yearlyValues[i] + " " + yearlyValues[i+1] + " " + yearlyValues[i+2] + " " + yearlyValues[i+3]);

      }
   }
}
