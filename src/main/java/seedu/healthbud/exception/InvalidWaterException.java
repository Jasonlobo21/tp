package seedu.healthbud.exception;


public class InvalidWaterException extends Exception {

    public InvalidWaterException() {
        super("Invalid water log command (e.g. add water /ml <volume> /t <HHmm> /d <DD/MM/YYYY>)");
    }
}
