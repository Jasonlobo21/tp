package seedu.healthbud.command.add;

import seedu.healthbud.LogList;
import java.util.Map;
import seedu.healthbud.ParserParameters;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.log.Cardio;

public abstract class AddCardioCommand extends Command {

    public void execute(LogList cardioLogs, String input) throws InvalidCardioException {
        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidCardioException();
        }

        assert input != null : "Invalid cardio input!";
        assert !input.trim().isEmpty() : "Input should not be empty!";

        if (!input.contains("/s ") || !input.contains("/i ") || !input.contains("/t ") || !input.contains("/d ")) {
            throw new InvalidCardioException();
        }

        input = input.substring("add cardio".length()).trim();

        String cardioName = input.substring(0, input.indexOf("/")).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (cardioName.isEmpty() || param.get("s").isEmpty() || param.get("i").isEmpty()
                || param.get("t").isEmpty() || param.get("d").isEmpty()) {
            throw new InvalidCardioException();
        }

        if (!param.get("s").matches("\\d+") || !param.get("i").matches("\\d+") ||
                !param.get("t").matches("\\d+")) {
            throw new InvalidCardioException();
        }

        Cardio newCardio = new Cardio(cardioName, param.get("s"), param.get("i"), param.get("t"),
                param.get("d"));

        cardioLogs.addLog(newCardio);
    }
}
