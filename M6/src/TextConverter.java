import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class TextConverter {

   /**
     * Provides the main menu for the text converter and calls methods based on menu options chosen.
     * 
     * @param args
     */
    public static void main(String[] args) {
		//testAction1337();
		//testActionReverse();
		//testActionCaesar();

		System.out.println("Welcome to the Text Converter.");
		System.out.println("Available Actions:");
		System.out.println("  1337) convert to 1337-speak");
		System.out.println("  rev) reverse the string");
		System.out.println("  caesar) rotate each character right 1 position if it is a letter");
		System.out.println("  quit) exit the program\n");

		System.out.print("Please enter a string: ");
		Scanner scnr = new Scanner(System.in);
		String originalText = scnr.nextLine();

		System.out.print("Action (1337, rev, caesar, quit): ");
		String menuChoice = scnr.nextLine();
		while (!menuChoice.equals("quit")) {
			if (menuChoice.equals("1337")) {
				originalText = action1337(originalText);
				System.out.println(originalText);
			} else if (menuChoice.equals("rev")) {
				originalText = actionReverse(originalText);
				System.out.println(originalText);
			} else if (menuChoice.equals("caesar")) {
				originalText = actionCaesar(originalText);
				System.out.println(originalText);
			} else {
				System.out.println("Unrecognized action.");
				System.out.println(originalText);
			}
			System.out.print("Action (1337, rev, caesar, quit): ");
			menuChoice = scnr.nextLine();
		}
		System.out.println("See you next time!");
    }

    /**
     * 1337 - convert the string to leet-speak: 
     * Replace each L or l with a 1 (numeral one) 
     * Replace each E or e with a 3 (numeral three) 
     * Replace each T or t with a 7 (numeral seven) 
     * Replace each O or o with a 0 (numeral zero) 
     * Replace each S or s with a $ (dollar sign)
     * 
     * @param current Original string
     * @return string converted to leet-speak.
     */
    public static String action1337(String current) {
		int i;
		String newString = "";
		for (i = 0; i < current.length(); ++i) {
			if ((current.charAt(i) == 'L') || ((current.charAt(i)) == 'l')) {
				newString = newString + "1";
			}
			else if ((current.charAt(i) == 'E') || ((current.charAt(i)) == 'e')) {
				newString = newString + "3";
			}
			else if ((current.charAt(i) == 'T') || ((current.charAt(i)) == 't')) {
				newString = newString + "7";
			}
			else if ((current.charAt(i) == 'O') || ((current.charAt(i)) == 'o')) {
				newString = newString + "0";
			}
			else if ((current.charAt(i) == 'S') || ((current.charAt(i)) == 's')) {
				newString = newString + "$";
			}
			else {
				newString = newString + current.charAt(i);
			}
		}
        return newString;
    }

	/**
	 *  tests action1337 method with various cases to ensure it is working
	 *  correctly.
	 */
    public static void testAction1337() {
    	boolean error = false;

    	String input1 = "LEeTs";
    	String expected1 = "1337$";
    	String result1 = action1337( input1);
    	if ( !result1.equals( expected1)) {
    		error = true;
    		System.out.println("1) testAction1337 with input " + input1 + ", expected: " + expected1 + " but result: " + result1);
    	}
		String input2 = "I like Cheez-Itz";
		String expected2 = "I 1ik3 Ch33z-I7z";
		String result2 = action1337( input2);
		if ( !result2.equals( expected2)) {
			error = true;
			System.out.println("2) testAction1337 with input " + input2 + ", expected: " + expected2 + " but result: " + result2);
		}
		String input3 = "My favorite basketball player is #Bob";
		String expected3 = "My fav0ri73 ba$k37ba11 p1ay3r i$ #B0b";
		String result3 = action1337( input3);
		if ( !result3.equals( expected3)) {
			error = true;
			System.out.println("3) testAction1337 with input " + input3 + ", expected: " + expected3 + " but result: " + result3);
		}
      //FIX ME
    	//add at least 2 other test cases (Use different variable names). What edge cases can you think of?

    	if ( error) {
    		System.out.println( "testAction1337 failed");
    	} else {
    		System.out.println("testAction1337 passed");
    	}
    }
	
 
    /**
     * This reverses the order of characters in the current string.
     * 
     * @param current Original string to be reversed.
     * @return The string in reversed order.
     */
    public static String actionReverse(String current) {
		int i;
		String newString = "";
		//for (i = 0; i < current.length() -1; ++i) {
		//	newString = current.charAt(current.length() - (i + 1)) + newString;
		//}
		for (i = current.length()-1; i >= 0; --i) {
			newString = newString + current.charAt(i);
		}
		return newString;

    }

	/**
	 *  tests actionReverse method with various cases to ensure it is working
	 *  correctly. 
	 */
    public static void testActionReverse() {
    	boolean error = false;

    	String input1 = "Abc";
    	String expected1 = "cbA";
    	String result1 = actionReverse( input1);
    	if ( !result1.equals( expected1)) {
    		error = true;
    		System.out.println("1) testActionReverse with input " + input1 + ", expected: " + expected1 + " but result: " + result1);
    	}
		String input2 = "world";
		String expected2 = "dlrow";
		String result2 = actionReverse( input2);
		if ( !result2.equals( expected2)) {
			error = true;
			System.out.println("2) testActionReverse with input " + input2 + ", expected: " + expected2 + " but result: " + result2);
		}
		String input3 = "c12j";
		String expected3 = "j21c";
		String result3 = actionReverse( input3);
		if ( !result3.equals( expected3)) {
			error = true;
			System.out.println("3) testActionReverse with input " + input3 + ", expected: " + expected3 + " but result: " + result3);
		}
    	//FIX ME
    	//add at least 2 other test cases (Use different variable names). What edge cases can you think of?


    	if ( error) {
    		System.out.println( "testActionReverse failed");
    	} else {
    		System.out.println("testActionReverse passed");
    	}
    }     
    
    /**
     * This rotates each character right 1 position if it is a letter,
     *  'z' and 'Z' will be converted to 'a' and 'A' respectively.
     * Hint: Use isLetter() method to help you check the character.
     * 
     * @param current Original string
     * @return The rotated string
     */
    public static String actionCaesar(String current) {
		int i;
		char letter;
		String newString = "";
		for (i = 0; i < current.length(); ++i) {
			letter = current.charAt(i);

			if (current.charAt(i) == 'Z') {
				letter = 'A';
				newString = newString + letter;

			}
			else if (current.charAt(i) == 'z') {
				letter = 'a';
				newString = newString + letter;

			}
			else if (Character.isLetter(current.charAt(i))) {
				++letter;
				newString = newString + letter;
			}
			else {
				newString = newString + current.charAt(i);
			}
		}
        return newString;
    }

	/**
	 *  tests actionReverse method with various cases to ensure it is working
	 *  correctly. 
	 */
    public static void testActionCaesar() {
    	boolean error = false;

    	String input1 = "gotIt";
    	String expected1 = "hpuJu";
    	String result1 = actionCaesar( input1);
    	if ( !result1.equals( expected1)) {
    		error = true;
    		System.out.println("1) testActionCaesar with input " + input1 + ", expected: " + expected1 + " but result: " + result1);
    	}
		String input2 = "world";
		String expected2 = "xpsme";
		String result2 = actionCaesar( input2);
		if ( !result2.equals( expected2)) {
			error = true;
			System.out.println("2) testActionCaesar with input " + input2 + ", expected: " + expected2 + " but result: " + result2);
		}
		String input3 = "zoo";
		String expected3 = "app";
		String result3 = actionCaesar( input3);
		if ( !result3.equals( expected3)) {
			error = true;
			System.out.println("3) testActionCaesar with input " + input3 + ", expected: " + expected3 + " but result: " + result3);
		}
    	//FIX ME
    	//add at least 2 other test cases (Use different variable names). What edge cases can you think of?


    	if ( error) {
    		System.out.println( "testActionCaesar failed");
    	} else {
    		System.out.println("testActionCaesar passed");
    	}
    }     
    
}
