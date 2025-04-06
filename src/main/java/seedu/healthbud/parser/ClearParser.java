package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.ClearCommand;
import seedu.healthbud.exception.InvalidClearException;

/**
 * ClearParser is responsible for parsing the input command to clear logs.
 * It returns a ClearCommand corresponding to the specified log type.
 */
public class ClearParser {

    /**
     * Parses the given input string and returns a ClearCommand for the specified log type.
     *
     * @param input the input command string; must not be null.
     * @param pbLogs the LogList for personal best logs.
     * @param mealLogs the LogList for meal logs.
     * @param workoutLogs the LogList for workout logs.
     * @param waterLogs the LogList for water logs.
     * @param cardioLogs the LogList for cardio logs.
     * @return a new ClearCommand corresponding to the specified log type.
     * @throws InvalidClearException if the input does not have exactly two parts or the log type is unrecognized.
     */
    public static ClearCommand parse(String input, LogList pbLogs, LogList mealLogs,
                                     LogList workoutLogs, LogList waterLogs, LogList cardioLogs) throws
                                    InvalidClearException {
        assert input != null : "Input should not be null";

        String[] parts = input.trim().split("\\s+");
        if (parts.length != 2) {
            throw new InvalidClearException();
        }

        switch (parts[1]) {
        case "pb":
            return new ClearCommand(pbLogs);
        case "meal":
            return new ClearCommand(mealLogs);
        case "workout":
            return new ClearCommand( workoutLogs);
        case "water":
            return new ClearCommand(waterLogs);
        case "cardio":
            return new ClearCommand(cardioLogs);
        default:
            throw new InvalidClearException();
        }
    }
}
