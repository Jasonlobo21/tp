package seedu.healthbud.exception;

public class InvalidWaterException extends Exception {
    public InvalidWaterException() {
        super("Invalid water command (e.g. add water /d <DD/MM/YYYY> /t <time> /v <volume>)");
    }
}
