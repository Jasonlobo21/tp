package seedu.healthbud.log;

/**
 * The Meal class represents a meal log entry.
 * It stores details about the meal including its name, calorie count, and the time the meal was logged.
 * This class extends the Log class.
 */
public class Meal extends Log {

    private String name;
    private String calories;
    private String time;

    /**
     * Constructs a new Meal log with the specified details.
     *
     * @param name     the name of the meal; must not be null.
     * @param calories the calorie count of the meal; must not be null.
     * @param date     the date of the meal log; must not be null.
     * @param time     the time at which the meal was logged; must not be null.
     */
    public Meal(String name, String calories, String date, String time){
        super(date, "meal");
        assert name != null : "Meal name should not be null";
        assert calories != null : "Calories should not be null";
        assert time != null : "Time should not be null";
        this.name = name;
        this.calories = calories;
        this.time = time;
    }

    /**
     * Returns the name of the meal.
     *
     * @return the meal name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the calorie count of the meal.
     *
     * @return the calories as a string.
     */
    public String  getCalories() {
        return calories;
    }

    /**
     * Returns the time at which the meal was logged.
     *
     * @return the time as a string.
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns a string representation of the meal log.
     * The format is: "meal name (calories cal) on: date at: time".
     *
     * @return a formatted string representing the meal log.
     */
    @Override
    public String toString() {
        return String.format("%s (%s cal) on: %s at: %s", name, calories, getDate(), time);
    }
}
