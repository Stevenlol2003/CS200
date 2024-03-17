import java.util.Locale;
import java.util.Scanner;

public class HotdogDetector {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a food: ");
        String food = scnr.nextLine().trim();

            if (food.equals("hotdog")) {
                System.out.println("hotdog");
            }
            else {
                System.out.println("not hotdog");
            }
        }

}
