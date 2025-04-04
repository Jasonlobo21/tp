package seedu.healthbud.exception;


public class InvalidWaterException extends Exception {

    public InvalidWaterException() {
        super("Invalid water command (e.g. add water /ml <volume> /t <time> /d <DD/MM/YYYY>)");
    }
}
