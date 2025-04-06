package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddWaterCommand;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.TimeParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * AddWaterParser is responsible for parsing the input command for adding a water log.
 * It extracts the water volume, date, and time parameters from the input string and returns an AddWaterCommand.
 */
public class AddWaterParser {

    /**
     * Parses the input command for adding a water log and returns an AddWaterCommand.
     *
     * @param waterLogs the LogList for water logs; must not be null.
     * @param input     the input command string; must not be null.
     * @return an AddWaterCommand with the parsed water log details.
     * @throws InvalidWaterException if the input format is invalid or required parameters are missing.
     * @throws InvalidDateFormatException if the date provided cannot be parsed.
     */
    public static AddWaterCommand parse(LogList waterLogs, String input)
            throws InvalidWaterException, InvalidDateException, InvalidDateFormatException {

        assert input != null : "Input should not be null";

        input = input.substring("add water".length()).trim();

        if (!input.contains("/ml ") || !input.contains("/d ") || !input.contains("/t ") || !input.startsWith("/")) {
            throw new InvalidWaterException();
        }

        Map<String, String> param = ParserParameters.parseParameters(input);

        Set<String> allowedKeys = new HashSet<>(Arrays.asList("ml", "d", "t"));
        if (!param.keySet().equals(allowedKeys)) {
            throw new InvalidWaterException();
        }

        if (!param.containsKey("ml") || param.get("ml").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty() ||
                !param.containsKey("t") || param.get("t").isEmpty()) {
            throw new InvalidWaterException();
        }

        if (!param.get("ml").matches("\\d+")) {
            throw new InvalidWaterException();
        }

        String formattedDate = DateParser.formatDate(param.get("d"));
        String formattedTime = TimeParser.formatTime(param.get("t"));

        return new AddWaterCommand(waterLogs, param.get("ml"), formattedDate, formattedTime);
    }
}
