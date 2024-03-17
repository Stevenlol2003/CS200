import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public class GroceryFile {
    public static void main(String[] args) {
        ArrayList<Integer> amounts = new ArrayList<>(Arrays.asList(2, 4, 8, 30, 6, 10, 3, 2, 1));
        ArrayList<String> items = new ArrayList<>(Arrays.asList("onions", "green peppers", "diet " +
                "coke", "eggs", "garlic", "yogurt", "lemons", "milk", "cheese"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        String fileName = scan.nextLine();


        try {
            makeGroceryFile(fileName, amounts, items);
        }
        catch (FileNotFoundException e){
            System.out.print("Caught FileNotFoundException: " + e.getMessage());
        }
        //TODO: call the makeGroceryFile method and catch and print an exception that may be
        // thrown with:
        //                 System.out.print("Caught FileNotFoundException: " + e.getMessage());

    }

    /**
     * Opens a file and writes the grocery list inside using a PrintWriter
     *
     * @param fileName the name of the file to be created
     * @param amounts  the amount of each item in the grocery list
     * @param items    the name of the products in the grocery list
     * @throws FileNotFoundException if unable to open fileName to write
     */
    public static void makeGroceryFile(String fileName, ArrayList<Integer> amounts,
                                       ArrayList<String> items) throws FileNotFoundException {
        File myFile = new File(fileName);
        PrintWriter writer = null;

        writer = new PrintWriter(myFile);
        for (int i = 0; i < amounts.size(); ++i) {
            writer.println(amounts.get(i) + " " + items.get(i));
        }
        writer.close();
    }
}
