package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Cardio;

//@@author Ahmish15
/**
 * Represents a command to add a new cardio log to the cardio log list.
 * This command encapsulates the cardio details such as name, sets, intensity,
 * duration (time), and date.
 */
public class AddCardioCommand extends SingleLogCommand {
    /** The name of the cardio exercise. */
    private final String name;

    /** The number of sets performed. */
    private final String sets;

    /** The intensity level of the cardio workout. */
    private final String intensity;

    /** The duration of the cardio session. */
    private final String time;

    /** The date the cardio workout was performed. */
    private final String date;

    /**
     * Constructs an AddCardioCommand with the specified cardio details.
     *
     * @param cardioLogs The log list to which the new cardio entry will be added.
     * @param name       The name of the cardio exercise.
     * @param sets       The number of sets performed.
     * @param intensity  The intensity level of the cardio session.
     * @param time       The duration of the session.
     * @param date       The date the cardio session was done.
     */
    public AddCardioCommand(LogList cardioLogs, String name, String sets,
                            String intensity, String time, String date) {
        super(cardioLogs);
        this.name = name;
        this.sets = sets;
        this.intensity = intensity;
        this.time = time;
        this.date = date;
    }

    /**
     * Executes the command by creating a new {@code Cardio} object and
     * adding it to the associated cardio log list.
     */
    @Override
    public void execute() {
        Cardio newCardio = new Cardio(name, sets, intensity, time, date);
        logList.addLog(newCardio);
    }

}
