package seedu.healthbud.exception;

/**
 * Exception thrown when an invalid workout command is encountered.
 * The command must follow the format:
 * add workout <exercise> /w <weight> /r <reps> /s <sets> /d <DD/MM/YYYY>
 */
public class InvalidWorkoutException extends Exception {

    /**
     * Constructs a new InvalidWorkoutException with a default error message.
     */
    public InvalidWorkoutException() {
        super("Invalid workout command (e.g. add workout <exercise> /w <weight> /r <reps> /s <sets> /d <DD/MM/YYYY>)");
    }
}
