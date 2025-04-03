package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddPersonalBestCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

public class AddPersonalBestParser {

    public static AddPersonalBestCommand parse(LogList pbLogs, String input)
            throws InvalidPersonalBestException, InvalidDateFormatException {

        assert input != null : "Invalid personal best input!";
        if (!input.contains("/w ") || !input.contains("/d ")) {
            throw new InvalidPersonalBestException();
        }

        input = input.substring("add pb".length()).trim();

        String name = input.substring(0, input.indexOf("/")).trim();

        Map<String, String> param = ParserParameters.parseParameters(input.substring(name.length()));

        if (name.isEmpty() ||
                !param.containsKey("w") || param.get("w").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty()) {
            throw new InvalidPersonalBestException();
        }

        if (!param.get("w").matches("\\d+")) {
            throw new InvalidPersonalBestException();
        }
        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddPersonalBestCommand(pbLogs, input, name, param.get("w"), formattedDate);
    }
}

