package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.PersonalBest;

/**
 * Represents a command to add a new personal best (PB) record to the PB log list.
 * A personal best typically includes the exercise name, weight lifted, and the date of achievement.
 */
//@@ author Ahmish15
public class AddPersonalBestCommand extends SingleLogCommand {
    /** The name of the exercise or activity. */
    private final String name;

    /** The weight value achieved as a personal best. */
    private final String weight;

    /** The date the personal best was achieved. */
    private final String date;

    /**
     * Constructs an AddPersonalBestCommand with the specified details.
     *
     * @param pbLogs  The log list to which the personal best record will be added.
     * @param name    The name of the exercise or activity.
     * @param weight  The weight achieved.
     * @param date    The date the personal best was recorded.
     */
    public AddPersonalBestCommand(LogList pbLogs, String name, String weight, String date) {
        super(pbLogs);
        this.name = name;
        this.weight = weight;
        this.date = date;
    }

    /**
     * Executes the command by creating a new {@code PersonalBest} entry
     * and adding it to the associated log list.
     */
    @Override
    public void execute() {
        PersonalBest newPB = new PersonalBest(name, weight, date);
        logList.addLog(newPB);
    }
}
