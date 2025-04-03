package seedu.healthbud.log;

/**
 * The PersonalBest class represents a personal best log entry.
 * It stores details about an exercise and the weight achieved, along with the date.
 * This class extends the Log class.
 */
public class PersonalBest extends Log {

    private String exercise;
    private String weight;

    /**
     * Constructs a new PersonalBest log with the specified exercise, weight, and date.
     *
     * @param exercise the name of the exercise; must not be null.
     * @param weight   the weight achieved (in kg); must not be null.
     * @param date     the date of the personal best log; must not be null.
     */
    public PersonalBest(String exercise, String weight, String date){
        super(date, "pb");

        assert exercise != null : "Exercise should not be null";
        assert weight != null : "Weight should not be null";

        this.exercise = exercise;
        this.weight = weight;
    }

    /**
     * Returns the exercise name.
     *
     * @return the exercise name.
     */
    public String getExercise() {
        return exercise;
    }

    /**
     * Returns the weight achieved.
     *
     * @return the weight in kg.
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Returns a string representation of the personal best log.
     * The format is: " exercise weight kg on (date)".
     *
     * @return a formatted string representing the personal best log.
     */
    @Override
    public String toString() {
        return String.format(" %s %s kg on (%s)", exercise, weight, getDate());
    }
}
