package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.command.SingleLogCommand;

public class SearchCommand extends SingleLogCommand {
    private final String date;      // null if searching by keyword
    private final String keyword;   // null if searching by date

    public SearchCommand(LogList logList, String date, String keyword) {
        super(logList);
        this.date = date;
        this.keyword = keyword;
    }

    @Override
    public void execute() {
        // Check if both or neither param is provided => invalid
        if ((date != null && keyword != null) || (date == null && keyword == null)) {
            Ui.printMessage("Invalid search parameters. Provide either /d <date> or /k <keyword>, but not both.");
            return;
        }

        if (date != null) {
            // Search by date
            Ui.printMessage("Showing logs for date: " + date);
            boolean foundAny = printLogsForDate(super.logList, date);
            if (!foundAny) {
                Ui.printMessage("No logs found for this date.");
            }
        } else {
            // Search by keyword
            Ui.printMessage("Showing logs containing keyword: " + keyword);
            super.logList.findLog(keyword);
        }
    }

    private boolean printLogsForDate(LogList logs, String date) {
        boolean found = false;
        for (int i = 0; i < logs.getSize(); i++) {
            if (logs.getLog(i).getDate().equals(date)) {
                Ui.printMessage(logs.getLog(i).toString());
                found = true;
            }
        }
        return found;
    }
}
