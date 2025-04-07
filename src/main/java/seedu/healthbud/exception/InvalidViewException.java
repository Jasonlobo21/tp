package seedu.healthbud.exception;

public class InvalidViewException extends RuntimeException {
    public InvalidViewException() {
        super("Invalid view goals command (e.g. view goal)");
    }
}
