package seedu.healthbud.parser;

import seedu.healthbud.LogList;



public abstract class BaseParser {
    protected LogList goalLogs;
    protected LogList pbLogs;
    protected LogList mealLogs;
    protected LogList workoutLogs;
    protected LogList waterLogs;
    protected LogList cardioLogs;

    public BaseParser(LogList goalLogs, LogList pbLogs, LogList mealLogs,
                      LogList workoutLogs, LogList waterLogs, LogList cardioLogs) {
        this.goalLogs = goalLogs;
        this.pbLogs = pbLogs;
        this.mealLogs = mealLogs;
        this.workoutLogs = workoutLogs;
        this.waterLogs = waterLogs;
        this.cardioLogs = cardioLogs;
    }

    public abstract boolean handleInput(String input);
}