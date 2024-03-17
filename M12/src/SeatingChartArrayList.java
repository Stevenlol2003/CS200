import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SeatingChartArrayList {

    /**
     * The main method should prompt the user to input two numbers corresponding to the row and
     * column of their seat choice. This choice is then compared to the initial seating chart and
     * updated if the seat is available. Then user is then informed of the result (whether the seat
     * is successfully reserved or already taken).
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //You may assume the seating chart is rectangular and at least 1x1
        ArrayList<ArrayList<Character>> seating = getSeatingChart();

        int userRow = 0;
        int userColumn = 0;

        //Print seating chart.
        System.out.println("Welcome to seat selector.\n");
        System.out.print(createChart(seating));

        //Prompt user for inputs.
        System.out.println("Please select a row (1-" + seating.size() + "): ");
        userRow = scnr.nextInt();

        System.out.println("Please select a column (1-" + seating.get(0).size() + "): ");
        userColumn = scnr.nextInt();

        //Check user's inputs against seating chart.
        if (seating.get(userRow - 1).get(userColumn - 1) == ' ') {
            System.out.println("Seat " + userRow + "," + userColumn + " is now reserved.");
            seating.get(userRow - 1).set(userColumn - 1, 'x');
        } else {
            System.out.println("Seat " + userRow + "," + userColumn + " is already taken.");
        }

        //Print updated seating chart.
        System.out.print(createChart(seating));

        scnr.close();
    }

    /**
     * This method returns a string with the given seating chart. The row and column numbers are
     * also shown. An example is provided in the assignment and test cases. You may assume the
     * chartInput argument is rectangular (all rows have the same number of seats).
     *
     * @param chartInput the seating chart which has already been created
     * @return A string containing the whole chart.
     */
    public static String createChart(ArrayList<ArrayList<Character>> chartInput) {
        String chart = "";
        for (int k = 0; k < chartInput.get(0).size(); ++k) {
            chart += "  " + (k + 1);
        }
        chart += "\n";

        for (int i = 0; i < chartInput.size(); ++i) {
            chart += i + 1;
            for (int j = 0; j < chartInput.get(i).size(); ++j) {
                chart += "[" + chartInput.get(i).get(j) + "]";
            }
            chart += "\n";
        }
        return chart;  //TODO return the whole chart as a string.
    }

    /**
     * Creates a seating chart and randomly assigns the spaces filled.
     *
     * @return The 2-dimensional arraylist containing the seating chart.
     */
    public static ArrayList<ArrayList<Character>> getSeatingChart() {
        Random rand = new Random();
        int rows = rand.nextInt(10) + 1;
        int columns = rand.nextInt(10) + 1;
        ArrayList<ArrayList<Character>> seats = new ArrayList<>();
        for (int row = 0; row < rows; ++row) {
            ArrayList<Character> aRow = new ArrayList<>();
            for (int col = 0; col < columns; ++col) {
                if (rand.nextBoolean()) {
                    aRow.add('x');
                } else {
                    aRow.add(' ');
                }
            }
            seats.add(aRow);
        }
        return seats;
    }
}
