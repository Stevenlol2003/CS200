public class Marbles {
    public static void main(String[] args) {
        testWordsForMarbles();
    }

    public static String wordsForMarbles(int numberOfMarbles) {
        if (numberOfMarbles < 0) {
            return "owe marbles";
        } else if (numberOfMarbles > 7) {
            return "a lot of marbles";
        } else {
            switch (numberOfMarbles) {
                case 0:
                    return "no marbles";
                case 1:
                    return "a marble";
                case 2:
                    return "two marbles";
                case 3:
                    return "a few marbles";
                default:
                    return "some marbles";
            }
        }
    }

    public static void testWordsForMarbles() {
        boolean error = false;

        if (!wordsForMarbles(1).equals("a marble")) {
            error = true;
            System.out.println("1 should be 'a marble'");
        }
        if (!wordsForMarbles(2).equals("two marbles")) {
            error = true;
            System.out.println("2 should be 'two marbles'");
        }
        if (!wordsForMarbles(3).equals("a few marbles")) {
            error = true;
            System.out.println("3 should be 'a few marbles'");
        }
        if (!wordsForMarbles(4).equals("some marbles")) {
            error = true;
            System.out.println("4 should be 'some marbles'");
        }
        if (!wordsForMarbles(5).equals("some marbles")) {
            error = true;
            System.out.println("5 should be 'some marbles'");
        }
        if (!wordsForMarbles(6).equals("some marbles")) {
            error = true;
            System.out.println("6 should be 'some marbles'");
        }
        if (!wordsForMarbles(7).equals("some marbles")) {
            error = true;
            System.out.println("7 should be 'some marbles'");
        }
        if (!wordsForMarbles(0).equals("no marbles")) {
            error = true;
            System.out.println("0 should be 'no marbles'");
        }
        if (!wordsForMarbles(-1).equals("owe marbles")) {
            error = true;
            System.out.println("-1 should be 'owe marbles'");
        }
        if (!wordsForMarbles(8).equals("a lot of marbles")) {
            error = true;
            System.out.println("8 should be 'a lot of marbles'");
        }

        //This testing method is to help verify that wordsForMarbles works
        //correctly.
        //VERIFY the above test cases are reasonable and correct.
        //ADD additional test cases to meet the requirements specified in the lab.
        //IF the test cases indicate errors in the wordsForMarbles method,
        //then fix the wordsForMarbles method and rerun the tests.

        if (error) {
            System.out.println("testWordsForMarbles failed");
        } else {
            System.out.println("testWordsForMarbles passed");
        }
    }
}