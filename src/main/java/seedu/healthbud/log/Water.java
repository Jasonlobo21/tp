package seedu.healthbud.log;

/**
 * The Water class represents a water log entry.
 * It stores details about the water consumption including the amount (in milliliters)
 * and the time of consumption.
 * This class extends the Log class.
 */
public class Water extends Log {

    private String amount;
    private String time;

    /**
     * Constructs a new Water log with the specified amount, date, and time.
     *
     * @param amount the amount of water consumed (in milliliters); must not be null.
     * @param date   the date of the water log; must not be null.
     * @param time   the time at which the water was consumed; must not be null.
     */
    public Water(String amount, String date, String time){
        super(date, "water");

        assert amount != null : "Amount should not be null";
        assert time != null : "Time should not be null";

        this.amount = amount;
        this.time = time;
    }

    /**
     * Returns the amount of water consumed.
     *
     * @return the amount in milliliters.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Returns the time at which the water was consumed.
     *
     * @return the consumption time.
     */
    public String getTime() {
        return time;
    }

    /**
     * Converts the given water amount (in milliliters) into glasses.
     * Assumes that one glass is 250 ml.
     *
     * @param amount the water amount in milliliters.
     * @return a formatted string representing the number of glasses.
     */
    public String toGlass(String amount) {
        double ml = Double.parseDouble(amount.trim());
        double glasses = ml / 250.0;
        return String.format("%.1f glass", glasses);
    }

    /**
     * Returns a string representation of the water log.
     * The format is: "X glass of water on (date) at time".
     *
     * @return a formatted string representing the water log.
     */
    @Override
    public String toString() {
        return String.format("%s (%sml) of water on (%s) at %s", toGlass(amount),amount, getDate(), time);
    }

}
