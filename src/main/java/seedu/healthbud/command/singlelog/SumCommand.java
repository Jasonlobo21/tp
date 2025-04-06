package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.exception.InvalidDateFormatException;

/**
 * SumCommand is responsible for calculating the sum for a particular log type on a given date.
 * Depending on the specified type ("cal", "vol", or "cardio"), it calls the corresponding
 * summing method on the LogList.
 */
public class SumCommand extends SingleLogCommand {

    private final String type;
    private final String date;

    /**
     * Constructs a SumCommand with the specified LogList, type, and date.
     *
     * @param logList the LogList to operate on; must not be null.
     * @param type    the type of sum operation ("cal", "vol", or "cardio"); must not be null.
     * @param date    the date for which the sum is calculated; must not be null.
     */
    public SumCommand(LogList logList, String type, String date) {
        super(logList);
        assert type != null : "Type should not be null";
        assert date != null : "Date should not be null";
        this.type = type;
        this.date = date;
    }

    /**
     * Executes the sum command by invoking the corresponding method on the LogList based on the type.
     * If the type is "cal", it calculates the total calories; if "vol", the total water volume;
     * if "cardio", the total cardio sum.
     */
    @Override
    public void execute() throws InvalidDateFormatException {
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
        default:
            break;
        }
    }
}
