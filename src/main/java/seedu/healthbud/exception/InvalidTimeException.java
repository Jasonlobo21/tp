package seedu.healthbud.exception;

public class InvalidTimeException extends RuntimeException {
    public InvalidTimeException() {
        super("Invalid time format. Please use the 24 hour format (HHmm).");
    }
}
