package seedu.healthbud.command;

import seedu.healthbud.LogList;

/**
 * Abstract base class for commands that require multiple LogLists and an input string.
 * This class provides a common structure for commands that operate on various types of logs.
 */
public abstract class MultiLogCommand implements Command {
    protected LogList goalLogs;
    protected LogList pbLogs;
    protected LogList mealLogs;
    protected LogList workoutLogs;
    protected LogList waterLogs;
    protected LogList cardioLogs;
    protected String input;

    /**
     * Constructs a MultiLogCommand with the specified LogLists and input string.
     *
     * @param goalLogs    the LogList for goal logs; must not be null.
     * @param pbLogs      the LogList for personal best logs; must not be null.
     * @param mealLogs    the LogList for meal logs; must not be null.
     * @param workoutLogs the LogList for workout logs; must not be null.
     * @param waterLogs   the LogList for water logs; must not be null.
     * @param cardioLogs  the LogList for cardio logs; must not be null.
     * @param input       the input string; must not be null.
     */
    public MultiLogCommand(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                           LogList waterLogs, LogList cardioLogs, String input) {
        assert goalLogs != null : "Goal logs should not be null";
        assert pbLogs != null : "Personal best logs should not be null";
        assert mealLogs != null : "Meal logs should not be null";
        assert workoutLogs != null : "Workout logs should not be null";
        assert waterLogs != null : "Water logs should not be null";
        assert cardioLogs != null : "Cardio logs should not be null";
        assert input != null : "Input should not be null";
        this.goalLogs = goalLogs;
        this.pbLogs = pbLogs;
        this.mealLogs = mealLogs;
        this.workoutLogs = workoutLogs;
        this.waterLogs = waterLogs;
        this.cardioLogs = cardioLogs;
        this.input = input;
    }
}
