import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class is the entire program that prompts the user for a file name.
 * The file is opened, and its contents are printed out.
 *
 * @author Steven Ren
*/
public class ListReader {

    /**
     * This method takes in as input a file name string
     * and reads from the file, returning the contents as a string.
     *
     * @param fileName the file name.
     * @throws IOException This method may throw if the file can't be opened or read from.
     * @return a string containing the contents of the file.
     */
    public static String readFile(String fileName) throws IOException {
        FileInputStream fileStream = new FileInputStream(fileName);
        Scanner inFS = new Scanner(fileStream);
        String printOut = "";
        String year = "";
        while (inFS.hasNextLine()) {
            year = inFS.nextLine();
            printOut += year + "\n";
        }
        fileStream.close();
        return printOut;
        //TO DO: create a new File or FileInputStream using the fileName
        //TO DO: create an instance of Scanner to read from the File or FileInputStream you created, the exception
        //       that may be thrown shouldn't be caught in this method
        //hint: Refer to Module 11 | Reading a File or zyBooks for guidance

        //TO DO: Use a loop to read each line in your file and concatenate it to a string.
        //     Remember to append "\n" since Scanner nextLine() will automatically remove the "\n" when it is read.

        //TO DO: Close the Scanner
    }

    /**
     * This main method does the input and output and calls another
     * method to do open and print a file's content.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a valid file name: ");
        String fileName = input.nextLine();

        System.out.println("Opening file " + fileName + ".");
        try {
            System.out.print(readFile(fileName));
        } catch (IOException e) {
            System.out.print("Exception caught: " + fileName+  " (No such file or directory)");
        }



        //TO DO: prompt the user for a file name and read using Scanner

        //System.out.println("Opening file " + [yourFileNameHere] + ".");

        //TO DO: Call your readFile method and print (not println!) the returned string.
        //To DO: Catch any IOExceptions and print out with:
        //       System.out.print("Exception caught: " + e.getMessage());

    }
}