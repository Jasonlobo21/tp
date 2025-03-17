package seedu.healthbud.exception;

public class  InvalidWorkoutException extends Exception {
    public InvalidWorkoutException() {
        super("Invalid add command (e.g. add <date> /e <exercise> /r <no. of reps> /s <no. of sets>)");
    }
}


