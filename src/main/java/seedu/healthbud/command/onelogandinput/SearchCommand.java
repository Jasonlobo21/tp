package seedu.healthbud.command.alllogsandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidDateFormatException;

public class SearchCommand extends AllLogsCommand {

    private final String logType;
    private final String date;     // non-null if searching by date
    private final String keyword;  // non-null if searching by keyword

    public SearchCommand(String input, String logType, String date, String keyword,
                         LogList goalLogs, LogList pbLogs, LogList mealLogs,
                         LogList workoutLogs, LogList waterLogs, LogList cardioLogs) {
        super(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
        this.logType = logType;
        this.date = date;
        this.keyword = keyword;
    }

    @Override
    public void execute() throws InvalidDateFormatException {
        LogList targetLogs = getTargetLogList();
        if (targetLogs == null) {
            Ui.printMessage("Invalid log type. Available types: goal, pb, meal, workout, water, cardio.");
            return;
        }

        String label = getLabelForLogType();
        if (date != null) {
            Ui.printMessage("Showing " + label + " logs for date: " + date);
            boolean found = printLogsForDate(targetLogs, label, date);
            if (!found) {
                Ui.printMessage("No " + label + " logs found for this date.");
            }
        } else if (keyword != null) {
            Ui.printMessage("Showing " + label + " logs containing keyword: " + keyword);
            boolean found = printLogsForKeyword(targetLogs, label, keyword);
            if (!found) {
                Ui.printMessage("No " + label + " logs found containing the keyword.");
            }
        } else {
            Ui.printMessage("Invalid search parameters. Provide either a date or a keyword.");
        }
    }

    private LogList getTargetLogList() {
        switch (logType.toLowerCase()) {
        case "goal":    return goalLogs;
        case "pb":      return pbLogs;
        case "meal":    return mealLogs;
        case "workout": return workoutLogs;
        case "water":   return waterLogs;
        case "cardio":  return cardioLogs;
        default:        return null;
        }
    }

    private String getLabelForLogType() {
        switch (logType.toLowerCase()) {
        case "goal":    return "Goal";
        case "pb":      return "PB";
        case "meal":    return "Meal";
        case "workout": return "Workout";
        case "water":   return "Water";
        case "cardio":  return "Cardio";
        default:        return "Unknown";
        }
    }

    private boolean printLogsForDate(LogList logs, String label, String date) {
        boolean found = false;
        for (int i = 0; i < logs.getSize(); i++) {
            if (logs.getLog(i).getDate().equals(date)) {
                Ui.printMessage(label + ": " + logs.getLog(i).toString());
                found = true;
            }
        }
        return found;
    }

    private boolean printLogsForKeyword(LogList logs, String label, String keyword) {
        boolean found = false;
        String lowerKeyword = keyword.toLowerCase();
        for (int i = 0; i < logs.getSize(); i++) {
            String logString = logs.getLog(i).toString().toLowerCase();
            System.out.println("DEBUG: Checking => " + logString);
            if (logString.contains(lowerKeyword)) {
                Ui.printMessage(label + ": " + logs.getLog(i).toString());
                found = true;
            }
        }

        return found;
    }
}
