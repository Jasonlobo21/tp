package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidSumException;


public class SumCommand extends SingleLogCommand {

    private final String type;
    private final String date;

    public SumCommand(LogList logList, String type, String date) {
        super(logList);
        this.type = type;
        this.date = date;
    }

    @Override
    public void execute(){
        switch (type) {
        case "cal":
            logList.getCaloriesSum(date);
            break;
        case "vol":
            logList.getWaterSum(date);
            break;
        case "cardio":
            logList.getCardioSum(date);
            break;
        }
    }
}
