package seedu.healthbud.log;

/**
 * The Cardio class represents a cardio log entry.
 * It stores details about a cardio exercise including the exercise name, speed, incline, and duration.
 * This class extends the Log class.
 */
public class Cardio extends Log{

    private String name;
    private String duration;
    private String incline;
    private String speed;

    /**
     * Constructs a new Cardio log with the specified details.
     *
     * @param name     the name of the cardio exercise; must not be null.
     * @param speed    the speed during the cardio exercise; must not be null.
     * @param incline  the incline level during the cardio exercise; must not be null.
     * @param duration the duration of the cardio exercise (in minutes); must not be null.
     * @param date     the date of the cardio log; must not be null.
     */
    public Cardio(String name, String speed, String incline, String duration, String date) {
        super(date, "cardio");

        assert name != null : "Name should not be null";
        assert speed != null : "Speed should not be null";
        assert incline != null : "Incline should not be null";
        assert duration != null : "Duration should not be null";

        this.name = name;
        this.duration = duration;
        this.incline = incline;
        this.speed = speed;
    }

    /**
     * Returns the name of the cardio exercise.
     *
     * @return the exercise name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the duration of the cardio exercise.
     *
     * @return the duration as a string.
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Returns the incline level during the cardio exercise.
     *
     * @return the incline as a string.
     */
    public String getIncline() {
        return incline;
    }

    /**
     * Returns the speed during the cardio exercise.
     *
     * @return the speed as a string.
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * Returns a string representation of the cardio log.
     * The format is: "name (speed: speed, incline: incline, duration: duration mins) on date".
     *
     * @return a formatted string representing the cardio log.
     */
    @Override
    public String toString() {
        return name  + " (speed: " + speed + ", incline: " + incline + ", duration: " + duration + " mins) on " +
                getDate();

    }
}
