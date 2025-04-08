package seedu.healthbud.command.singlelog;

import seedu.healthbud.Ui;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Goals;
import seedu.healthbud.LogList;
import seedu.healthbud.storage.Storage;

/**
 * Represents a command to set or update the user's daily goals.
 * These include goals for water intake, calorie consumption, and weight.
 * The updated goals are saved to persistent storage if they differ from the existing ones.
 */
public class AddGoalCommand extends SingleLogCommand {
    //@@author keanneeee
    /** Singleton instance of the Goals class used to store user's goal values. */
    private final Goals goal = Goals.getInstance();

    /** The daily water intake goal. */
    private String waterGoal;

    /** The daily calorie intake goal. */
    private String calorieGoal;

    /** The target weight goal. */
    private String weightGoal;

    /**
     * Constructs an AddGoalCommand with specified goal values.
     *
     * @param goalLogs     The log list for storing goal-related data.
     * @param waterGoal    The daily water intake goal.
     * @param calorieGoal  The daily calorie intake goal.
     * @param weightGoal   The target weight goal.
     */
    public AddGoalCommand(LogList goalLogs, String waterGoal,
                          String calorieGoal, String weightGoal){
        super(goalLogs);
        this.waterGoal = waterGoal;
        this.calorieGoal = calorieGoal;
        this.weightGoal = weightGoal;
    }

    /**
     * Executes the command by updating the stored goals.
     * If the new goals differ from the existing ones, the updated goals
     * are printed to the user and appended to persistent storage.
     * Otherwise, the same values are re-applied and shown to the user.
     */
    public void execute(){
        if (!waterGoal.equals(goal.getDailyWaterGoal())
                || !calorieGoal.equals(goal.getDailyCalorieGoal()) || !weightGoal.equals(goal.getWeightGoal())) {
            goal.updateGoals(waterGoal, calorieGoal, weightGoal);
            Ui.printMessage("Goal has been updated:\n" + goal.toString());
            Storage.appendLogToFile(goal);
        } else {
            goal.updateGoals(waterGoal, calorieGoal, weightGoal);
            Ui.printMessage("Goal has been updated:\n" + goal.toString());
        }
    }
}
