package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidListException;

public class ListCommand extends Command {

    @Override
    public void execute(LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input) throws InvalidListException {

        String[] parts = input.split(" ");

        if (parts.length < 2) {
            throw new InvalidListException();
        }

        switch (parts[1]) {
        case "meal":
            if (mealLogs.isEmpty()) {
                Ui.printMessage(" No tasks available.");
            } else {
                for (int i = 0; i < mealLogs.getSize(); i++) {
                    Ui.printListedFormat(mealLogs, i);
                }
            }
            break;
        case "workout":
            if (workoutLogs.isEmpty()) {
                Ui.printMessage(" No tasks available.");
            } else {
                for (int i = 0; i < workoutLogs.getSize(); i++) {
                    Ui.printListedFormat(workoutLogs, i);
                }
            }
            break;
        case "water":
            if (waterLogs.isEmpty()) {
                Ui.printMessage(" No tasks available.");
            } else {
                for (int i = 0; i < waterLogs.getSize(); i++) {
                    Ui.printListedFormat(waterLogs, i);
                }
            }
            break;
        default:
            throw new InvalidListException();
        }
    }
}
