package seedu.healthbud.command.singlelog;

import seedu.healthbud.Ui;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Goals;
import seedu.healthbud.LogList;


/**
 * Represents a command to view the user's current goals.
 * This command retrieves and displays the daily goals for water, calories, and weight.
 */
public class ViewGoalCommand extends SingleLogCommand {
    //@@author keanneeee
    /**
     * Constructs a ViewGoalCommand using the provided goal log list.
     *
     * @param goalLogs The log list related to user goals.
     */
    public ViewGoalCommand(LogList goalLogs) {
        super(goalLogs);
    }

    /**
     * Executes the command by retrieving and printing the user's current goals
     * from the singleton {@code Goals} instance. Also prompts the user for further input.
     */
    @Override
    public void execute() {
        Goals goal = Goals.getInstance();
        Ui.printMessage("Here are your current goals: \n" + goal);
        Ui.printMessage("What goal would you like to add today?\n");
    }
}
