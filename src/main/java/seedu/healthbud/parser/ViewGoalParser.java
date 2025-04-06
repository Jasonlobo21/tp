package seedu.healthbud.parser;

import seedu.healthbud.Ui;
import seedu.healthbud.log.Goals;

/**
 * ViewGoalsParser is responsible for displaying the current goals and prompting the user
 * to add new goals.
 * This class fetches the current goal settings from the Goals singleton and prints them using
 * the Ui class.
 *
 * Usage: Call the static parse method to display the current goals and prompt for new goals.
 *
 * Note: The input parameter is currently not used for any parsing.
 */
public class ViewGoalParser {

    Goals goal = Goals.getInstance();

    /**
     * Parses the input and displays the current goals along with a prompt to add a new goal.
     *
     * @param input the input string; must not be null.
     */
    public static void parse(String input){
        assert input != null : "Input should not be null";
        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            Ui.printUnknownCommand();
            return;
        }

        if (!parts[1].equals("goals")) {
            Ui.printUnknownCommand();
            return;
        }
        Ui.printMessage("Welcome to goal setting! Here are your current goals: \n"
                + Goals.getInstance().toString());
        Ui.printMessage("What goal would you like to add today?\n");
    }
}
