package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid format for the view goals command.
 * <p>
 */
public class InvalidViewException extends RuntimeException {
    /**
     * Constructs an {@code InvalidViewException} with a default message
     * indicating the correct usage of the view goals command.
     */
    public InvalidViewException() {
        super("Invalid view goals command (e.g. view goal)");
    }
}
