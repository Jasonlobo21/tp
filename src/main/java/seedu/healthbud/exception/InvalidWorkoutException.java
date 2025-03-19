package seedu.healthbud.exception;

public class InvalidWorkoutException extends Exception {
    public InvalidWorkoutException() {
        super("Invalid add command (add <exercise> /r <reps> /s <sets> /d <date>)");
    }
}
