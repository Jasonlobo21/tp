package seedu.healthbud.command.multilog;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.command.MultiLogCommand;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidTrackException;

/**
 * Represents a command that tracks the user's goal progress on a specific date.
 * It provides a summary of water intake and calorie consumption for that date.
 */
public class TrackGoalCommand extends MultiLogCommand {
    //@@author keanneeee
    /** The formatted date string used for tracking goal progress. */
    private final String date;


    /**
     * Constructs a TrackGoalCommand with the specified date and all relevant log lists.
     *
     * @param date         The input date string to track progress for.
     * @param goalLogs     The list of goal-related logs.
     * @param pbLogs       The list of personal best logs.
     * @param mealLogs     The list of meal logs.
     * @param workoutLogs  The list of workout logs.
     * @param waterLogs    The list of water intake logs.
     * @param cardioLogs   The list of cardio logs.
     * @throws InvalidTrackException If there is an issue initializing the track command.
     * @throws InvalidDateFormatException If the date format is invalid or cannot be parsed.
     */
    public TrackGoalCommand(String date, LogList goalLogs, LogList pbLogs, LogList mealLogs,
                            LogList workoutLogs, LogList waterLogs, LogList cardioLogs)
            throws InvalidTrackException, InvalidDateFormatException {
        super(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, date);

        assert !date.trim().isEmpty() : "Date string should not be empty";

        this.date = DateParser.formatDate(date);
    }

    /**
     * Executes the TrackGoalCommand by printing the user's water and calorie statistics
     * for the specified date.
     *
     * @throws InvalidDateFormatException If the date format is invalid during execution.
     */
    @Override
    public void execute() throws InvalidDateFormatException {
        Ui.printMessage("Here is your goal progress for " + date + ": \n");
        waterLogs.getWaterSum(date);
        mealLogs.getCaloriesSum(date);
    }
}

