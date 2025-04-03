package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid add log command.
 */
public class InvalidAddLogException extends Exception {

    /**
     * Constructs an InvalidAddLogException with a default error message.
     */
    public InvalidAddLogException() {
        super("Invalid log command (e.g. add pb/meal/workout/water/goal)");
    }
}
