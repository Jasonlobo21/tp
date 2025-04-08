package seedu.healthbud.exception;

/**
 * Exception thrown when attempting to access or track daily goals
 * that have not been set for a specific day.
 */
public class EmptyTrackException extends RuntimeException {

    /**
     * Constructs an {@code EmptyTrackException} with a default error message
     * indicating that no goals have been set for the day.
     */
    public EmptyTrackException() {
        super("Goals has not been set for the day, please enter another day or add goals.");
    }
}
