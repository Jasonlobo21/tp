package seedu.healthbud.command;

// FOR COMMANDS THAT OINLY NEED INPUT AND NO NEED LOGS AT ALL
/**
 * Abstract base class for commands that require only an input string.
 * This class provides a common structure for commands that do not need any LogLists.
 */
public abstract class InputCommand implements Command {
    protected String input;

    /**
     * Constructs an InputCommand with the specified input string.
     *
     * @param input the input string; must not be null.
     */
    public InputCommand(String input) {
        assert input != null : "Input should not be null";
        this.input = input;
    }
}

