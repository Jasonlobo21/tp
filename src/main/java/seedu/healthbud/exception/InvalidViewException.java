package seedu.healthbud.exception;

public class InvalidViewException extends RuntimeException {
    public InvalidViewException() {
        super("Invalid command! To view Goals, please use the command 'view goals'.\n");
    }
}
