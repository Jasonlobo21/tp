package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid clear command.
 */
public class InvalidClearException extends RuntimeException {
    /**
     * Constructs an InvalidClearException with a default error message.
     */
    public InvalidClearException() {
        super("Invalid clear command (e.g. clear <pb|meal|workout|water|cardio>)");
    }
}
