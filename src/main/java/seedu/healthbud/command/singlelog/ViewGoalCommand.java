package seedu.healthbud.command.singlelog;

import seedu.healthbud.Ui;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Goals;
import seedu.healthbud.LogList;


public class ViewGoalCommand extends SingleLogCommand {


    Goals goal = Goals.getInstance();

    public ViewGoalCommand(LogList goalLogs) {
        super(goalLogs);
    }

    @Override
    public void execute() {
    }
}
