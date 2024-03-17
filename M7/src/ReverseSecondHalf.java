import java.util.Scanner;

public class ReverseSecondHalf {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int currNum;
      int i; 
      int temp;
      int listLength;

      listLength = scnr.nextInt();
      
      int[] listNums = new int[listLength];
      
      for(i = 0; i < listLength; i++){
         currNum = scnr.nextInt();
         listNums[i] = currNum;
      }

      int middle = listLength / 2;
      int tempVal = listNums[middle];
      listNums[middle] = listNums[listLength - 1];
      listNums[listLength - 1] = tempVal;

      // Reverse listNums.
       int count = 1;
      for (i = middle + 1; i < (listLength + (middle + 1)) / 2; ++i){
         temp = listNums[i];
         listNums[i] = listNums[listLength - count];
         listNums[listLength - i + 3] = temp;
         ++count;
      }

      for (i = 0; i < listLength; ++i) {
         System.out.print(listNums[i] + " ");
      }
      System.out.println();
   }
}
