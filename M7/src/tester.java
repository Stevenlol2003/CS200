import java.util.Scanner;

public class tester {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int currNum;
        int i;
        int tmp;
        int listLength;

        listLength = scnr.nextInt();

        int[] listNums = new int[listLength];

        for(i = 0; i < listLength; i++){
            currNum = scnr.nextInt();
            listNums[i] = currNum;
        }

        int middle = listLength / 2;
        int tempVal = listNums[middle];
        listNums[middle] = listNums[listLength - 1];
        listNums[listLength - 1] = tempVal;

        for (i = 0; i < listLength; ++i) {
            System.out.print(listNums[i] + " ");
        }
        System.out.println();
    }
}
