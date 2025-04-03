package seedu.healthbud.log;

/**
 * The Workout class represents a workout log entry.
 * It stores details about a workout such as the exercise name, number of repetitions,
 * number of sets, and the weight used during the workout.
 * This class extends the Log class.
 */
public class Workout extends Log {
    private String name;
    private String reps;
    private String sets;
    private String weight;

    /**
     * Constructs a new Workout log with the specified details.
     *
     * @param name   the name of the workout exercise; must not be null.
     * @param reps   the number of repetitions; must not be null.
     * @param sets   the number of sets; must not be null.
     * @param date   the date of the workout; must not be null.
     * @param weight the weight used during the workout (in kg); must not be null.
     */
    public Workout(String name, String reps, String sets, String date, String weight) {
        super(date, "workout");

        assert name != null : "Workout name should not be null";
        assert reps != null : "Reps should not be null";
        assert sets != null : "Sets should not be null";
        assert weight != null : "Weight should not be null";

        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
    }

    /**
     * Returns the name of the workout exercise.
     *
     * @return the workout name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of repetitions.
     *
     * @return the reps.
     */
    public String getReps() {
        return reps;
    }

    /**
     * Returns the number of sets.
     *
     * @return the sets.
     */
    public String getSets() {
        return sets;
    }

    /**
     * Returns the weight used during the workout.
     *
     * @return the weight.
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Returns a string representation of the workout log.
     * The format is: "name (sets sets of weight kg for reps reps) on date".
     *
     * @return a formatted string representing the workout.
     */
    @Override
    public String toString() {
        return String.format("%s (%s sets of %s kg for %s reps) on %s", name, sets,weight ,reps, getDate());
    }
}
