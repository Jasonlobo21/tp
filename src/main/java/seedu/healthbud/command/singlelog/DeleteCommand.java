package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.exception.HealthBudException;

/**
 * DeleteCommand is responsible for deleting a specific log entry from the provided LogList.
 * The log entry to be deleted is identified by its index in the list.
 */
public class DeleteCommand extends SingleLogCommand {

    private final int index;

    /**
     * Constructs a new DeleteCommand with the specified LogList and index.
     *
     * @param targetLogList the LogList from which the log should be deleted; must not be null.
     * @param index         the index of the log to delete.
     */
    public DeleteCommand(LogList targetLogList, int index) {
        super(targetLogList);
        this.index = index;
    }

    /**
     * Executes the delete command by removing the log at the specified index from the LogList.
     *
     * @throws HealthBudException if the deletion fails due to an invalid index or other issues.
     */
    @Override
    public void execute() throws HealthBudException {
        logList.deleteLog(index);
    }

    /**
     * Returns the LogList associated with this command.
     *
     * @return the LogList used by this command.
     */
    public LogList getLogList() {
        return logList;
    }

    /**
     * Returns the index of the log to be deleted.
     *
     * @return the index of the log.
     */
    public int getIndex() {
        return index;
    }
}
