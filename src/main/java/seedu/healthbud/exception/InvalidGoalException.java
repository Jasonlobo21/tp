package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid goal command.
 */
public class InvalidGoalException extends RuntimeException {
    /**
     * Constructs an InvalidGoalException with a default error message.
     */
    public InvalidGoalException() {
        super("Invalid Goal command. To change a goal, please enter /goalcode + value (e.g. /w 1000)");
    }
}
