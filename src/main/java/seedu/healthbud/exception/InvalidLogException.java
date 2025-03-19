package seedu.healthbud.exception;

public class InvalidLogException extends Exception {
    public InvalidLogException() {
        super("Invalid log input (e.g., add <meal/workout/water>)");
    }
}
