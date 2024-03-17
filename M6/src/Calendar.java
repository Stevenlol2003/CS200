import java.util.Scanner;

/**
 * This class contains the entire program to print out a calendar and find the day of a week for a
 * given month/date/year.
 *
 * @author Steven Ren
 */
public class Calendar {

    /**
     * This prints out a line of the same character for the calendar's header
     *
     * @param headerChar This is a character that will be printed through a loop
     * @param width      This is an integer that represents how many times to print out the
     *                   character
     */
    public static void printCharLine(char headerChar, int width) {
        for (int i = 0; i < width; i++) {
            System.out.print(headerChar);
        }
    }

    /**
     * This returns whether the specified year is a leap year.
     * <p>
     * The algorithm is: Every year that is exactly divisible by four is a leap year, except for
     * years that are exactly divisible by 100, but these centurial years are leap years if they are
     * exactly divisible by 400. For example, the years 1700, 1800, and 1900 are not leap years, but
     * the years 1600 and 2000 are. https://en.wikipedia.org/wiki/Leap_year
     *
     * @param year The year to determine whether it is a leap year.
     * @return true if the year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {

        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }

        } else {
            isLeapYear = false;
        }
        return isLeapYear;
    }

    /**
     * This returns the number of days in the specified month of year.
     *
     * @param month The month to return the number of days.
     * @param year  The year is used for determining whether it is a leap year.
     * @return The number of days in the specified month of the year.
     */
    public static int getDaysInMonth(int month, int year) {
        int daysInMonth = 0;
        switch (month) {
            //31 days
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;

            //30 days
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;

            case 2:  //28 or 29 days
                if (isLeapYear(year)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
        }
        return daysInMonth;
    }

    /**
     * Returns the name of the month, given the number of the month.
     *
     * @param month The month where 1 is January and 12 is December.
     * @return The name of the month.
     */
    public static String getMonthName(int month) {
        String monthStr;
        switch (month) {
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "February";
                break;
            case 3:
                monthStr = "March";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "May";
                break;
            case 6:
                monthStr = "June";
                break;
            case 7:
                monthStr = "July";
                break;
            case 8:
                monthStr = "August";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "October";
                break;
            case 11:
                monthStr = "November";
                break;
            case 12:
                monthStr = "December";
                break;
            default:
                monthStr = "unknown";
                break;
        }
        return monthStr;
    }

    /**
     * This method prints out the calendar's header by printing out a blank character line, then the
     * month and year on a line, then a dash character line, and last the 7 days of the week.
     *
     * @param month
     * @param year
     */
    public static void printHeader(String month, int year) {
        final int TOTAL_WIDTH = 28;
        final char MONTH_HEADER_LINE_CHAR = '-';

        System.out.println();
        String it = month + " " + year;
        int spacesBefore = (TOTAL_WIDTH - it.length()) / 2;
        printCharLine(' ', spacesBefore);
        System.out.println(it);
        printCharLine(MONTH_HEADER_LINE_CHAR, TOTAL_WIDTH);
        System.out.println();
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * This prints out the days of the month in the correct day of the week column.
     *
     * @param startDay    The day of the week of the 1st day of the month, where 0 is Sunday, 1 is
     *                    Monday.
     * @param daysInMonth The number of days in the month.
     */
    public static void printMonthDays(int startDay, int daysInMonth) {
        final char CHAR_BETWEEN_DAYS = ' ';
        final int DAYS_IN_A_WEEK = 7;
        final int LOWEST_SINGLE_DIGIT_DAY = 1;
        final int HIGHEST_SINGLE_DIGIT_DAY = 9;

        printCharLine(CHAR_BETWEEN_DAYS, startDay * 4);
        for (int day = 1; day <= daysInMonth; day++) {
            if (day >= LOWEST_SINGLE_DIGIT_DAY && day <= HIGHEST_SINGLE_DIGIT_DAY) {
                printCharLine(CHAR_BETWEEN_DAYS, 2);
            } else {
                printCharLine(CHAR_BETWEEN_DAYS, 1);
            }
            System.out.print(day);
            printCharLine(CHAR_BETWEEN_DAYS, 1);
            startDay++;
            if (startDay % DAYS_IN_A_WEEK == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * This method calculates the number of days between the two given dates for the same calendar
     * year
     *
     * @param startingMonth Always 1, for January
     * @param startingDay   Always 1, for first day of month, January 1
     * @param endingMonth   The user inputted month
     * @param endingDay     The user inputted day
     * @param year          The user inputted year
     * @return Returns the number of days between the two given dayes for the same calendar year
     */
    public static int getDays(int startingMonth, int startingDay, int endingMonth, int endingDay,
                              int year) {
        /*
         * This information should be in the method header. It is included here
         * as a comment to provide hints.
         *
         * This method calculates the number of days between the two given dates
         * for the same calendar year
         */

        int difference = 0;
        if (startingMonth == endingMonth) {
            difference = endingDay - startingDay;
            return difference;
        }

        // Add number of days for first month
        difference += getDaysInMonth(startingMonth, year) - startingDay;

        // Add number of days for in-between months
        for (int j = (startingMonth + 1); j < endingMonth; j++) {
            int daysInMonth = getDaysInMonth(j, year);
            difference += daysInMonth;
        }

        // Add number of days for last month
        difference += endingDay;

        return difference;
    }

    /**
     * This method checks for valid month and day inputs by the user, then does math to see what day
     * of the week
     *
     * @param inputtedMonth  The month inputted by the user (1-12, 1-January, 2-February, etc)
     * @param inputtedDay    The day inputted by the user (1-31)
     * @param inputtedYear   The year inputted by the user
     * @param startDayOfWeek The starting day of the week (0-6, 0-Sunday, 1-Monday, etc)
     * @return Returns a String of the starting day of the week
     */
    public static String getStartingDay(int inputtedMonth, int inputtedDay, int inputtedYear,
                                        int startDayOfWeek) {
        String startingDay = " ";

        if (inputtedMonth <= 0 || inputtedMonth > 12 || inputtedDay <= 0 || inputtedDay > 31) {
            return "Invalid User Input";
        }

        // First calculate number of days between start of year and date
        int numDays = getDays(1, 1, inputtedMonth, inputtedDay, inputtedYear);

        // Then do math to what day of week this corresponds to
        int dayOfWeekInt = numDays % 7;
        dayOfWeekInt = (startDayOfWeek + dayOfWeekInt) % 7;

        switch (dayOfWeekInt) {
            case 0:
                startingDay = "Sunday";
                break;
            case 1:
                startingDay = "Monday";
                break;
            case 2:
                startingDay = "Tuesday";
                break;
            case 3:
                startingDay = "Wednesday";
                break;
            case 4:
                startingDay = "Thursday";
                break;
            case 5:
                startingDay = "Friday";
                break;
            case 6:
                startingDay = "Saturday";
                break;
        }

        return startingDay;
    }

    /**
     * First prompts for the year and the day of the week of January 1st and then prompts for any
     * given date (month and day) of that same year that user wants to find day of week for. Prints
     * out day of week for given date and a monthly calendar for given month.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        final char FIRST_MONTH = 1;
        final char LAST_MONTH = 12;
        final int DAYS_IN_A_WEEK = 7;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = input.nextInt();
        System.out.print("Enter day of week of Jan 1 (0-Sunday, 1-Monday, etc): ");
        int startDay = input.nextInt();
        int originalStartDay = startDay;

        System.out.println();
        System.out.println("Lets find the day of a week for any given date on this calendar year!");
        System.out.print("Enter Month of Desired Date (1-Jan, 2-Feb, etc): ");
        int monthOfDate = input.nextInt();
        System.out.print("Enter Day of Desired Date (1-1st of month, 2-2nd of month, etc): ");
        int dayOfDate = input.nextInt();
        System.out.println();
        System.out.println(getMonthName(monthOfDate) + " " + dayOfDate + ", " + year + " is a " + getStartingDay(monthOfDate, dayOfDate, year, originalStartDay));


        for (int month = FIRST_MONTH; month < monthOfDate; ++month) {
            int daysInMonth = getDaysInMonth(month, year);
            startDay = (startDay + daysInMonth) % DAYS_IN_A_WEEK;
        }
        String monthName = getMonthName(monthOfDate);
        printHeader(monthName, year);
        int daysInMonth = getDaysInMonth(monthOfDate, year);
        printMonthDays(startDay, daysInMonth);

    }
}
