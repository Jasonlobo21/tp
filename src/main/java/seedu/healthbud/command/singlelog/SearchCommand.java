package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;

/**
 * SearchCommand is responsible for searching logs by date or keyword.
 * If a date is provided, the command searches for logs matching that date;
 * otherwise, it searches for logs containing the specified keyword.
 */
public class SearchCommand extends SingleLogCommand {
    private final String date;      // null if searching by keyword
    private final String keyword;   // null if searching by date

    /**
     * Constructs a new SearchCommand with the specified LogList, date, and keyword.
     *
     * @param logList the LogList to search within; must not be null.
     * @param date    the date to search for, or null if searching by keyword.
     * @param keyword the keyword to search for, or null if searching by date.
     */
    public SearchCommand(LogList logList, String date, String keyword) {
        super(logList);
        this.date = date;
        this.keyword = keyword;
    }

    /**
     * Executes the search command.
     * If the date is not null, it searches for logs by date.
     * Otherwise, it searches for logs by the given keyword.
     */
    @Override
    public void execute() {

        if (date != null) {
            logList.findLogByDate(date);
        } else {
            logList.findLog(keyword);
        }
    }
}
