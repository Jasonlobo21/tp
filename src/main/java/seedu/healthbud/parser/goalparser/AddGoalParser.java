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
    public static AddGoalCommand parse(LogList goalLogs, String input) throws InvalidGoalException, HealthBudException {
        assert input != null : "Input should not be null";

        input = input.substring("add goal".length()).trim();
        Map<String, String> param = ParserParameters.parseParameters(input);

        if (!param.containsKey("ml") && !param.containsKey("cal") && !param.containsKey("kg")) {
            throw new InvalidGoalException();
        }

        String water = param.containsKey("ml") ? param.get("ml") : Goals.getInstance().getDailyWaterGoal();
        String cal = param.containsKey("cal") ? param.get("cal") : Goals.getInstance().getDailyCalorieGoal();
        String weight = param.containsKey("kg") ? param.get("kg") : Goals.getInstance().getWeightGoal();

        try {
            int waterInt = Integer.parseInt(water);
            int calInt = Integer.parseInt(cal);
            int weightInt = Integer.parseInt(weight);

            if (waterInt <= 0 || waterInt > 5000 || calInt <= 0 || calInt > 20000 || weightInt <= 0 || weightInt > 400) {
                throw new HealthBudException("Goal values must be within valid ranges:\n"
                        + "- Water: 1–5000 ml\n"
                        + "- Calories: 1–20000 cal\n"
                        + "- Weight: 1–400 kg");
            }

            return new AddGoalCommand(goalLogs, String.valueOf(waterInt),
                    String.valueOf(calInt), String.valueOf(weightInt));
        } catch (NumberFormatException e) {
            throw new InvalidParameterException();
        }
    }
}
