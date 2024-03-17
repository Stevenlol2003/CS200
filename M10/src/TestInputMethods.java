import java.util.Scanner;

/**
 * This contains testing methods for the InputMethods class.
 *
 * @author Steven Ren
 */
public class TestInputMethods {

    /**
     * This main method runs the selected tests.  Comment out a test if you don't want it to run.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        testGetValidInt();
    }

    /**
     * Tests that the getValidInt method handles all the cases described in the assignment.
     */
    private static void testGetValidInt() {

        //test 1, passes a valid value in line 1, should be correct
        { //creates a new scope so that the variables declared within it don't affect others in
            // this same method.
            boolean error = false;
            //simulates a user typing 9 then Enter.
            Scanner input = new Scanner("9\n");

            //the value expected to be returned by getValidInt for this test case.
            int expected = 9;

            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and" +
                            " 10:",
                    5, 10);

            //if the actual value returned doesn't equal the expected then this is an error.
            if (actual != expected) {
                error = true;

                //a message describing the error so that the programmer can find this test and
                //see what the values were.
                System.out.println("testGetValidInt 1) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
            if (error) {
                System.out.println("testGetValidInt 1 failed");
            } else {
                System.out.println("testGetValidInt 1 passed; it is expected that the prompt and "
                        + "getValidInt error messages are printed out.");
            }
        }

        //test 2, pass null as the scanner argument and check that the returned value is -1.
        { //creates a new scope so that the variables declared within it don't affect others in
            // this same method.
            boolean error = false;
            //simulates a null input
            Scanner input = null;

            //the value expected to be returned by getValidInt for this test case.
            int expected = -1;

            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and" +
                            " 10:",
                    5, 10);

            //if the actual value returned doesn't equal the expected then this is an error.
            if (actual != expected) {
                error = true;

                //a message describing the error so that the programmer can find this test and
                //see what the values were.
                System.out.println("testGetValidInt 2) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
            if (error) {
                System.out.println("testGetValidInt 2 failed");
            } else {
                System.out.println("testGetValidInt 2 passed; it is expected that the prompt and "
                        + "getValidInt error messages are printed out.");
            }
        }

        //test 3, passes a bad range, checks if the range is correct and returns -2
        { //creates a new scope so that the variables declared within it don't affect others in
            // this same method.
            boolean error = false;
            //simulates a user typing 6\n then Enter.
            Scanner input = new Scanner("6\n");

            //the value expected to be returned by getValidInt for this test case.
            int expected = -2;

            int actual = InputMethods.getValidInt(input, "Enter a number between 7 and" +
                            " 1:",
                    7, 1);

            //if the actual value returned doesn't equal the expected then this is an error.
            if (actual != expected) {
                error = true;

                //a message describing the error so that the programmer can find this test and
                //see what the values were.
                System.out.println("testGetValidInt 3) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
            if (error) {
                System.out.println("testGetValidInt 3 failed");
            } else {
                System.out.println("testGetValidInt 3 passed; it is expected that the prompt and "
                        + "getValidInt error messages are printed out.");
            }
        }

        //test 4, passes through a non valid first token in line 1, skips over the rest of line
        // 1, and reads a valid line 2 and returns correct value
        { //creates a new scope so that the variables declared within it don't affect others in
            // this same method.
            boolean error = false;
            //simulates a user typing t 9\n8\n then Enter.
            Scanner input = new Scanner("t 9\n8\n");

            //the value expected to be returned by getValidInt for this test case.
            int expected = 8;

            int actual = InputMethods.getValidInt(input, "Enter a number between 7 and" +
                            " 10:",
                    7, 10);

            //if the actual value returned doesn't equal the expected then this is an error.
            if (actual != expected) {
                error = true;

                //a message describing the error so that the programmer can find this test and
                //see what the values were.
                System.out.println("testGetValidInt 4) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
            if (error) {
                System.out.println("testGetValidInt 4 failed");
            } else {
                System.out.println("testGetValidInt 4 passed; it is expected that the prompt and" +
                        " " + "getValidInt error messages are printed out.");
            }
        }

        //test 5, passes a word in line one, check that the first line starts with a word that is
        // ignored and returns a valid integer, the maximum valid value, at the beginning of the
        // second line.
        { //creates a new scope so that the variables declared within it don't affect others in
            // this same method.
            boolean error = false;
            //simulates a user typing words to ignore\n99\n then Enter.
            Scanner input = new Scanner("words to ignore\n99\n");

            //the value expected to be returned by getValidInt for this test case.
            int expected = 99;

            int actual = InputMethods.getValidInt(input, "Enter a number between 23 and"
                            + " 99:"
                    , 23, 99);

            //if the actual value returned doesn't equal the expected then this is an error.
            if (actual != expected) {
                error = true;

                //a message describing the error so that the programmer can find this test and
                //see what the values were.
                System.out.println("testGetValidInt 5) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
            if (error) {
                System.out.println("testGetValidInt 5 failed");
            } else {
                System.out.println("testGetValidInt 5 passed; it is expected that the prompt and "
                        + "getValidInt error messages are printed out.");
            }
        }

        //test 6, check that the first token on the third line is the first valid integer and is
        // within the range of valid values but not an edge case.
        { //creates a new scope so that the variables declared within it don't affect others in
            // this same method.
            boolean error = false;
            //simulates a user typing words to ignore\nhello\n9\n then Enter.
            Scanner input = new Scanner("words to ignore\nhello\n9\n");

            //the value expected to be returned by getValidInt for this test case.
            int expected = 9;

            int actual = InputMethods.getValidInt(input, "Enter a number between 1 and" +
                            " 10:",
                    1, 10);

            //if the actual value returned doesn't equal the expected then this is an error.
            if (actual != expected) {
                error = true;

                //a message describing the error so that the programmer can find this test and
                //see what the values were.
                System.out.println("testGetValidInt 6) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
            if (error) {
                System.out.println("testGetValidInt 6 failed");
            } else {
                System.out.println("testGetValidInt 6 passed; it is expected that the prompt and "
                        + "getValidInt error messages are printed out.");
            }
        }

        //test 7, check that when the first tokens on the first three lines are not valid, using
        // values just outside acceptable values, then the appropriate value is returned.
        { //creates a new scope so that the variables declared within it don't affect others in
            // this same method.
            boolean error = false;
            //simulates a user typing 1000\n43\n0\n then Enter.
            Scanner input = new Scanner("1000\n43\n0\n30\n");

            //the value expected to be returned by getValidInt for this test case.
            int expected = -3;

            int actual = InputMethods.getValidInt(input, "Enter a number between 44" +
                    " and " +
                    "999:", 44, 999);

            //if the actual value returned doesn't equal the expected then this is an error.
            if (actual != expected) {
                error = true;

                //a message describing the error so that the programmer can find this test and
                //see what the values were.
                System.out.println("testGetValidInt 7) Error, expected: " + expected + ", actual" +
                        ":" + " " + actual);
            }
            if (error) {
                System.out.println("testGetValidInt 7 failed");
            } else {
                System.out.println("testGetValidInt 7 passed; it is expected that the prompt and "
                        + "getValidInt error messages are printed out.");
            }

        }
    }
}

