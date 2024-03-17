public class PrintArray {
    public static void print(int[][] list) {
        for (int i = 0; i < list.length; ++i) {
            int sum = 0;
            for (int j = 0; j < list[i].length; ++j) {
                System.out.print(list[i][j] + " ");
                sum += list[i][j];
            }
            System.out.println(sum);
        }
    }
}
