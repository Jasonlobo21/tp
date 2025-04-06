package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.DeleteCommand;
import seedu.healthbud.exception.InvalidDeleteException;

/**
 * DeleteParser is responsible for parsing the input command for deleting a log entry.
 * It validates the input format, extracts the index, and returns the corresponding DeleteCommand.
 */
public class DeleteParser {

    /**
     * Parses the given input string and returns a DeleteCommand for the specified log type.
     *
     * @param input      the input command string; must not be null.
     * @param mealLogs   the LogList for meal logs.
     * @param workoutLogs the LogList for workout logs.
     * @param waterLogs  the LogList for water logs.
     * @param pbLogs     the LogList for personal best logs.
     * @param cardioLogs the LogList for cardio logs.
     * @return a new DeleteCommand for the specified log type and index.
     * @throws InvalidDeleteException if the input does not conform to the expected format or index is invalid.
     */
    public static DeleteCommand parse(String input, LogList mealLogs, LogList workoutLogs, LogList waterLogs,
                                      LogList pbLogs, LogList cardioLogs)
            throws InvalidDeleteException {

        assert input != null : "Input should not be null";

        String[] parts = input.trim().split("\\s+");
        if (parts.length != 3) {
            throw new InvalidDeleteException();
        }

        int index;

        try {
            index = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidDeleteException();
        }

        switch (parts[1]) {
        case "meal":
            return new DeleteCommand(mealLogs, index);
        case "workout":
            return new DeleteCommand(workoutLogs, index);
        case "water":
            return new DeleteCommand(waterLogs, index);
        case "pb":
            return new DeleteCommand(pbLogs, index);
        case "cardio":
            return new DeleteCommand(cardioLogs, index);
        default:
            throw new InvalidDeleteException();
        }
    }
}
