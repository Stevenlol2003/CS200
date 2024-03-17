import java.util.Scanner;
import java.util.InputMismatchException;

public class IntException {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.print(isDivisibleByThree(scnr));
   }
   
  /**
   * Determines if the input to scanner is evenly divisible by three, and
   * returns the result as a boolean. If the input to scanner is inappropriate,
   * catch the exception.
   * 
   * @param  scnr  a scanner object 
   * @return       true if input is evenly divisible by three, false if not
   */ 
   public static boolean isDivisibleByThree(Scanner scnr) throws InputMismatchException {
       int number;
       try {
           number = scnr.nextInt();
           return number % 3 == 0;
       } catch (InputMismatchException e) {
           return false;
       }
      //TODO: try-catch block which catches incorrect input
   
   }

}