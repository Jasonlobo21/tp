package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.SearchCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidSearchException;

/**
 * SearchParser is responsible for parsing the input command for searching logs.
 * It determines whether to search by date or keyword and returns a corresponding SearchCommand.
 */
public class SearchParser {

    /**
     * Parses the given input string and returns a SearchCommand.
     *
     * @param input the input string; must not be null.
     * @param mealLogs the LogList for meal logs.
     * @param workoutLogs the LogList for workout logs.
     * @param waterLogs the LogList for water logs.
     * @param pbLogs the LogList for personal best logs.
     * @param cardioLogs the LogList for cardio logs.
     * @return a new SearchCommand based on the log type and search parameter.
     * @throws InvalidSearchException if the input does not have exactly 4 parts or does not contain "/k " or "/d ".
     * @throws InvalidDateFormatException if the provided date is invalid.
     */
    public static SearchCommand parse(String input,
                                      LogList mealLogs, LogList workoutLogs,
                                      LogList waterLogs, LogList pbLogs, LogList cardioLogs)
            throws InvalidSearchException, InvalidDateFormatException {
        assert input != null : "Input should not be null";


        String[] parts = input.split(" ");
        if (parts.length != 4) {
            throw new InvalidSearchException();
        }

        if (!input.contains("/k ") && !input.contains("/d ")) {
            throw new InvalidSearchException();
        }

        String date = null;
        String keyword = null;

        if (input.contains("/d")) {
            date = DateParser.formatDate(parts[3]);
        } else {
            keyword = parts[3];
        }

        switch (parts[1]) {
        case "meal":
            return new SearchCommand(mealLogs, date, keyword);
        case "workout":
            return new SearchCommand(workoutLogs, date, keyword);
        case "water":
            return new SearchCommand(waterLogs, date, keyword);
        case "pb":
            return new SearchCommand(pbLogs, date, keyword);
        case "cardio":
            return new SearchCommand(cardioLogs, date, keyword);
        default:
            throw new InvalidSearchException();
        }
    }
}
