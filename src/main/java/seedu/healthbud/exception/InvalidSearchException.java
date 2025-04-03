package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid search command.
 */
public class InvalidSearchException extends RuntimeException {

    /**
     * Constructs an InvalidSearchException with a default error message.
     */
    public InvalidSearchException() {
        super("Invalid search command - Try search <logType> /d <date> OR search <logType> /k <keyword>");
    }
}
