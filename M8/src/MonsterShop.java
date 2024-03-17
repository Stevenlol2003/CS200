import java.util.Scanner;

public class MonsterShop {

    /**
     * This method is for buying a monster. Buying a monster should set the corresponding entry in availableMonsters to null
     * and adds the monster to myMonsters.
     *
     * If a monster is not available, print "MONSTER_NAME is not available." and return -1.
     * MONSTER_NAME should be substituted with the name of the monster.
     *
     * If a monster is available, print "MONSTER_NAME costs COST coins." where MONSTER_NAME is the name of the monster
     * and COST is the cost of the monster.
     * If the user has enough coins to buy the monster then print "Yay! You had enough coins to buy MONSTER_NAME." and
     * return the cost. MONSTER_NAME should be substituted with the name of the monster.
     * Else, if the user does not have enough coins, print "You don't have enough coins to buy this monster."
     * and return -1.
     *
     * If monster, myMonsters, allMonsters, or costs is null, return -1 before doing ANYTHING else in the method.
     *
     * @param savings - the number of coins in the user's savings
     * @param monster - name of monster the user wants to buy
     * @param myMonsters - array of monsters user has purchased
     * @param availableMonsters - array of all monsters available for purchase
     * @param costs - array of costs for monsters
     */
    public static int buyMonster(int savings, String monster, String[] myMonsters, String[] availableMonsters, int[] costs) {
        // @TODO: Implement me
        return -1;
    }

    /**
     * This method is for getting a monster's cost.
     * Search through the array starting at index 0 until you find an index where the element is not null and
     * the element is equal to the monster you're looking for.
     * Return the element at this same index in the costs array.
     * If the monster is not found in monsters, return -1.
     *
     * If monster, monsters, or costs is null, return -1.
     *
     * @param monster - monster to get cost of
     * @param monsters - the array of monsters
     * @param costs - the array of costs for monsters
     * @return int - cost for monster
     */
    public static int getMonsterCost(String monster, String[] monsters, int[] costs) {
        // @TODO: Implement me
        return -1;
    }

    /**
     * Print all monsters in the user's collection.
     *
     * Every non-null element should be printed with a space in between each element.
     * There is a space and newline printed at the end.
     * (See assignment page for example output)
     *
     * If myMonsters is null, return before doing ANYTHING else in the method.
     *
     * @param myMonsters - monsters the user has purchased
     */
    public static void printCollection(String[] myMonsters) {
        // @TODO: Implement me
    }

    /**
     * Print all monsters available for purchase.
     *
     * Every non-null element should be printed with a space in between each element.
     * There is a space and newline printed at the end.
     * (See assignment page for example output)
     *
     * If availableMonsters is null, return before doing ANYTHING else in the method.
     *
     * @param availableMonsters - monsters available for purchase
     */
    public static void printAvailableMonsters(String[] availableMonsters) {
        // @TODO: Implement me
    }

    /**
     * This is the main method.
     * Config.MONSTERS is an array provided in Config.java, full of cool monsters to buy!
     * Create a new array the same size as Config.MONSTERS, then copy all the entries from Config.MONSTERS
     * into your new array. (Already done for you)
     *
     * Welcome your user to the shop, and start your prompt loop.
     *
     * Every loop does the following (in this order):
     * - Print the monsters available for purchase
     * - Display the number of coins the user currently has by printing "You currently have SAVINGS coins in your pocket.".
     * SAVINGS should be replaced with the current savings balance.
     * - Prompt the user for the name of a monster to buy by printing "Enter the name of the monster you'd like to buy:"
     * - Print the user's collection
     *
     * If the user inputs "exit" then print "Thanks for visiting the Monster Shop!" with no newline and exit the loop.
     *
     * (See assignment page for example output)
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String[] monsters = new String[Config.MONSTERS.length];
        int savings = Config.INITIAL_SAVINGS;
        // load the monsters
        for (int i = 0; i < Config.MONSTERS.length; i++) {
            monsters[i] = Config.MONSTERS[i];
        }
        String[] myMonsters = new String[Config.MONSTERS.length];

        // @TODO: Print welcome message and add main loop
        System.out.println("Welcome to the Monster Shop!");
        System.out.println();


        System.out.println("You currently have 100 coins in your pocket.");

        System.out.println("Enter the name of the monster you'd like to buy:");
        String buyMonster = scnr.next();

    }
}
