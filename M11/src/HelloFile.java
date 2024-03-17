import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class HelloFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file name:");

        String fileName = input.nextLine();

        File myFile = new File(fileName);
        PrintWriter writer = null;
        boolean validFileName = true;
        try {
            writer = new PrintWriter(myFile);
        } catch (IOException e) {
            validFileName = false;
            System.out.println("Exception occurred: PrintWriter failed");
        }

        // TODO: Create a PrintWriter
        // TODO: Get user input using Scanner

        String yourInput;
        boolean validInput = false;
        if (validFileName) {
            do {
                System.out.println("Enter something to write in " + fileName + ":");
                yourInput = input.nextLine();
                if (!yourInput.equals("")) {
                    validInput = true;
                }
            } while (!validInput);
            writer.print(yourInput.trim());
            writer.close();
        }
        // TODO: Write valid user input to the PrintWriter, catch any exceptions

    }
}