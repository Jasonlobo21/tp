package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid personal best command.
 */
public class InvalidPersonalBestException extends RuntimeException {

    /**
     * Constructs an InvalidPersonalBestException with a default error message.
     */
    public InvalidPersonalBestException() {
        super("Invalid pb log command (e.g. add pb <exercise> /w <weight_in_kg> /d <DD/MM/YYYY>)");
    }
}
