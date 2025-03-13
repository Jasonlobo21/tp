package seedu.healthbud.exception;

public class InvalidWorkoutReccException extends Exception{
    public InvalidWorkoutReccException() {
        super("Invalid workout recommend command (e.g., recommend /m biceps)");
    }
}
