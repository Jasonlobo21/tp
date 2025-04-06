package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.SumCommand;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidSumException;

/**
 * SumParser is responsible for parsing the input command for the sum operation.
 * It extracts the log type and date and returns the corresponding SumCommand.
 */
public class SumParser {

    /**
     * Parses the given input string and returns a SumCommand.
     *
     * @param input the input string; must not be null.
     * @param mealLogs the LogList for meal logs.
     * @param waterLogs the LogList for water logs.
     * @param cardioLogs the LogList for cardio logs.
     * @return a new SumCommand based on the log type and date extracted from the input.
     * @throws InvalidSumException if the input does not conform to the expected format.
     * @throws InvalidDateFormatException if the date format is invalid.
     */
    public static SumCommand parse(String input, LogList mealLogs, LogList waterLogs, LogList cardioLogs) throws
            InvalidSumException, InvalidDateException, InvalidDateFormatException {

        assert input != null : "Input should not be null";
        String[] parts = input.trim().split("\\s+");

        if (parts.length < 4 || !parts[2].equals("/d")) {
            throw new InvalidSumException();
        }

        String type = parts[1].toLowerCase();
        String date = parts[3];
        String parseDate = DateParser.formatDate(date);

        switch (type) {
        case "cal":
            return new SumCommand(mealLogs, type, parseDate);
        case "vol":
            return new SumCommand(waterLogs, type, parseDate);
        case "cardio":
            return new SumCommand(cardioLogs, type, parseDate);
        default:
            throw new InvalidSumException();
        }
    }
}
