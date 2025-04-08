package seedu.healthbud.exception;
/**
 * Exception thrown when the user inputs an invalid format for the sum command.
 * <p>
 */
public class InvalidSumException extends Exception {
    /**
     * Constructs an {@code InvalidSumException} with a default message
     * describing the correct usage of the sum command.
     */
    public InvalidSumException() {
        super("Invalid sum command (e.g. sum <cardio|cal|vol> /d <DD/MM/YYYY>)");
    }
}
