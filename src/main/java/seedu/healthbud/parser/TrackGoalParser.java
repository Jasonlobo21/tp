package seedu.healthbud.parser;

import seedu.healthbud.Ui;
import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.SumCommand;
import seedu.healthbud.log.Goals;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidTrackException;
import static seedu.healthbud.HealthBud.mealLogs;
import static seedu.healthbud.HealthBud.waterLogs;



public class TrackGoalParser {
    Goals goal = Goals.getInstance();
    Command command;
    LogList loglist;
    public void parse(String input) throws InvalidTrackException {
        String[] parts = input.trim().split(" ");

        if (parts.length < 3) {
            throw new InvalidTrackException();
        }
        String date = parts[3];
        int sumWater = loglist.getWaterSum(date);
        int sumCal = loglist.getCaloriesSum(date);
        Ui.printMessage("Your progress for that day are as follows\n");
        Ui.printMessage("Total Water: " + sumWater);
        Ui.printMessage("Total Calories: " + sumCal);
    }
}
