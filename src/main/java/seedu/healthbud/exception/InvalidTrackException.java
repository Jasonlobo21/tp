package seedu.healthbud.exception;

public class InvalidTrackException extends RuntimeException {

    public InvalidTrackException() {
        super("Invalid track command (e.g. track goal /d <DD/MM/YYYY>)");
    }
}
