import java.util.Scanner;

/**
 * Some methods to get user input.
 *
 * @author Steven Ren
 */
public class InputMethods {

    /**
     * This method checks to see if a valid integer is found in a maximum of 3 three lines of input.
     * Returns a valid integer or an error value of -1 if input is null, error value of -2 * if
     * bounds are bad, returns error value of -3 if no valid integer is found in first 3 lines.
     *
     * @param input Predefined user input
     * @param inputPrompt String that is printed out to show the enter number range
     * @param lowerBound  Lowest valid integer is greater than this integer
     * @param upperBound  Highest valid integer is equal to this integer
     * @return Returns a valid integer or an error value of -1 if input is null, error value of -2
     * if bounds are bad, returns error value of -3 if no valid integer is found in first 3 lines.
     *
     * If lowerBound is 5 and upperBound is 10, an input of 6 would return 6.
     * If lowerBound is 7 and upperBound is 2, an input of 5 would return -2.
     * Regardless of the lowerBound and upperBound, a null input would return -1;
     */
    public static int getValidInt(Scanner input, String inputPrompt, int lowerBound,
                                  int upperBound) {
        System.out.print(inputPrompt);

        //checks if input is null, if it is null returns -2
        if (input == null) {
            return -1;
        }

        //checks if bounds are not right, if lowerBound is not less than upperBound return -2
        if (!(lowerBound < upperBound)) {
            return -2;
        }

        //for loop that checks maximum of three lines, if no valid integer is found returns -3
        for (int i = 0; i < 3; ++i) {
            if (input.hasNextInt()) { //if next token can be an integer
                int integer = input.nextInt(); //read token as int
                if ((integer > lowerBound) && (integer <= upperBound)) {
                    return integer;
                } else {
                    input.nextLine();
                }
            } else {
                input.nextLine();
            }
        }
        return -3;
    }
}