package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddMealCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;


public class AddMealParser {

    //@@author Ahmish15
    public static AddMealCommand parse(LogList mealLogs, String input)
            throws InvalidMealException, InvalidDateFormatException {

        assert input != null : "Invalid meal input!";
        if (!input.contains("/cal ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidMealException();
        }

        input = input.substring("add meal".length()).trim();

        String name = input.substring(0, input.indexOf("/")).trim();

        Map<String, String> param = ParserParameters.parseParameters(input.substring(name.length()));

        if (name.isEmpty() || !param.containsKey("cal") || param.get("cal").isEmpty() || !param.containsKey("d")
                || param.get("d").isEmpty() || !param.containsKey("t") || param.get("t").isEmpty()) {
            throw new InvalidMealException();
        }

        if (!param.get("cal").matches("\\d+")) {
            throw new InvalidMealException();
        }

        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddMealCommand(mealLogs, input, name, param.get("cal"), formattedDate, param.get("t"));
    }
}
