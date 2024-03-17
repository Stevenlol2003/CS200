import java.util.Scanner;

public class MinMaxAvg {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int[] userValues = new int[10];
      int i;
      
      for (i = 0; i < 10; ++i) {
         userValues[i] = scnr.nextInt();
      }
      
      int min = userValues[0];
      for (i = 1; i < 10; ++i) {
         if (userValues[i] < min) {
            min = userValues[i];
         }
      }
      System.out.print(min + " ");

      int max = userValues[0];
      for (i = 1; i < 10; ++i) {
         if (userValues[i] > max) {
            max = userValues[i];
         }
      }
      System.out.print(max + " ");

      int sum = 0;
      for (i = 0; i < 10; ++i) {
         sum += userValues[i];
      }
      int remainingEight = sum - min - max;
      System.out.println((double)remainingEight / 8);
   }
}
