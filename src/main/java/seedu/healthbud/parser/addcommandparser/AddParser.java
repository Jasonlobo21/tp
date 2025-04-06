package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidAddLogException;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.exception.InvalidWorkoutException;

/**
 * AddParser is responsible for parsing the input command for adding logs.
 * It dispatches the command to the appropriate sub-parser based on the log type.
 */
public class AddParser {

    /**
     * Parses the given input command and returns a Command for adding a log.
     *
     * @param input the input command string; must not be null.
     * @param mealLogs the LogList for meal logs.
     * @param waterLogs the LogList for water logs.
     * @param cardioLogs the LogList for cardio logs.
     * @param pbLogs the LogList for personal best logs.
     * @param workoutLogs the LogList for workout logs.
     * @param goalLogs the LogList for goal logs.
     * @return a Command object corresponding to the log type to be added.
     * @throws InvalidAddLogException if the input command has insufficient parts or an unrecognized log type.
     * @throws InvalidCardioException if the input command for a cardio log is invalid.
     * @throws InvalidMealException if the input command for a meal log is invalid.
     * @throws InvalidPersonalBestException if the input command for a personal best log is invalid.
     * @throws InvalidWaterException if the input command for a water log is invalid.
     * @throws InvalidWorkoutException if the input command for a workout log is invalid.
     * @throws InvalidDateFormatException if the date in the input cannot be parsed.
     * @throws InvalidGoalException if the input command for a goal log is invalid.
     */
    public static Command parse(String input, LogList mealLogs, LogList waterLogs, LogList cardioLogs,
                                LogList pbLogs, LogList workoutLogs, LogList goalLogs) throws
            InvalidAddLogException, InvalidCardioException, InvalidMealException,
            InvalidPersonalBestException, InvalidWaterException, InvalidWorkoutException,
            InvalidDateFormatException, InvalidGoalException, InvalidDateException, HealthBudException {

        assert input != null : "Input should not be null";

        String[] parts = input.trim().split("\\s+");
        if (parts.length < 2) {
            throw new InvalidAddLogException();
        }

        switch (parts[1]) {
        case "meal":
            return AddMealParser.parse(mealLogs, input);
        case "water":
            return AddWaterParser.parse(waterLogs, input);
        case "cardio":
            return AddCardioParser.parse(cardioLogs, input);
        case "pb":
            return AddPersonalBestParser.parse(pbLogs, input);
        case "workout":
            return AddWorkoutParser.parse(workoutLogs, input);
        case "goal":
            return AddGoalParser.parse(goalLogs, input);
        default:
            throw new InvalidAddLogException();
        }
    }
}
