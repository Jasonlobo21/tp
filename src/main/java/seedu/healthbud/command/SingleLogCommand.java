package seedu.healthbud.command;

import seedu.healthbud.LogList;

/**
 * Abstract base class for commands that operate on a single LogList.
 * This class provides a common structure for commands that require a LogList as input.
 */
public abstract class SingleLogCommand implements Command {
    protected final LogList logList;

    /**
     * Constructs a SingleLogCommand with the specified LogList.
     *
     * @param logList the LogList to operate on; must not be null.
     */
    public SingleLogCommand(LogList logList) {
        assert logList != null : "LogList should not be null";
        this.logList = logList;
    }
}
