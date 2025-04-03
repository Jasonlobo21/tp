package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid date format.
 */
public class InvalidDateException extends RuntimeException {
    /**
     * Constructs an InvalidDateException with a default error message.
     */
    public InvalidDateException() {
        super("Invalid date format! Please enter a valid date in the format: dd-MM-yyyy");
    }
}
