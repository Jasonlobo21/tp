package seedu.healthbud.command;

import seedu.healthbud.LogList;

public abstract class Command {
    public abstract void execute(LogList mealLogs, LogList workoutLogs, String input) throws Exception;
}
