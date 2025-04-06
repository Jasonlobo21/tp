package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid date format.
 */
public class InvalidDateFormatException extends Exception {

    /**
     * Constructs an InvalidDateFormatException with a default error message.
     */
    public InvalidDateFormatException() {
        super("Date is valid but does not follow accepted formats. Please use one of the following:\n" +
                " - dd/MM/yy       (e.g., 12/11/25)\n" +
                " - dd/MM/yyyy     (e.g., 25/12/2023)\n" +
                " - dd-MM-yy       (e.g., 12-11-23)\n" +
                " - dd-MM-yyyy     (e.g., 25-12-2023)");
    }
}
