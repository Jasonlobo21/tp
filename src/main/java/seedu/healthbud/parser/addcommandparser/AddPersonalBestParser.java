package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddPersonalBestCommand;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * AddPersonalBestParser is responsible for parsing the input command for adding a personal best log.
 * It extracts the exercise name, weight, and date parameters from the input string and returns an
 * AddPersonalBestCommand.
 */
public class AddPersonalBestParser {

    /**
     * Parses the input command for adding a personal best and returns an AddPersonalBestCommand.
     *
     * @param pbLogs the LogList for personal best logs; must not be null.
     * @param input  the input command string; must not be null.
     * @return an AddPersonalBestCommand with the parsed exercise name, weight, and date.
     * @throws InvalidPersonalBestException if the input format is invalid or required parameters are missing.
     * @throws InvalidDateFormatException if the provided date cannot be parsed.
     */
    public static AddPersonalBestCommand parse(LogList pbLogs, String input)
            throws InvalidPersonalBestException, InvalidDateFormatException, InvalidDateException, HealthBudException {

        assert input != null : "Input should not be null";

        if (!input.contains("/w ") || !input.contains("/d ")) {
            throw new InvalidPersonalBestException();
        }

        input = input.substring("add pb".length()).trim();

        String name = input.substring(0, input.indexOf("/")).trim().replaceAll("\\s+", " ");

        Map<String, String> param = ParserParameters.parseParameters(input.substring(name.length()));
        Set<String> allowedKeys = new HashSet<>(Arrays.asList("w", "d"));
        if (!param.keySet().equals(allowedKeys)) {
            throw new InvalidPersonalBestException();
        }

        if (name.isEmpty() ||
                !param.containsKey("w") || param.get("w").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty()) {
            throw new InvalidPersonalBestException();
        }

        if (!param.get("w").matches("^-?\\d+(\\.\\d+)?$")) {
            throw new InvalidPersonalBestException();
        }

        Double weight = Double.parseDouble(param.get("w"));

        if (weight <= 0 || weight > 1000) {
            throw new HealthBudException("Weight should be greater than 0 and less than 1000kg.");
        }

        String trimmedWeight = param.get("w").replaceFirst("^0+(?=\\d)", "");

        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddPersonalBestCommand(pbLogs, name, trimmedWeight, formattedDate);
    }
}

