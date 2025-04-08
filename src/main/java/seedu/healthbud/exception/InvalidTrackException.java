package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid format for the track command.
 * <p>
 */
public class InvalidTrackException extends RuntimeException {

    /**
     * Constructs an {@code InvalidTrackException} with a default message
     * indicating the correct usage of the track command.
     */
    public InvalidTrackException() {
        super("Invalid track command (e.g. track goal /d <DD/MM/YYYY>)");
    }
}
