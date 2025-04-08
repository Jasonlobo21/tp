package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Meal;

//@@ author Ahmish15
/**
 * Represents a command to add a meal log entry to the meal log list.
 * This includes the name of the meal, its calorie content, date, and time consumed.
 */
public class AddMealCommand extends SingleLogCommand {
    /** The name of the meal. */
    private final String name;

    /** The number of calories in the meal. */
    private final String calories;

    /** The date the meal was consumed. */
    private final String date;

    /** The time the meal was consumed. */
    private final String time;

    /**
     * Constructs an AddMealCommand with the given meal details.
     *
     * @param mealLogs  The log list where the meal entry will be added.
     * @param name      The name or description of the meal.
     * @param calories  The calorie content of the meal.
     * @param date      The date the meal was consumed.
     * @param time      The time the meal was consumed.
     */
    public AddMealCommand(LogList mealLogs, String name, String calories, String date, String time) {
        super(mealLogs);
        this.name = name;
        this.calories = calories;
        this.date = date;
        this.time = time;
    }

    /**
     * Executes the command by creating a new {@code Meal} object
     * and adding it to the meal log list.
     */
    @Override
    public void execute() {
        Meal newMeal = new Meal(name, calories, date, time);
        logList.addLog(newMeal);
    }
}
