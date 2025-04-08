package seedu.healthbud.command.multilog;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.command.MultiLogCommand;

/**
 * Represents a command to print a status message to the user.
 * This command does not modify any logs but provides feedback or information
 * based on the user's input or system's state.
 */
public class StatusCommand extends MultiLogCommand {
    /** Message to be displayed when the command is executed. */
    private final String message;

    /**
     * Constructs a StatusCommand object with the specified log lists and message.
     *
     * @param goalLogs    The list of goal-related logs.
     * @param pbLogs      The list of personal best logs.
     * @param mealLogs    The list of meal logs.
     * @param workoutLogs The list of workout logs.
     * @param waterLogs   The list of water intake logs.
     * @param cardioLogs  The list of cardio logs.
     * @param input       The user input that triggered this command.
     * @param message     The status message to be displayed to the user.
     */
    public StatusCommand(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                         LogList waterLogs, LogList cardioLogs, String input, String message) {
        super(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
        this.message = message;
    }

    /**
     * Executes the command by printing the stored status message to the user.
     * Ensures that the message is not null before attempting to print.
     */
    @Override
    public void execute(){
        assert message != null : "Status message should not be null";
        Ui.printMessage(message);
    }
}
