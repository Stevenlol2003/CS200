/**
 * This class contains the entire program that prints out arrays passed through mystery methods
 * before and after they are modified.
 *
 * @author Steven Ren
 */
public class MysteryMethods {
    /**
     * This is the main method, and calls other methods that modifies the original char array and
     * prints out the result. This method demonstrates some uses of the array manipulation methods
     * in this class.
     *
     * @param args unused
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Mystery Methods!");
        char[] charArray = {'e', 'n', 'i', 'r', 't', 'S', 'g', 'l', 'p', 'm', 'i', 'S'};
        System.out.print("Initial array: ");
        System.out.println(charArray);
        System.out.println(" \nMethod Outputs:");

        int charIndex1 = getIndex('e', charArray);

        System.out.println("First call of the first Method:");
        System.out.println(charIndex1);

        int charIndex2 = getIndex('g', charArray);

        System.out.println("Second call of the first Method:");
        System.out.println(charIndex2);

        swapChar(charIndex1, charIndex2, charArray);

        System.out.println("Call of the second Method:");
        System.out.println(charArray);

        charArray = reverseArray(charArray);
        System.out.println("Call of the third Method:");
        System.out.println(charArray);

        char[] alphabetArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        int[] countChar = countChar(alphabetArr, charArray); //number of times each letter is used

        System.out.println("Call of the fourth Method:");
        printInput("Fourth Method Output:", countChar);
    }

    /**
     * This method prints the description followed by the contents of list. The list begins with
     * '[', ends with ']' and each element is separated with ', '. Example: printInput( "Initial
     * array:", new int[]{1,2,3}) Initial array: [1, 2, 3]
     * <p>
     *
     * @param description The text printed out before the list of ints.
     * @param list        The array of ints to be printed.
     */
    public static void printInput(String description, int[] list) {

        System.out.print(description);
        System.out.print(" [");

        for (int i = 0; i < list.length; i++) {

            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(list[i]);
        }
        System.out.println("]");
    }

    /**
     * This method checks an array to see if it has a certain char, if the char is found, the method
     * returns the index of it, if not found it returns -1.
     *
     * @param thisChar      The char that is being looked for the index of.
     * @param originalArray The array that is being checked through for the char.
     */
    public static int getIndex(char thisChar, char[] originalArray) {

        for (int i = 0; i < originalArray.length; i++) {

            if (thisChar == originalArray[i]) {

                return i;
            }
        }

        return -1;
    }

    /**
     * This method swaps the 2 chars if they exist, returns original array if the 2 chars don't
     * exist or array length is too short.
     *
     * @param indexChar1 The index of the first char
     * @param indexChar2 The index of the second char
     * @param arrayChar  The array that will have chars swapped
     */
    public static void swapChar(int indexChar1, int indexChar2, char[] arrayChar) {

        if (indexChar1 < 0 || indexChar2 < 0 || arrayChar.length <= Math.max(indexChar1,
                indexChar2)) {
            return;
        }
        char temp = arrayChar[indexChar1];
        arrayChar[indexChar1] = arrayChar[indexChar2];
        arrayChar[indexChar2] = temp;
    }

    /**
     * This method returns the original array if the array has a length of 0, it creates a new array
     * of the same length if the length is not 0, and then it stores the reversed array in the newly
     * created array.
     *
     * @param beforeReverse The array that will be reversed
     */
    public static char[] reverseArray(char[] beforeReverse) {

        if (beforeReverse.length == 0) {
            return beforeReverse;
        }

        char[] afterReverse = new char[beforeReverse.length];

        for (int i = 0; i < beforeReverse.length; i++) {
            afterReverse[beforeReverse.length - i - 1] = beforeReverse[i];
        }
        return afterReverse;
    }

    /**
     * This method checks how many times each letter of the alphabet is used in the array we have
     *
     * @param alphabet Array that contains all the letters of the alphabet
     * @param myArray  Array that we had and are checking the number of each char
     */
    public static int[] countChar(char[] alphabet, char[] myArray) {

        if (alphabet.length == 0 || myArray.length == 0) {
            return new int[alphabet.length];
        }

        int[] numberOfChars = new int[alphabet.length];

        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if (Character.toUpperCase(myArray[j]) == Character.toUpperCase(alphabet[i])) {
                    numberOfChars[i] += 1;
                }
            }
        }

        return numberOfChars;
    }
}
