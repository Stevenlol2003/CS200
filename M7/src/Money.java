import java.util.Scanner;

public class Money {
   
   public static int[] centsToDollarsCents(int userCents) {
      int[] convert = new int[2];
      int cents = userCents % 100;
      int dollars = userCents / 100;
      convert[0] = dollars;
      convert[1] = cents;
      return convert;

   } 
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int money = input.nextInt();


      //call the centsToDollarsCents method
      int[] finalMoney = centsToDollarsCents(money);

      //print out the dollars and cents here
      System.out.println(finalMoney[0] + " dollars " + finalMoney[1] + " cents");
   }
}
