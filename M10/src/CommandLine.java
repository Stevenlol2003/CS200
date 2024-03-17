public class CommandLine {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.print("Incorrect number of arguments passed");
        }
        String number;
        number = args[0];
        int numberInt = Integer.parseInt(number);
        int factorial = 1;
        if (args.length != 1) {
            System.out.print("");
        }
        else if (numberInt < 0) {
            System.out.print("Argument is a negative number");
        } else {
            for (int i = numberInt; i > 0; --i) {
                factorial *= i;
            }
            System.out.print("The factorial of " + number + " is " + factorial);
        }
    }
}