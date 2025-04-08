package seedu.healthbud;

/**
 * UI class for the HealthBud application.
 * <p>
 * This class handles all the user interface aspects by providing methods to print messages
 * to the console. It includes methods for displaying greetings, help information, ASCII art,
 * and other status messages.
 */
public class Ui {

    /**
     * New line and indent used for formatting output.
     */
    public static final String NEW_LINE = "\n    ";

    /**
     * Prints a message with indentation.
     *
     * @param message the message to print
     */
    public static void printMessage(String message) {
        System.out.println("    " + message);
    }

    /**
     * Prints the HealthBud ASCII art to the user.
     */
    public static void printHealthBuds() {
        System.out.println(" _   _            _ _   _     ____            _");
        System.out.println("| | | | ___  __ _| | |_| |__ | __ ) _   _  __| |___");
        System.out.println("| |_| |/ _ \\/ _` | | __| '_ \\|  _ \\| | | |/ _` / __|");
        System.out.println("|  _  |  __/ (_| | | |_| | | | |_) | |_| | (_| \\__ \\");
        System.out.println("|_| |_|\\___|\\__,_|_|\\__|_| |_|____/ \\__,_|\\__,_|___/");
    }

    /**
     * Prints the greeting message to the user.
     * <p>
     * This method displays the HealthBud ASCII art followed by a greeting message.
     * </p>
     */
    public static void printGreeting() {
        printHealthBuds();
        printMessage("Hello! I'm HealthBud" + NEW_LINE + "What can I do for you?");
    }

    /**
     * Prints the goodbye message and returns false to signal the termination of the program.
     *
     * @return false to indicate that the program should exit
     */
    public static boolean printGoodbye() {
        printMessage("Bye. Hope to see you again soon!");
        return false;
    }

    /**
     * Prints the list of available commands for the user.
     */
    public static void printHelp() {
        printMessage("Here are the commands you can use:" + NEW_LINE
                + "1. help - Display this list of commands" + NEW_LINE
                + "2. bye - Exit the program" + NEW_LINE
                + "3. recommend <muscle_group> - Get workout recommendations" + NEW_LINE
                + "4. bmi /w <weight_in_kg> /h <height_in_m> - Calculate your BMI" + NEW_LINE
                + "5. add workout <exercise> /w <weight in kg> /r <reps> /s <sets> /d <DD/MM/YYYY> " +
                "- Add a workout log" + NEW_LINE
                + "6. add meal <meal_name> /cal <calories> /d <DD/MM/YYYY> /t <HHmm> - Add a meal log" + NEW_LINE
                + "7. add water /ml <volume> /d <DD/MM/YYYY> /t <HHmm> - Add a water log" + NEW_LINE
                + "8. add pb <exercise> /w <weight_in_kg> /d <DD/MM/YYYY> - Record a personal best" + NEW_LINE
                + "9. add cardio <exercise> /s <speed> /i <incline> /t <duration_in_min> /d <DD/MM/YYYY> "
                + "- Add a cardio log" + NEW_LINE
                + "10. sum <cal|vol|cardio> /d <DD/MM/YYYY> - Sum up the total calories/water for the day" + NEW_LINE
                + "11. clear <pb|meal|workout|water|cardio> - Clear the respective log" + NEW_LINE
                + "12. view goals - to view all goals" + NEW_LINE
                + "13  add goal /ml <waterGoals /cal <calorieGoals> /kg <weightGoals> - to edit your personal goals"
                + NEW_LINE
                + "14. track goal /d <DD/MM/YYYY> - to track personal goals" + NEW_LINE
                + "15. status change <cutting/bulking> - Update your cutting/bulking status." + NEW_LINE
                + "16. status report <DD/MM/YYYY> - View your current cutting/bulking progress" + NEW_LINE
                + "17. search <logType> /d <DD/MM/YYYY> OR search <logType> /k <keyword> - Search for logs" + NEW_LINE
                + "18. list <logType> - List all logs for that specific log type" + NEW_LINE
                + "19. delete <logType> <index> - Delete specific index in the log");
    }

    /**
     * Prints a message indicating that the entered command is unknown.
     */
    public static void printUnknownCommand() {
        printMessage("I don't recognize that command. Type 'help' to see the list of commands.");
    }

    /**
     * Prints a log entry in a listed format.
     *
     * @param logs  the LogList containing the logs; must not be null.
     * @param index the index of the log to print.
     */
    public static void printListedFormat(LogList logs, int index) {
        printMessage((index + 1) + ". " + logs.getLog(index));
    }
}
