package seedu.healthbud.exception;

/**
 * Exception thrown when an invalid sum command is encountered.
 * The command must follow the format: sum <cal|vol> /d <date>
 */
public class InvalidSumException extends Exception {

    /**
     * Constructs a new InvalidTrackException with a default error message.
     */
    public InvalidSumException() {
        super("Invalid sum command - sum <cal|vol> /d <date>");
    }
}
