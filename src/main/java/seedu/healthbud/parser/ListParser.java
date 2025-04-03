package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.ListCommand;
import seedu.healthbud.exception.InvalidListException;

/**
 * ListParser is responsible for parsing the user input command for listing logs.
 * It returns a new ListCommand corresponding to the specified log type.
 */
public class ListParser {

    /**
     * Parses the given input string and returns a ListCommand for the specified log type.
     *
     * @param input the input command string; must not be null.
     * @param mealLogs the LogList for meal logs.
     * @param workoutLogs the LogList for workout logs.
     * @param waterLogs the LogList for water logs.
     * @param pbLogs the LogList for personal best logs.
     * @param cardioLogs the LogList for cardio logs.
     * @return a new ListCommand corresponding to the specified log type.
     * @throws InvalidListException if the input format is invalid or the log type is unrecognized.
     */
    public static ListCommand parse(String input, LogList mealLogs, LogList workoutLogs,
                                    LogList waterLogs, LogList pbLogs, LogList cardioLogs)
            throws InvalidListException {
        assert input != null : "Input should not be null";
        String[] parts = input.trim().split(" ");

        if (parts.length != 2) {
            throw new InvalidListException();
        }

        switch (parts[1]) {
        case "meal":
            return new ListCommand(mealLogs);
        case "workout":
            return new ListCommand(workoutLogs);
        case "water":
            return new ListCommand(waterLogs);
        case "pb":
            return new ListCommand(pbLogs);
        case "cardio":
            return new ListCommand(cardioLogs);
        default:
            throw new InvalidListException();
        }
    }
}
