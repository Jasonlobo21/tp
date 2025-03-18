package seedu.healthbud.exception;

public class InvalidWorkoutException extends Exception {
    public InvalidWorkoutException() {
        super("Invalid add command (add <date> /e <exercise> /r <reps> /s <sets>)");
    }
}
