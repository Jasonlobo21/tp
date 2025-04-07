package seedu.healthbud.parser.goalparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddGoalCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.exception.InvalidParameterException;
import seedu.healthbud.log.Goals;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

/**
 * AddGoalParser is responsible for parsing the input command for adding a goal log.
 * It checks for missing parameters and appends default values from the Goals singleton before
 * returning an AddGoalCommand with the parsed goal values.
 */
public class AddGoalParser {
    //@@author keanneeee
    /**
     * Parses the input command for adding a goal and returns an AddGoalCommand.
     * The method first checks for a minimum number of parts in the input, then appends missing
     * parameters using default goal values if necessary. It then extracts the goal parameters
     * and creates a new AddGoalCommand.
     *
     * @param goalLogs the LogList for goal logs; must not be null.
     * @param input the input command string; must not be null.
     * @return an AddGoalCommand with the parsed water, calorie, and weight goal values.
     * @throws InvalidGoalException if the input format is invalid, parameters are missing,
     *                              or if any of the parameters are not numeric.
     */
    public static AddGoalCommand parse(LogList goalLogs, String input) throws InvalidGoalException, HealthBudException{
        assert input != null : "Input should not be null";

        input = input.substring("add goal".length()).trim();
        Map<String, String> param = ParserParameters.parseParameters(input);

        boolean hasValidKey = false;

        for (String key : param.keySet()) {
            if (key.equals("ml") || key.equals("cal") || key.equals("kg")) {
                hasValidKey = true;
            } else {
                throw new InvalidGoalException();
            }
        }

        if (!hasValidKey) {
            throw new InvalidGoalException();
        }


        String water = Goals.getInstance().getDailyWaterGoal();
        String cal = Goals.getInstance().getDailyCalorieGoal();
        String weight = Goals.getInstance().getWeightGoal();

        try {
            if (param.containsKey("ml")) {
                String raw = param.get("ml");
                int waterInt = Integer.parseInt(raw);
                if (waterInt <= 0 || waterInt > 5000) {
                    throw new HealthBudException("Water goal must be between 1 and 5000 ml.");
                }
                water = String.valueOf(waterInt);
            }

            if (param.containsKey("cal")) {
                String raw = param.get("cal");
                int calInt = Integer.parseInt(raw);
                if (calInt <= 0 || calInt > 20000) {
                    throw new HealthBudException("Calorie goal must be between 1 and 20000 cal.");
                }
                cal = String.valueOf(calInt);
            }

            if (param.containsKey("kg")) {
                String raw = param.get("kg");
                int weightInt = Integer.parseInt(raw);
                if (weightInt <= 0 || weightInt > 400) {
                    throw new HealthBudException("Weight goal must be between 1 and 400 kg.");
                }
                weight = String.valueOf(weightInt);
            }
            return new AddGoalCommand(goalLogs, water, cal, weight);
        } catch (NumberFormatException e) {
            throw new InvalidParameterException();
        }
    }
}
