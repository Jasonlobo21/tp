package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input) {
        if (mealLogs.isEmpty()) {
            Ui.printMessage(" No tasks available.");
        } else {
            for (int i = 0; i < mealLogs.getSize(); i++) {
                Ui.printListedFormat(mealLogs, i);
            }
        }
    }
}
