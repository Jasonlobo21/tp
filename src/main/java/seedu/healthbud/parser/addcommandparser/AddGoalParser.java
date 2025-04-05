package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddGoalCommand;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.log.Goals;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

/**
 * AddGoalParser is responsible for parsing the input command for adding a goal log.
 * It checks for missing parameters and appends default values from the Goals singleton before
 * returning an AddGoalCommand with the parsed goal values.
 */
public class AddGoalParser {
    static Goals goal = Goals.getInstance();

    /**
     * Adds missing goal parameters to the input string if they are not present.
     * If the input does not contain the calorie (/cal), water (/w), or weight (/kg) parameter,
     * the default value from the Goals instance is appended.
     *
     * @param input the input string for adding a goal.
     * @return the modified input string with all required parameters.
     */
    private static String addMissingParameters(String input) {
        if (!input.contains("/cal")) {
            input += " /cal " + Goals.getInstance().getDailyCalorieGoal();
        }
        if (!input.contains("/w")) {
            input += " /w " + Goals.getInstance().getDailyWaterGoal();
        }
        if (!input.contains("/kg")) {
            input += " /kg " + Goals.getInstance().getWeightGoal();
        }
        return input;
    }

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
    public static AddGoalCommand parse(LogList goalLogs, String input) throws InvalidGoalException {
        assert input != null : "Input should not be null";
        String[] parts = input.trim().split(" ");

        if (parts.length <= 3) {
            throw new InvalidGoalException();
        }

        input = addMissingParameters(input);
        input = input.substring("add goal".length()).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (!param.get("cal").matches("\\d+") || !param.get("w").matches("\\d+")
                || !param.get("kg").matches("\\d+")) {
            throw new InvalidGoalException();
        }
        return new AddGoalCommand(goalLogs, param.get("w"), param.get("cal"), param.get("kg"));
    }
}
