import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordDetective {

    /**
     * Finds the specified set of words in the specified file and returns them as an ArrayList. This
     * finds the specified set in the file which is on the line number of the set. The first line
     * and set in the file is 1.
     * <p>
     * This returns an ArrayList with the keyword first, and then followed by the rest of the words
     * in the set, space delimited. Note: The String class indexOf method can be used to find the :.
     * The keyword is everything prior to the : and the keywords are space delimited after.
     * <p>
     * An error message to System.out should be printed and an empty list returned in the following
     * cases: A set number is not found. "Error: set " + fileSetNumber + " not found." A set doesn't
     * have the : after the keyword. "Error: colon (:) not found in set " + fileSetNumber + "."
     * <p>
     * Example file format: about: about auto bat boat but out tab tub other: her hero hot other the
     * toe their: her hire hit the their tie tier tire
     * <p>
     * If the set number is 2 the returned ArrayList should contain: [other, her, hero, hot, other,
     * the, toe]
     * <p>
     * Hint: In order to read a specific line in the file, you can use a while loop. In each
     * iteration, read the next line and increment a counter, until reaching the line number you
     * want.
     *
     * @param filename The file containing word sets.
     * @param set      The number of the set, starting with 1.
     * @return The set of words, with the keyword first and later in the list.
     * @throws FileNotFoundException
     */
    public static ArrayList<String> loadWordSet(String filename, int set)
        throws FileNotFoundException {
        ArrayList<String> wordSets = new ArrayList<>();

        try {
            FileInputStream myFile = new FileInputStream(filename);
            Scanner input = new Scanner(myFile);
            Scanner scnr = null;


            int counter = 1;
            while (input.hasNextLine()) {
                if (!(set >= 1 && set <= 50)) {
                    System.out.println("Error: set " + set + " not found.");
                    return wordSets;
                }
                if (set == counter) {
                    String word = input.nextLine();
                    if (!word.contains(":")) {
                        System.out.println("Error: colon (:) not found in set " + set + ".");
                        return wordSets;
                    } else {
                        scnr = new Scanner(word);
                        scnr.useDelimiter(":");

                        String firstHalf = scnr.next().trim();
                        wordSets.add(firstHalf);

                        String secondHalf = scnr.nextLine().trim();
                        Scanner scan = new Scanner(secondHalf);
                        scan.useDelimiter(" ");

                        String colon = scan.next();

                        while (scan.hasNext()) {
                            String addThisWord = scan.next();
                            wordSets.add(addThisWord);
                        }
                        input.close();
                        return wordSets;
                    }

                } else {
                    input.nextLine();
                    counter++;
                }
            }
        } catch (FileNotFoundException e) {
            return wordSets;
        }

        return null;
    }

    /**
     * Reorders the letters in word.
     * <p>
     * Algorithm: Copy the word into an array of characters. Repeat 4 times: Randomly select 2
     * indexes in the word array using nextInt( word length) of the randGen parameter. Swap the
     * letters at the selected indexes in the word array. Create a string from the array of
     * characters.
     *
     * @param word    The letters to be reordered.
     * @param randGen A random number generator.
     * @return The letters that have been randomly ordered.
     */
    public static String reorderLetters(String word, Random randGen) {
        char[] characters = new char[word.length()];
        for (int i = 0; i < word.length(); ++i) {
            characters[i] = word.charAt(i);
        }

        for (int k = 0; k < 4; ++k) {
            int index1 = randGen.nextInt(word.length());
            int index2 = randGen.nextInt(word.length());
            char temp = characters[index1];
            characters[index1] = characters[index2];
            characters[index2] = temp;
        }
        String reordered = new String(characters);
        System.out.println(reordered);

        return reordered;
    }

    /**
     * This returns a string containing the char ch, count times. For example calling with 'a', 5
     * would return: "aaaaa"
     *
     * @param ch    The character to repeat.
     * @param count The number of the character.
     * @return A string with count number of ch.
     */
    public static String charToString(char ch, int count) {
        return null; //TODO
    }

    /**
     * Returns (does not print out) a string showing the words that have been guessed and dashes (-)
     * for the letters of the words not yet guessed.
     * <p>
     * Example wordSet: ago,  now,   own,  wagon guessed: true, false, true, false Returned string:
     * "ago\n---\nown\n-----\n"
     * <p>
     * Note: Do not duplicate code. Remember to call charToString.
     *
     * @param wordSet The set of words to be guessed.
     * @param guessed Which words have been guessed.
     * @return A string showing the state of the guesses.
     */
    public static String show(ArrayList<String> wordSet, boolean[] guessed) {
        return null; //TODO
    }

    /**
     * Picks the first unguessed word to show. Updates the guessed array indicating the selected
     * word is shown.
     * <p>
     * Example wordSet: ago,  now,   own,  wagon guessed: true, false, true, false Returned string:
     * "now" guessed (after method call): true, true, true, false
     *
     * @param wordSet The set of words.
     * @param guessed Whether a word has been guessed.
     * @return The word to show or null if all have been guessed.
     */
    public static String pickWordToShow(ArrayList<String> wordSet, boolean[] guessed) {
        return null; //TODO
    }

    /**
     * Looks for guess in wordSet. If found then updates the guessed array at the corresponding
     * index to true. Returns whether the guess was found or not.
     *
     * @param wordSet The set of words.
     * @param guessed The boolean array parallel with wordSet indicating if a word has been guessed
     *                or not.
     * @param guess   The word to look for in wordSet.
     * @return Whether the guess was found in the wordSet.
     */
    public static boolean wordMatches(ArrayList<String> wordSet, boolean[] guessed, String guess) {
        return false; //TODO
    }

    /**
     * Determines if the all the elements in the guessed array are true.
     *
     * @param guessed Which words have been guessed.
     * @return true, if all the words have been guessed, false otherwise.
     */
    public static boolean wordSetComplete(boolean[] guessed) {
        return false; //TODO
    }

    /**
     * This is the main program loops, prompts for user input and prints to the console. For exact
     * messages and output see the output examples in zyBooks.
     * <p>
     * Algorithm: Initialization and Welcome Note: First wordSet is the 1st line in the file. The
     * words sets are presented in the order in the file. Game loop ("q" quits) Load the next word
     * set (the first time use first set) from file "sets50.txt" If file not found quit with message
     * "Error: unable to read from <filename>", with <filename> replaced with the filename. Remove
     * the first word from the word set, that is the keyword. Reorder the letters of the keyword
     * (reorderLetters) Create a boolean array, parallel to the word set, to indicate which words
     * have been guessed and which have not. Word set loop (guessing all words or quitting exits)
     * Print out the words that have been guessed and dashes for those that haven't (show). Prompt
     * for input (s to show a word and q to quit), see example If "s" then pick word to show
     * (pickWordToShow) and print "showing: " + word If "q" then quit Otherwise, check if word
     * matches (wordMatches) or print "not in my list: " + word If all words are guessed
     * (wordSetComplete) then print "Congratulations! ..." and increment word set, and word set loop
     * is now complete. When game loop complete (quit), then print "Thanks for playing Word
     * Detective!"
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randGen = new Random(876);
        final String WORD_SET_FILE = "sets50.txt";

        System.out.println("Welcome to Word Detective!");

        //see algorithm in method header ...


        System.out.println("Thanks for playing Word Detective!");
        input.close();
    }
}
