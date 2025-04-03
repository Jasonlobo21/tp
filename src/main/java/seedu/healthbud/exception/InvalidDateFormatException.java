package seedu.healthbud.exception;

import java.util.List;

public class InvalidDateFormatException extends Exception {

    public InvalidDateFormatException() {
        super("Invalid date, try DD/MM/YYYY");
    }
}
