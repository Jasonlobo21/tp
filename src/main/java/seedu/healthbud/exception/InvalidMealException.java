package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid meal command.
 */
public class  InvalidMealException extends Exception {
    /**
     * Constructs an InvalidMealException with a default error message.
     */
    public InvalidMealException() {
        super("Invalid meal log command (e.g. add meal <meal_name> /cal <calories> /d <DD/MM/YYYY> /t <HHmm>)");
    }
}
