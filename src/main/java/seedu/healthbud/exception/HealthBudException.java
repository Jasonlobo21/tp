package seedu.healthbud.exception;

public class HealthBudException extends RuntimeException {
    public HealthBudException(String message) {
        super("    Error: " + message);
    }
}
