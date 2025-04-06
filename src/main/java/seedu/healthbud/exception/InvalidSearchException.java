package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid search command.
 */
public class InvalidSearchException extends RuntimeException {

    /**
     * Constructs an InvalidSearchException with a default error message.
     */
    public InvalidSearchException() {
        super("Invalid search command (e.g. search <logType> /d <DD/MM/YYYY> OR search <logType> /k <keyword>)");
    }
}
