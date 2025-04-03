package seedu.healthbud.exception;

/**
 * Exception thrown when an invalid water command is encountered.
 * The command must follow the format:
 * add water /v <volume> /t <time> /d <DD/MM/YYYY>
 */
public class InvalidWaterException extends Exception {

    /**
     * Constructs a new InvalidWorkoutException with a default error message.
     */
    public InvalidWaterException() {
        super("Invalid water command (e.g. add water /v <volume> /t <time> /d <DD/MM/YYYY>)");
    }
}
