package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid list command.
 */
public class InvalidListException extends Exception {
    /**
     * Constructs an InvalidListException with a default error message.
     */
    public InvalidListException() {
        super("Invalid list command (e.g. list <pb/meal/workout/water/cardio>)");

    }
}
