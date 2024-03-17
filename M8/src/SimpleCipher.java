import java.util.Arrays;

public class SimpleCipher 
{

    /**
     * Encrypts an array based on the given key.
     *
     * The encryption will be a simple XOR cipher. Each element in the toEnc 
     * array is XOR'd (^) with the corresponding element in the key array. If the
     * key is shorter than toEnc, then repeatedly traverse the key as needed 
     * in order to encode each element of toEnd.
     * Hint: This is best accomplished by using the mod (%) operator.
     *
     * Example: int[] toEnc = {'H', 'e', 'l', 'l', 'o'} and
     *          int[] key = {'f', 'o', 'o'} gives
     *          [46, 10, 3, 10, 0] as
     *          'H' ^ 'f' = 46
     *          'e' ^ 'o' = 10
     *          'l' ^ 'o' = 3
     *          'l' ^ 'f' = 10
     *          'o' ^ 'o' = 0
     *
     * @param toEnc The integer array to encrypt.
     * @param key The key used by the cipher for encryption the array.
     * @return A new int array containing the encryption of toEnc with key.
     */
    public static int[] encrypt(int[] toEnc, int[] key) {
        int[] encrypted = new int[toEnc.length];
            for (int i = 0; i < toEnc.length; ++i) {
                int traverseKey = i % key.length;
                encrypted[i] = toEnc[i] ^ key[traverseKey];
            }

        return encrypted;
    }

    /**
     * Decrypts an array based on a given key.
     *
     * The simple cipher described in the encrypt method uses XOR for the 
     * encryption. In this method, we want to decrypt the array. That means we
     * need to do the inverse operation from the encryption. Interestingly, the
     * inverse operation of XOR is XOR. That is, 7^4 = 3 and 3^4 = 7. Hence, we 
     * can use the encrypt method to decrypt.
     *
     * Call the encrypt method with the appropriate parameters... 
     * DON'T DUPLICATE CODE! 
     *
     * @param toDec The integer array to decrypt.
     * @param key The key used by the cipher for encryption the array.
     * @return A new int array containing the decryption of toDec with key.
     */
    public static int[] decrypt(int[] toDec, int[] key) {
            int[] decrypted = new int[toDec.length];
            for (int i = 0; i < toDec.length; ++i) {
                int traverseKey = i % key.length;
                decrypted[i] = toDec[i] ^ key[traverseKey];
            }

        return decrypted;
    }

    /** 
     * A utility method to convert (with possible loss of precision) from an int
     * array to a char array.
     *
     * This method create a new char array of the same length as intArr. Then, element i of 
     * intArr should be stored as a char in the new array at index i for all i of intArr.
     * That is, each element in the returned array should correspond with the same index on 
     * the original array.
     *
     * @param intArr The int array to convert.
     * @return A new char array with the converted values. If intArr is null, 
     *         this method should return null.
     */
    public static char[] toCharArr(int[] intArr) {
        boolean hasNoNull = true;
        if (intArr == null) {
            return null;
        }
        char[] charArr = new char[intArr.length];

            for (int i = 0; i < intArr.length; ++i) {
                charArr[i] = (char) intArr[i];
            }

        return charArr;
    }

    /** 
     * A utility method to convert from a char array to an int array.
     *
     * This method create a new int array of the same length as charArr. Then, element i of 
     * charArr should be stored as an int in the new array at index i for all i of charArr.
     * That is, each element in the returned array should correspond with the same index on 
     * the original array.
     *
     * @param charArr The char array to convert.
     * @return A new int array with the converted values. If charArr is null, 
     *         this method should return null.
     */    
    public static int[] toIntArr(char[] charArr) {

        if (charArr == null) {
            return null;
        }
        int[] intArr = new int[charArr.length];

            for (int i = 0; i < charArr.length; ++i) {
                intArr[i] = (int) charArr[i];
            }

        return intArr;
    }

    /**
     * This zyBooks only does unit tests of your methods. So, use the main method 
     * to test your methods.
     */
    public static void main(String[] args) {
        // The toIntArr and the toCharArr may be useful in testing your encrypt/decrypt methods
        int arr[] = {'H', 'e', 'l', 'l', 'o'};
        int key[] = {'f', 'o', 'o'};
        System.out.println(Arrays.toString(encrypt(arr, key))); // Should be [46, 10, 3, 10, 0]
        System.out.println(toCharArr(encrypt(encrypt(arr, key), key))); // Should be Hello
        System.out.println(toCharArr(decrypt(encrypt(arr, key), key))); // Should be Hello
    }
}
