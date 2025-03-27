package seedu.healthbud.command.OneLogAndInput;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidDeleteException;

public class DeleteCommand extends OneLogCommand {

    private final int index;

    public DeleteCommand(LogList targetLogList, String input, int index) {
        super(targetLogList, input);
        this.index = index;
    }

    @Override
    public void execute() throws InvalidDeleteException, HealthBudException {
        if (!input.trim().matches(".*\\d+.*")) {
            throw new HealthBudException("Insert a valid task number");
        }

        logList.deleteLog(index);
    }
}
