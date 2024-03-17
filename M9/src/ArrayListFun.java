import java.util.ArrayList;

public class ArrayListFun {

    /**
     * Counts the number of instances of a values in list, that lie within a given range. Returns
     * null if list is null.
     *
     * @param list
     * @param rangeLeft
     * @param rangeRight
     * @return the number of Integer occurrences in list that lie within the given range (both
     * values inclusive)
     */
    public static Integer countOccurencesInRange(ArrayList<Integer> list, int rangeLeft,
												 int rangeRight) {
        if (list == null) {
            return null;
        }
		else if (rangeLeft > rangeRight) {
            return null;
        }
        int count = 0;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) >= rangeLeft && list.get(i) <= rangeRight) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if the two vectors are orthogonal or not Returns null if list is null. Example :
     * for a
     * = [1, 1, -1, -1] and b = [-1, -1, -1, -1, the running sum will be a[0]*b[0] + a[1]*b[1] +
     * a[2]*b[2] + a[3]*b[3] = -1 -1 + 1 + 1 = 0. Thus, the vectors are orthogonal.
     *
     * @param a
     * @param b
     * @return true or false depending on whether the two vectors are orthogonal or not.
     */
    public static Boolean isOrthogonal(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null) {
            return null;
        } else if (b == null) {
            return null;
        }
		if (a.size() != b.size()) {
			return null;
		}
        boolean orthogonal = true;
        int sum = 0;
        for (int i = 0; i < a.size(); ++i) {
            int multiply = a.get(i) * b.get(i);
            sum += multiply;
        }
        if (sum != 0) {
            orthogonal = false;
        }
        return orthogonal;
    }

    /**
     * Returns true if the input is formed by repeated concatenation of the pattern. Returns
     * null if
     * list is null.
     *
     * @param input
     * @param pattern
     * @return true if the input can be formed by repeated concatenation of the pattern.
     */
    public static Boolean isRepeated(ArrayList<Character> input, ArrayList<Character> pattern) {
        if (input == null) {
            return null;
        } else if (pattern == null) {
            return null;
        }
        boolean repeated = false;
        pattern.add(pattern.get(0));
        pattern.add(pattern.get(1));

        if (input.equals(pattern)) {
            repeated = true;
        }
        return repeated;
    }

    /**
     * Returns whether all the integers in the input list are perfect squares. Hint: Use Math.sqrt
     * and Math.floor function to find the square root of the number has a non-zero fractional
     * part.
     *
     * @param input a list of integers.
     * @return true if all the integers in the input are perfect squares, null if the list is null.
     */
    public static Boolean isPerfectSquare(ArrayList<Integer> input) {
        if (input == null) {
            return null;
        }
        boolean perfectSquare = true;
		for (int i = 0; i < input.size(); ++i) {
			if (Math.sqrt(input.get(i)) != Math.floor(Math.sqrt(input.get(i)))) {
				perfectSquare = false;
			}
		}
        return perfectSquare;
    }
}