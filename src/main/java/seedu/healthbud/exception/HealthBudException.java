package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid command.
 */
public class HealthBudException extends Exception{

    /**
     * Constructs a HealthBudException with a default error message.
     */
    public HealthBudException(String message) {
        super(message);
    }
}
