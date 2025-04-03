package seedu.healthbud.exception;

/**
 * Exception thrown when an invalid tracking command is encountered.
 * The tracking command should follow the format: track goal /d <date>
 */
public class InvalidTrackException extends RuntimeException {

    /**
     * Constructs a new InvalidTrackException with a default error message.
     */
    public InvalidTrackException() {
        super("Unable to Track, Please enter a valid tracking command in the form of - track goal /d <date>");
    }
}
