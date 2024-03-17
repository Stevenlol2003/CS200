import java.util.Scanner;

/**
 * The behavior of this code is different in Eclipse or IntelliJ as compared to zyBooks.
 * Refactor the code so that it works in both zyBooks and Eclipse or IntelliJ.
 *
 * @author Steven Ren
 *
 */

public class IDEvsZyBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 integers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("The integers you entered are: " + a + ", " + b + ", and " + c);
        System.out.println(compareSum(a, b, c));
        System.out.println("Enter 3 words:");
        String d = sc.next();
        String e = sc.next();
        String f = sc.next();
        System.out.println("The words you entered are: \"" + d + "\", \"" + e + "\", and \"" + f + "\"");
        System.out.println(compareSum(d, e, f));
    }

    public static String compareSum(int a, int b, int c) {
        String numComparing = "";
        if (a + b == c) {
            numComparing = a + " + " + b + " equals " + c;
        } else if (a + b < c) {
            numComparing = a + " + " + b + " is less than " + c;
        } else {
            numComparing = a + " + " + b + " is greater than " + c;
        }
        return numComparing;
    }

    public static String compareSum(String x, String y, String z) {
        String words = x + y;
        String wordsComparing = "";
        if (words.equals(z)) {
            wordsComparing = "\"" + x + "\" concatenated with \"" + y + "\" is \"" + z +"\"";
        }
        else {
            wordsComparing = "\"" + x + "\" concatenated with \"" + y + "\" is not \"" + z +"\"";
        }
        return wordsComparing;
    }
}