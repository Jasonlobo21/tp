package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddWaterCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

public class AddWaterParser {

    public static AddWaterCommand parse(LogList waterLogs, String input)
            throws InvalidWaterException, InvalidDateFormatException {

        assert input != null : "Invalid water input!";
        assert !input.trim().isEmpty() : "Input should not be empty!";

        if (!input.contains("/ml ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidWaterException();
        }

        input = input.substring("add water".length()).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (!param.containsKey("ml") || param.get("ml").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty() ||
                !param.containsKey("t") || param.get("t").isEmpty()) {
            throw new InvalidWaterException();
        }

        if (!param.get("ml").matches("\\d+")) {
            throw new InvalidWaterException();
        }

        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddWaterCommand(waterLogs, param.get("ml"), formattedDate, param.get("t"));
    }
}
