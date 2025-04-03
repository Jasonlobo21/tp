package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid BMI command.
 */
public class  InvalidBMIException extends Exception {

    /**
     * Constructs an InvalidBMIException with a default error message.
     */
    public InvalidBMIException() {
        super("Invalid BMI command (e.g. bmi /w <weight_in_kg> /h <height_in_m>)");
    }
}

