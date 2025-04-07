package seedu.healthbud.log;

/**
 * The Goals class represents a goal log entry and stores the daily water goal,
 * daily calorie goal, weight goal, and weekly weight progress.
 * It is implemented as a singleton to ensure that only one set of goals exists.
 */
public class Goals extends Log {

    private static Goals instance;
    private String dailyWaterGoal;
    private String dailyCalorieGoal;
    private String weightGoal;
    private String weeklyWeightProgress;

    /**
     * Constructs a new Goals object with the specified values.
     *
     * @param dailyWaterGoal      the daily water goal; must not be null.
     * @param dailyCalorieGoal    the daily calorie goal; must not be null.
     * @param weightGoal          the weight goal; must not be null.
     * @param weeklyWeightProgress the weekly weight progress; must not be null.
     * @param date                the date for the goals log; must not be null.
     */
    private Goals(String dailyWaterGoal, String dailyCalorieGoal,
                  String weightGoal, String weeklyWeightProgress, String date) {
        super(date, "goals");

        assert dailyWaterGoal != null : "Daily water goal should not be null";
        assert dailyCalorieGoal != null : "Daily calorie goal should not be null";
        assert weightGoal != null : "Weight goal should not be null";
        assert weeklyWeightProgress != null : "Weekly weight progress should not be null";

        this.dailyWaterGoal = dailyWaterGoal;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.weightGoal = weightGoal;
        this.weeklyWeightProgress = weeklyWeightProgress;
    }

    /**
     * Returns the singleton instance of Goals. If no instance exists, a new one is created with default values.
     *
     * @return the singleton Goals instance.
     */
    public static Goals getInstance() {
        if (instance == null) {
            instance = new Goals("-", "-", "-", "0", "0");
        }
        return instance;
    }

    /**
     * Updates the goals with the specified water, calorie, and weight values.
     *
     * @param water   the new daily water goal.
     * @param calorie the new daily calorie goal.
     * @param weight  the new weight goal.
     */
    public void updateGoals(String water, String calorie, String weight){
        this.dailyWaterGoal = water;
        this.dailyCalorieGoal = calorie;
        this.weightGoal = weight;
    }

    /**
     * Sets the daily water goal.
     *
     * @param dailyWaterGoal the daily water goal.
     */
    public void setDailyWaterGoal(String dailyWaterGoal) {
        this.dailyWaterGoal = dailyWaterGoal;
    }

    /**
     * Sets the daily calorie goal.
     *
     * @param dailyCalorieGoal the daily calorie goal.
     */
    public void setDailyCalorieGoal(String dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    /**
     * Sets the weight goal.
     *
     * @param weightGoal the weight goal.
     */
    public void setWeightGoal(String weightGoal) {
        this.weightGoal = weightGoal;
    }

    /**
     * Sets the weekly weight progress.
     *
     * @param weeklyWeightProgress the weekly weight progress.
     */
    public void setWeeklyWeightProgress(String weeklyWeightProgress) {
        this.weeklyWeightProgress = weeklyWeightProgress;
    }

    /**
     * Returns the daily water goal.
     *
     * @return the daily water goal.
     */
    public String getDailyWaterGoal() {
        return dailyWaterGoal;
    }

    /**
     * Returns the daily calorie goal.
     *
     * @return the daily calorie goal.
     */
    public String getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    /**
     * Returns the weight goal.
     *
     * @return the weight goal.
     */
    public String getWeightGoal() {
        return weightGoal;
    }

    /**
     * Returns the weekly weight progress.
     *
     * @return the weekly weight progress.
     */
    public String getWeeklyWeightProgress() {
        return weeklyWeightProgress;
    }

    /**
     * Returns a string representation of the goals.
     * If a goal is set to "0", it indicates that the goal is not set yet.
     *
     * @return a formatted string representing the current goals.
     */
    public String toString() {
        Goals goal = Goals.getInstance();
        String finalString;
        if (goal.getDailyWaterGoal().matches("-")) {
            finalString = "    Daily Water Goal: Not set yet\n";
        } else {
            finalString = "    Daily Water Goal: " + goal.getDailyWaterGoal() + " ml\n";
        }

        if (goal.getDailyCalorieGoal().matches("-")) {
            finalString += "    Daily Calorie Goal: Not set yet\n";
        } else {
            finalString += "    Daily Calorie Goal: " + goal.getDailyCalorieGoal() + " cal\n";
        }
        if (goal.getWeightGoal().matches("-")) {
            finalString += "    Weight Goal: Not set yet\n";
        } else {
            finalString += "    Weight Goal: " + goal.getWeightGoal() + " kg\n";
        }
        return finalString;
    }
}
