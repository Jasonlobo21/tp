package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Workout;


/**
 * Represents a command to add a workout entry to the workout log list.
 * This includes the workout name, number of reps and sets, date performed, and the weight used.
 */
//@@ author Ahmish15
public class AddWorkoutCommand extends SingleLogCommand {
    /** The name of the workout or exercise. */
    private final String name;

    /** The number of repetitions performed. */
    private final String reps;

    /** The number of sets performed. */
    private final String sets;

    /** The date the workout was performed. */
    private final String date;

    /** The weight used for the workout. */
    private final String weight;

    /**
     * Constructs an AddWorkoutCommand with the given workout details.
     *
     * @param workoutLogs The log list where the workout entry will be added.
     * @param name        The name of the workout.
     * @param reps        The number of repetitions per set.
     * @param sets        The number of sets performed.
     * @param date        The date the workout was done.
     * @param weight      The weight used in the workout.
     */
    public AddWorkoutCommand(LogList workoutLogs, String name,
                             String reps, String sets, String date, String weight) {
        super(workoutLogs);
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.date = date;
        this.weight = weight;
    }

    /**
     * Executes the command by creating a new {@code Workout} object
     * and adding it to the associated workout log list.
     */
    @Override
    public void execute(){
        Workout newWorkout = new Workout(name, reps, sets, date, weight);
        logList.addLog(newWorkout);
    }

}
