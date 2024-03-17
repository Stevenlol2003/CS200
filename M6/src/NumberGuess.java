import java.util.Random;
import java.util.Scanner;
public class NumberGuess{
    public static void main(String[] args){
        Random rand = new Random(Config.SEED);
        Scanner input = new Scanner(System.in);
        
        int evenNumber = (rand.nextInt(100/2) + 1) * 2;
        //System.out.println(evenNumber);

        int numGuess = 0;
        System.out.print("Please make an even number guess between 1 and 100: ");
        int yourGuess = input.nextInt();
        ++numGuess;

        int lowerBound = 1;
        int upperBound = 100;

        while (yourGuess != evenNumber) {
            if ((yourGuess >= lowerBound && yourGuess <= upperBound) && yourGuess % 2 == 0) {
                if (evenNumber > ((upperBound + lowerBound) / 2)) {
                    lowerBound = yourGuess;
                    System.out.print("Please make an even number guess between " + lowerBound
                            + " and " + upperBound + ": ");
                    yourGuess = input.nextInt();
                    ++numGuess;
                }
                else if (evenNumber < ((upperBound + lowerBound) / 2)) {
                    upperBound = yourGuess;
                    System.out.print("Please make an even number guess between " + lowerBound
                            + " and " + upperBound + ": ");
                    yourGuess = input.nextInt();
                    ++numGuess;
                }
            }
            else if (yourGuess % 2 == 1) {
                System.out.print("Please make an even number guess between " + lowerBound
                        + " and " + upperBound + ": ");
                yourGuess = input.nextInt();
                ++numGuess;
            }
            else if (yourGuess > upperBound || yourGuess < lowerBound) {
                System.out.print("Please make an even number guess between " + lowerBound
                        + " and " + upperBound + ": ");
                yourGuess = input.nextInt();
                ++numGuess;
            }
            }
        System.out.print("You won in " + numGuess + " trials!");
        }
    }
