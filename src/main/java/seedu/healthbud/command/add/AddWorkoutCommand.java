package seedu.healthbud.command.add;

import seedu.healthbud.LogList;
import java.util.Map;
import seedu.healthbud.ParserParameters;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.WorkOUT;

public abstract class AddWorkoutCommand extends Command {


    public void execute(LogList workoutLogs, String input) throws InvalidWorkoutException {
        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidWorkoutException();
        }

        Map<String, String> param = ParserParameters.parseParameters(input);

        assert input != null : "Invalid workout input!";

        if (!input.contains("/r ") || !input.contains("/s ") || !input.contains("/d ")) {
            throw new InvalidWorkoutException();
        }

        input = input.substring("add workout".length()).trim();

        String workoutName = input.substring(0, input.indexOf("/")).trim();

        if (param.get("r").isEmpty() || param.get("s").isEmpty() || param.get("d").isEmpty()
                || workoutName.isEmpty()) {
            throw new InvalidWorkoutException();
        }

        if (!param.get("r").matches("\\d+") || !param.get("s").matches("\\d+")) {
            throw new InvalidWorkoutException();
        }

        WorkOUT newWorkout = new WorkOUT(workoutName, param.get("r"), param.get("s"), param.get("d"));
        workoutLogs.addLog(newWorkout);
    }
}
