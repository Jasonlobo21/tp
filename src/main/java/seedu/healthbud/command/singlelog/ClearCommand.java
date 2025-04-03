package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;

/**
 * ClearCommand is responsible for clearing all log entries from the provided LogList.
 * It extends the SingleLogCommand class, which provides a common interface for commands that operate on a LogList.
 */
public class ClearCommand extends SingleLogCommand {

    /**
     * Constructs a new ClearCommand with the specified LogList.
     *
     * @param logList the LogList whose logs will be cleared; must not be null.
     */
    public ClearCommand(LogList logList) {
        super(logList);
        assert logList != null : "LogList should not be null";
    }

    /**
     * Executes the clear command by clearing all logs from the LogList.
     */
    @Override
    public void execute() {
        logList.clearLogs();
    }
}
