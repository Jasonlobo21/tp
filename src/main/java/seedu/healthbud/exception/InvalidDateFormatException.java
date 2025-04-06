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
                " - dd-MM-yyyy     (e.g., 25-12-2023)\n" +
                " - dd MM yy       (e.g., 25 12 23)\n" +
                " - dd MM yyyy     (e.g., 25 12 2023)\n" +
                " - ddMMyy         (e.g., 251123)\n" +
                " - ddMMyyyy       (e.g., 25112023)\n" +
                " - dd MMM yy      (e.g., 25 Dec 23)\n" +
                " - dd MMM yyyy    (e.g., 25 Dec 2023)\n" +
                " - dd MMMM yy     (e.g., 25 December 23)\n" +
                " - dd MMMM yyyy   (e.g., 25 December 2023)\n" +
                " - MMM dd, yyyy   (e.g., Dec 25, 2023)\n" +
                " - MMMM dd, yyyy  (e.g., December 25, 2023)\n" +
                " - MMM dd yyyy    (e.g., Dec 25 2023)\n" +
                " - MMM dd, yy     (e.g., Dec 25, 23)");
    }
}
