package seedu.healthbud.command.add;

import seedu.healthbud.LogList;
import java.util.Map;
import seedu.healthbud.ParserParameters;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.log.Meal;

public abstract class AddMealCommand extends Command {

    public void execute(LogList mealLogs, String input) throws InvalidMealException {
        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidMealException();
        }

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (!input.contains("/cal ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidMealException();
        }

        input = input.substring("add meal".length()).trim();

        String mealName = input.substring(0, input.indexOf("/")).trim();

        if (param.get("cal").isEmpty() || param.get("d").isEmpty() || param.get("t").isEmpty()
                || mealName.isEmpty()) {
            throw new InvalidMealException();
        }

        if (!param.get("cal").matches("\\d+")) {
            throw new InvalidMealException();
        }

        Meal newMeal = new Meal(mealName, param.get("cal"), param.get("d"), param.get("t"));
        mealLogs.addLog(newMeal);
    }
}
