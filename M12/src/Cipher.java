import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.FileInputStream;

/**
 * This contains a program to encrypt or decrypt a message. This is a substitution cipher where
 * plain characters are substituted for alternatives (cipher) and the reverse substitution to obtain
 * the plain characters.
 * <p>
 * The key is composed of two parallel strings with each having unique symbols and both having the
 * same length.  The key is read from a file and can be used to either encrypt or decrypt a message.
 *  Example key file containing 2 lines where each key begins after the first ':' in the line. The
 * cipher key is always on line 1 and the plain is always on line 2.
 * cipher:dc!fghijklmpqrtnosuvwxyz. :e-ba plain :abcdefghijklmnopqrstuvwxyz. :!-
 * <p>
 * The plaintext message: hello world! would be encrypted as: jgppteytspfb
 * <p>
 * The encryption algorithm is: for each symbol in the plaintext message, find the index of the
 * symbol in the plain key, and use that index to find the corresponding symbol in the cipher key to
 * use in the encrypted message.
 * <p>
 * The decryption algorithm is the same except find each encrypted symbol in the cipher and the
 * corresponding character in the plain key to get the plain text back.
 *
 * @author Steven Ren
 */
public class Cipher {

    /**
     * key indexes
     */
    static final int PLAIN_INDEX = 0;
    static final int CIPHER_INDEX = 1;

    /**
     * Reads the cipher and plain keys from the specified file and returns them in the array at the
     * indexes specified by the PLAIN_INDEX and CIPHER_INDEX. You should ignore case and whitespace
     * on the ends when checking the fileName, i.e. "key.txt" and "    KEY.Txt" would both open the
     * same file, "key.txt".
     * <p>
     * If the fileName is null or "" then print out "Invalid file name" and return null.
     * <p>
     * If the file doesn't exist or a FileNotFoundException is thrown then print the following
     * message and return null. System.out.println("Error, File Not Found: " + fileName);
     * <p>
     * If there aren't two lines to read from the file then the following error message should be
     * printed and null returned. This may check using hasNextLine() or by catching an exception.
     * System.out.println("Error, Unable to read two lines from " + fileName);
     * <p>
     * Example good key file: Contains 2 lines where each key begins after the first ':' in the
     * line. Assume the cipher key is always on line 1 and the plain is always on line 2. cipher
     * :dc!fghijklmpqrtnosuvwxyz. :e-ba plain :abcdefghijklmnopqrstuvwxyz. :!-
     *
     * @param fileName The name of the key file.q
     * @return An array with the PLAIN_INDEX containing the plain key and the CIPHER_INDEX
     * containing the cipher key read from the file.
     */
    public static String[] getKey(String fileName) {
        FileInputStream fileStream = null;
        Scanner inFS = null;

        if (fileName == null || fileName.equals("")) {
            System.out.println("Invalid file name");
            return null;
        }

        try {
            fileName = fileName.trim().toLowerCase();
            fileStream = new FileInputStream(fileName);
            inFS = new Scanner(fileStream);
        } catch (FileNotFoundException e) {
            System.out.println("Error, File Not Found: " + fileName);
            return null;
        }


        if (!inFS.hasNextLine()) {
            System.out.println("Error, Unable to read two lines from " + fileName);
            return null;
        }
        if (inFS.hasNextLine()) {
            inFS.nextLine();
            if (!inFS.hasNextLine()) {
                System.out.println("Error, Unable to read two lines from " + fileName);
                return null;
            }
        }

        FileInputStream fileStream2 = null;
        Scanner input = null;
        try {
            fileName = fileName.trim().toLowerCase();
            fileStream2 = new FileInputStream(fileName);
            input = new Scanner(fileStream2);
        } catch (FileNotFoundException e) {
            System.out.println("Error, File Not Found: " + fileName);
            return null;
        }
        String cipher = input.nextLine();
        String plain = input.nextLine();
        /**
        String[] cipherKey = cipher.split(":");
        String[] plainKey = plain.split(":");
        String[] keyIndexes = new String[2];
        keyIndexes[PLAIN_INDEX] = plainKey[1] + ":" + plainKey[2];
        keyIndexes[CIPHER_INDEX] = cipherKey[1] + ":" + plainKey[2];
        **/
        String[] keyIndexes = new String[2];
        String plainKey = plain.substring(plain.indexOf(":") + 1);
        String cipherKey = cipher.substring(cipher.indexOf(":") + 1);
        keyIndexes[PLAIN_INDEX] = plainKey;
        keyIndexes[CIPHER_INDEX] = cipherKey;
        return keyIndexes;
    }

