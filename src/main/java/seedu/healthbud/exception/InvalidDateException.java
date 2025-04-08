package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid date.
 */
public class InvalidDateException extends RuntimeException {

    /**
     * Constructs an InvalidDateException with a default error message.
     */
    public InvalidDateException() {
        super("Invalid date! Please enter a valid date that is not set in the future");
    }
}
