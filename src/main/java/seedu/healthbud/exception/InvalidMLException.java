package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid water volume command.
 */
public class InvalidMLException extends RuntimeException {

    /**
     * Constructs an InvalidMLException with a default error message.
     */
    public InvalidMLException() {
        super("Invalid water volume inputted, please input a valid number (e.g. 250, 1000, 1250)");
    }
}
