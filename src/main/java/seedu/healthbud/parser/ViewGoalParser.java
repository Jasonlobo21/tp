package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.ViewGoalCommand;
import seedu.healthbud.Ui;
import seedu.healthbud.log.Goals;
import seedu.healthbud.exception.InvalidViewException;


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

    static Goals goal = Goals.getInstance();
    /**
     * Parses the input and displays the current goals along with a prompt to add a new goal.
     *
     * @param input the input string; must not be null.
     */
    public static ViewGoalCommand parse(String input, LogList goalLogs)
            throws InvalidViewException {
        assert input != null : "Input should not be null";

        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            throw new InvalidViewException();
        }

        if (parts[1].equals("goals")||parts[1].equals("goal")) {
            Ui.printMessage("Here are your current goals: \n"
                    + Goals.getInstance().toString());
            Ui.printMessage("What goal would you like to add today?\n");
            return new ViewGoalCommand(goalLogs);
        }
        throw new InvalidViewException();
    }
}
