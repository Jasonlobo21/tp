package seedu.healthbud.command;

/**
 * The Command interface represents a command that can be executed in the HealthBud application.
 * All commands must implement the execute method.
 */
public interface Command {

    /**
     * Executes the command.
     *
     * @throws Exception if an error occurs during the execution of the command.
     */
    void execute() throws Exception;
}

