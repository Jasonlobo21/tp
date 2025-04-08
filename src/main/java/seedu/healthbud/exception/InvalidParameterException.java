package seedu.healthbud.exception;
/**
 * Exception thrown when a command is executed with an invalid or unrecognized parameter.
 */
public class InvalidParameterException extends RuntimeException {
    /**
     * Constructs an {@code InvalidParameterException} with a default error message
     * indicating that the user has provided an invalid parameter.
     */
    public InvalidParameterException() {
        super("Invalid parameter inputted, please add a valid parameter");
    }
}
