import java.util.Arrays;

public class RemoveEvens {

	public static int[] removeEvens(int [] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] % 2 == 1 || nums[i] % 2 == -1) {
				num++;
			}
		}
		int[] newNums = new int[num];
		num = 0;
		int j = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] % 2 == 1 || nums[i] % 2 == -1) {
				newNums[j] = nums[i];
				++j;
			}
		}

		return newNums;
	}

	public static void main(String[] args) {

		int [] input = {1,2,3,4,5,6,7,8,9};
		int [] result = removeEvens(input);

		// Helper method Arrays.toString() converts int[] to a String
		System.out.println(Arrays.toString(result)); // Should print [1, 3, 5, 7, 9]
	}
}
