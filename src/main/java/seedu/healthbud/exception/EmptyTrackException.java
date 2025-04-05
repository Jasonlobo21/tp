package seedu.healthbud.exception;

public class EmptyTrackException extends RuntimeException {
    public EmptyTrackException() {
        super("No Logs for that day! Please try another day or add a log");
    }
}
