package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid format for the water log command.
 * <p>
 */
public class InvalidWaterException extends Exception {

    /**
     * Constructs an {@code InvalidWaterException} with a default message
     * indicating the correct usage of the water log command.
     */
    public InvalidWaterException() {
        super("Invalid water log command (e.g. add water /ml <volume> /t <HHmm> /d <DD/MM/YYYY>)");
    }
}
