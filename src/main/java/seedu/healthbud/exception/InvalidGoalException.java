package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid goal command.
 */
public class InvalidGoalException extends RuntimeException {
    /**
     * Constructs an InvalidGoalException with a default error message.
     */
    public InvalidGoalException() {
        super("Invalid goal log command (e,g, goal /goalcode <value>) \n " +
                "Here are the goal codes: \n" +
                "/cal - for calorie goal \n" +
                "/ml - for water intake goal \n" +
                "/kg - for body weight goal \n" +
                "It is not necessary for all parameters to be inputted at once.");
    }
}
