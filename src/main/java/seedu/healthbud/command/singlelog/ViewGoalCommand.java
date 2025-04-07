package seedu.healthbud.command.singlelog;

import seedu.healthbud.Ui;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Goals;
import seedu.healthbud.LogList;


public class ViewGoalCommand extends SingleLogCommand {
    //@@author keanneeee
    public ViewGoalCommand(LogList goalLogs) {
        super(goalLogs);
    }

    @Override
    public void execute() {
        Goals goal = Goals.getInstance();
        Ui.printMessage("Here are your current goals: \n" + goal);
        Ui.printMessage("What goal would you like to add today?\n");
    }
}
