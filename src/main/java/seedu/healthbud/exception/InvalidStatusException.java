package seedu.healthbud.exception;
/**
 * Exception thrown when the user inputs an invalid status-related command.
 * <p>
 *
 */
public class InvalidStatusException extends Exception {
    /**
     * Constructs an {@code InvalidStatusException} with a default message
     * describing the correct format for status-related commands.
     */
    public InvalidStatusException() {
        super("Invalid status command (e.g. status change <cutting/bulking> or status report <DD/MM/YYYY>)");
    }
}
