package seedu.healthbud.exception;
/**
 * Exception thrown when a time string is not in the expected 24-hour format.
 * <p>
 */
public class InvalidTimeException extends RuntimeException {
    /**
     * Constructs an {@code InvalidTimeException} with a default error message
     * indicating the correct 24-hour time format.
     */
    public InvalidTimeException() {
        super("Invalid time format. Please use the 24 hour format (HHmm).");
    }
}
