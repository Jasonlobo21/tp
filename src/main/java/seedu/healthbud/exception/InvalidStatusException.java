package seedu.healthbud.exception;

/**
 * Exception thrown when an invalid status command is encountered.
 * The command must follow the format: status change <cutting/bulking> or status report <date>
 */
public class InvalidStatusException extends Exception {

    /**
     * Constructs a new InvalidStatusException with a default error message.
     */
    public InvalidStatusException() {
        super("Invalid status command - status change <cutting/bulking> or status report <date>");
    }
}
