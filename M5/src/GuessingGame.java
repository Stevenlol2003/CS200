import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random random = new Random(Config.SEED);
        int randomNum = random.nextInt(4) + 1;

        System.out.println("Guess a number between 1 and 5");
        int yourGuess = scnr.nextInt();
        if (yourGuess > randomNum) {
            System.out.println("That's too high");
            System.out.println("Guess again!");
            yourGuess = scnr.nextInt();
            if (yourGuess == randomNum) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose! It was " +randomNum);
            }
        }

        else if (yourGuess < randomNum) {
            System.out.println("That's too low");
            System.out.println("Guess again!");
            yourGuess = scnr.nextInt();
            if (yourGuess == randomNum) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose! It was " +randomNum);
            }
        }

        else if (yourGuess == randomNum) {
            System.out.println("You win!");
        }

    }
}