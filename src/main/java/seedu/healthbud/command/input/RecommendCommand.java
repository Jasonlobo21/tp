package seedu.healthbud.command.input;

import seedu.healthbud.Ui;
import seedu.healthbud.command.InputCommand;

/**
 * RecommendCommand is responsible for displaying workout recommendations.
 * It encapsulates a recommendation message which is printed when the command is executed.
 */
public class RecommendCommand extends InputCommand {

    private final String list;

    /**
     * Constructs a RecommendCommand with the specified recommendation message.
     *
     * @param list the recommendation message; must not be null.
     */
    public RecommendCommand(String list) {
        super(list);
        this.list = list;
    }

    /**
     * Returns the recommendation message.
     *
     * @return the recommendation message.
     */
    public String getMessage() {
        return list;
    }

    /**
     * Executes the recommend command by printing the recommendation message using the UI.
     */
    @Override
    public void execute() {
        Ui.printMessage(list);
    }
}
