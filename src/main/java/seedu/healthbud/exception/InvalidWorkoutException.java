package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid format for the workout log command.
 * <p>
 */
public class InvalidWorkoutException extends Exception {

    /**
     * Constructs an {@code InvalidWorkoutException} with a default message
     * indicating the correct usage of the workout log command.
     */
    public InvalidWorkoutException() {
        super("Invalid workout log command (e.g. add workout <exercise> /w <weight> /r " +
                "<reps> /s <sets> /d <DD/MM/YYYY>)");
    }
}
