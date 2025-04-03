package seedu.healthbud.command;

import seedu.healthbud.LogList;

// FOR COMMANDS THAT ONLY NEED ONE LOG AT A TIME AND INPUT

public abstract class SingleLogCommand implements Command {
    protected final LogList logList;

    public SingleLogCommand(LogList logList) {
        this.logList = logList;
    }
}
