package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid recommend command.
 */
public class InvalidRecommendException extends Exception {

    /**
     * Constructs an InvalidRecommendException with a default error message.
     */
    public InvalidRecommendException() {
        super("Invalid recommend command (e.g. recommend <chest/back/biceps/triceps/legs/shoulders/abs>)");
    }
}
