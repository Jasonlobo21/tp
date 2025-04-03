package seedu.healthbud.log;

/**
 * The Log class represents a generic log entry with a log type and date.
 * It serves as the base class for all specific log types in the HealthBud application.
 */
public class Log {

    private String logType;
    private String date;

    /**
     * Constructs a new Log with the specified date and log type.
     *
     * @param date    the date of the log; must not be null.
     * @param logType the type of the log; must not be null.
     */
    public Log(String date, String logType) {
        assert date != null : "Date should not be null";
        assert logType != null : "Log type should not be null";

        this.date = date;
        this.logType = logType;
    }

    /**
     * Returns the type of the log.
     *
     * @return the log type as a String.
     */
    public String getLogType() {
        return logType;
    }

    /**
     * Returns the date of the log.
     *
     * @return the date as a String.
     */
    public String getDate() {
        return date;
    }

}
