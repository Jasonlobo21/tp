package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid cardio log command.
 */
public class InvalidCardioException extends RuntimeException {

    /**
     * Constructs an InvalidCardioException with a default error message.
     */
    public InvalidCardioException() {
        super("Invalid cardio log command (e.g. add cardio <exercise> /s <speed> /i " +
                "<incline> /t <duration_in_mins> /d <date>)");
    }
}
