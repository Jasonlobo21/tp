package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid date format.
 */
public class InvalidDateFormatException extends Exception {

    /**
     * Constructs an InvalidDateFormatException with a default error message.
     */
    public InvalidDateFormatException() {
        super("Invalid date, try DD/MM/YYYY");
    }
}
