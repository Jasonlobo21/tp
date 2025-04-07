package seedu.healthbud.exception;

public class EmptyTrackException extends RuntimeException {
    public EmptyTrackException() {
        super("Goals has not been set for the day, please enter another day or add goals.");
    }
}
