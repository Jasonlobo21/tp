package seedu.healthbud.exception;

public class InvalidSumException extends Exception {

    public InvalidSumException() {
        super("Invalid sum command (e.g. sum <cardio|cal|vol> /d <DD/MM/YYYY>)");
    }
}
