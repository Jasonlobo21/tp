package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidDeleteException;

public class DeleteCommand extends Command {

    @Override
    public void execute(LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input)
            throws InvalidDeleteException {

        String[] parts = input.split(" ");
        if (parts.length < 3) {
            throw new InvalidDeleteException("Invalid delete command (e.g. delete meal|workout|water <index>)");
        }

        if (!parts[2].matches("\\d+")) {
            throw new InvalidDeleteException("Insert a valid task number");
        }
        int index = Integer.parseInt(parts[2]);

        switch (parts[1]) {
        case "meal":
            mealLogs.deleteLog(index);
            break;
        case "workout":
            workoutLogs.deleteLog(index);
            break;
        case "water":
            waterLogs.deleteLog(index);
            break;
        default:
            throw new InvalidDeleteException("Invalid delete command (e.g. delete meal|workout|water <index>)");
        }
    }
}
