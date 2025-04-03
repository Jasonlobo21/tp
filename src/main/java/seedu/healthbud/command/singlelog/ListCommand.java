package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;

/**
 * ListCommand is responsible for listing all logs in the specified LogList.
 */
public class ListCommand extends SingleLogCommand {

    /**
     * Constructs a new ListCommand with the specified LogList.
     *
     * @param logList the LogList containing the logs to be listed; must not be null.
     */
    public ListCommand(LogList logList) {
        super(logList);
        assert logList != null : "LogList should not be null";
    }

    /**
     * Executes the list command, which lists all logs in the LogList.
     */
    @Override
    public void execute() {
        logList.listLogs();
    }
}
