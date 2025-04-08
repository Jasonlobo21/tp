package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Water;

/**
 * Represents a command to add a water intake entry to the water log list.
 * This includes the amount of water consumed in milliliters (ml), the date, and the time of intake.
 */
//@@ author Ahmish15
public class AddWaterCommand extends SingleLogCommand {

    /** The amount of water consumed in milliliters. */
    private final String ml;

    /** The date the water was consumed. */
    private final String date;

    /** The time the water was consumed. */
    private final String time;

    /**
     * Constructs an AddWaterCommand with the specified water intake details.
     *
     * @param waterLogs The log list where the water intake entry will be recorded.
     * @param ml        The amount of water consumed in milliliters.
     * @param date      The date of water consumption.
     * @param time      The time of water consumption.
     */
    public AddWaterCommand(LogList waterLogs, String ml, String date, String time) {
        super(waterLogs);
        this.ml = ml;
        this.date = date;
        this.time = time;
    }

    /**
     * Executes the command by creating a new {@code Water} object
     * and adding it to the associated water log list.
     */
    @Override
    public void execute(){
        Water newWater = new Water(ml, date, time);
        logList.addLog(newWater);
    }
}
