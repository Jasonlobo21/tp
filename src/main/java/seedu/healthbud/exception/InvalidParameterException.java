package seedu.healthbud.exception;

public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException() {
        super("Invalid parameter inputted, please add a valid parameter");
    }
}