    /**
     * This validates the 2 strings of the key, plain and cipher. Each string should only have
     * unique characters and must be the same length. Additionally, case will not be enough for
     * uniqueness, i.e. 'a' and 'A' are considered the same character.
     *
     * @param key has 2 strings, at PLAIN_INDEX is the plain key and at CIPHER_INDEX is the cipher
     *            key.
     * @return -1 if key or either string is null and print "The key is null." -2 when the strings
     * aren't the same length and print "The keys are not the same length." -3 if the characters in
     * the plain key string are not unique and print at least one duplicate character. -4 if the
     * characters in the cipher key string are not unique and print at least one duplicate
     * character. Otherwise, returns 0.
     */
    public static int checkKey(String[] key) {
        int returnValue = 0;
        if (key == null) {
            return -1;
        } else if (key[PLAIN_INDEX] == null) {
            return -1;
        } else if (key[CIPHER_INDEX] == null) {
            return -1;
        } else if (!(key[PLAIN_INDEX].length() == key[CIPHER_INDEX].length())) {
            System.out.println("The keys are not the same length.");
            return -2;
        }
        for (int i = 0; i < key[PLAIN_INDEX].length(); ++i) {
            for (int j = i + 1; j < key[PLAIN_INDEX].length(); ++j) {
                if (key[PLAIN_INDEX].charAt(i) == key[PLAIN_INDEX].charAt(j)) {
                    System.out.println(key[PLAIN_INDEX].charAt(i));
                    return -3;
                }
            }
        }
        for (int i = 0; i < key[CIPHER_INDEX].length(); ++i) {
            for (int j = i + 1; j < key[CIPHER_INDEX].length(); ++j) {
                if (key[CIPHER_INDEX].charAt(i) == key[CIPHER_INDEX].charAt(j)) {
                    System.out.println(key[CIPHER_INDEX].charAt(i));
                    return -4;
                }
            }
        }
        return returnValue;
    }

    /**
     * Finds the index of the plainSymbol in the plain key, and returns the symbol at the same index
     * in the cipher key.
     *
     * @param key         The key to translate between plain text and encrypted text.
     * @param plainSymbol The symbol to find in the plain key.
     * @return The symbol in the cipher key corresponding to the rotated index of the plainSymbol in
     * the plain key.  If the plain symbol isn't found return the plain symbol.
     */
    public static char findCipherSymbol(String[] key, char plainSymbol) {
        int index = key[PLAIN_INDEX].indexOf(plainSymbol);
        if (index >= 0) {
            return key[CIPHER_INDEX].charAt(index);
        } else {
            return plainSymbol;
        }
    }

    /**
     * Finds the index of the cipherSymbol in the cipher key, and returns the symbol at the same
     * index in the plain key.
     *
     * @param key          The key to translate between plain text and encrypted text.
     * @param cipherSymbol The symbol to find in the cipher key.
     * @return The symbol in the plain key corresponding to the rotated index of the cipherSymbol in
     * the cipher key.  If the cipher symbol isn't found return the cipher symbol.
     */
    public static char findPlainSymbol(String[] key, char cipherSymbol) {
        int index = key[CIPHER_INDEX].indexOf(cipherSymbol);
        if (index >= 0) {
            return key[PLAIN_INDEX].charAt(index);
        } else {
            return cipherSymbol;
        }
    }

    /**
     * This returns an encrypted message by translating each character in the plain message using
     * the findCipherSymbol method.
     *
     * @param key          The key to translate between plain text and encrypted text.
     * @param plainMessage The plain text to translate into an encrypted message.
     * @return The encrypted message.
     */
    public static String encrypt(String[] key, String plainMessage) {
        String encrypted = "";
        for (int i = 0; i < plainMessage.length(); ++i) {
            char ch = plainMessage.charAt(i);
            encrypted += findCipherSymbol(key, ch);
        }
        return encrypted;
    }

    /**
     * This returns a plain message by translating each character in the encrypted message using the
     * findPlainSymbol method.
     *
     * @param key              The key to translate between plain text and encrypted text.
     * @param encryptedMessage The encrypted message to translate into plain text.
     * @return The plain text.
     */
    public static String decrypt(String[] key, String encryptedMessage) {
        String plaintext = "";
        for (int i = 0; i < encryptedMessage.length(); ++i) {
            char ch = encryptedMessage.charAt(i);
            plaintext += findPlainSymbol(key, ch);
        }
        return plaintext;
    }

    /**
     * This prompts the user for a key filename, and whether to encrypt or decrypt a message. Then
     * it does the encryption or decryption and outputs the result before prompting for another
     * operation.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the key file: ");
        String keyFilename = input.nextLine();
        String[] key = getKey(keyFilename);
        if (checkKey(key) != 0) {
            return;
        }
        boolean finished = false;
        do {
            System.out.print("Enter e)ncrypt d)ecrypt or q)uit: ");
            String choice = input.nextLine().trim().toLowerCase();
            switch (choice) {
                case "e":
                    System.out.print("Enter plain message: ");
                    System.out.println("encrypted message:" + encrypt(key, input.nextLine()));
                    break;

                case "d":
                    System.out.print("Enter encrypted message: ");
                    System.out.println("plaintext message:" + decrypt(key, input.nextLine()));
                    break;

                case "q":
                    finished = true;
                    break;

                default:
                    break;
            }
        } while (!finished);
    }
}
