package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.multilog.StatusCommand;
import seedu.healthbud.exception.InvalidStatusException;

/**
 * StatusParser is responsible for parsing the input command to generate a StatusCommand.
 * It handles the "change" and "report" actions for status updates and reporting.
 */
public class StatusParser {

    private static String currentStatus = "neutral";

    /**
     * Parses the given input and returns a StatusCommand based on the action and argument provided.
     *
     * @param input the input string; must not be null.
     * @param goalLogs the LogList for goal logs.
     * @param pbLogs the LogList for personal best logs.
     * @param mealLogs the LogList for meal logs.
     * @param workoutLogs the LogList for workout logs.
     * @param waterLogs the LogList for water logs.
     * @param cardioLogs the LogList for cardio logs.
     * @return a new StatusCommand based on the parsed input.
     * @throws InvalidStatusException if the input does not conform to the expected format.
     */
    public static StatusCommand parse(String input, LogList goalLogs, LogList pbLogs, LogList mealLogs,
                                      LogList workoutLogs, LogList waterLogs, LogList cardioLogs)
            throws InvalidStatusException {

        assert input != null : "Input should not be null";

        String[] parts = input.trim().split(" ");
        if (parts.length < 3) {
            throw new InvalidStatusException();
        }

        String action = parts[1].toLowerCase();
        String arg = parts[2].toLowerCase();

        String message;

        switch (action) {
        case "change":
            if (!arg.equals("cutting") && !arg.equals("bulking")) {
                throw new InvalidStatusException();
            }
            currentStatus = arg;
            message = "Status updated to: " + currentStatus;
            break;

        case "report":
            int caloriesEaten = mealLogs.getCaloriesSum(arg);
            int caloriesBurned = cardioLogs.getCardioSum(arg);
            int netCalories = caloriesEaten - caloriesBurned;

            StringBuilder sb = new StringBuilder();
            sb.append("Current Status: ").append(currentStatus).append("\n");

            if (currentStatus.equals("bulking") && netCalories > 0) {
                sb.append("You are on track for bulking! Net calories: ").append(netCalories);
            } else if (currentStatus.equals("cutting") && netCalories < 0) {
                sb.append("You are on track for cutting! Net calories: ").append(netCalories);
            } else {
                sb.append("Your intake does not align with your goal. Net calories: ").append(netCalories);
            }

            message = sb.toString();
            break;

        default:
            throw new InvalidStatusException();
        }

        return new StatusCommand(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input, message);
    }
}
