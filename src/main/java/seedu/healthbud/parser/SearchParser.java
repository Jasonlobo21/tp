package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.SearchCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidSearchException;

public class SearchParser {

    public static SearchCommand parse(String input,
                                      LogList mealLogs, LogList workoutLogs,
                                      LogList waterLogs, LogList pbLogs, LogList cardioLogs)
            throws InvalidSearchException, InvalidDateFormatException {

        if (input == null || input.trim().isEmpty()) {
            throw new InvalidSearchException(
                    "Invalid search command - Try search <logType> /d <date> OR search <logType> /k <keyword>");
        }
        String paramsString = input.replaceFirst("(?i)^search", "").trim();
        if (paramsString.isEmpty()) {
            throw new InvalidSearchException(
                    "Invalid search command - Try search <logType> /d <date> OR search <logType> /k <keyword>");
        }

        // Split into exactly 3 parts: [logType, flag, parameter]
        String[] parts = paramsString.split("\\s+");
        if (parts.length != 3) {
            throw new InvalidSearchException(
                    "Invalid search command - Provide exactly one logType and one parameter flag (/d or /k).");
        }

        String logType = parts[0].toLowerCase();
        String flag = parts[1].toLowerCase();
        String parameter = parts[2];

        // Parse date or keyword
        String date = null;
        String keyword = null;
        if (flag.equals("/d")) {
            // May throw InvalidDateFormatException
            date = DateParser.formatDate(parameter);
        } else if (flag.equals("/k")) {
            keyword = parameter;
        } else {
            throw new InvalidSearchException("Invalid parameter flag. Use /d for date or /k for keyword.");
        }

        // Determine which LogList to target
        LogList targetLogList;
        switch (logType) {
        case "meal":
            targetLogList = mealLogs;
            break;
        case "workout":
            targetLogList = workoutLogs;
            break;
        case "water":
            targetLogList = waterLogs;
            break;
        case "pb":
            targetLogList = pbLogs;
            break;
        case "cardio":
            targetLogList = cardioLogs;
            break;
        default:
            throw new InvalidSearchException("Invalid log type. Valid types: meal, workout, water, pb, cardio.");
        }

        // Build and return a SearchCommand (no searching or printing here!)
        return new SearchCommand(targetLogList, date, keyword);
    }
}
