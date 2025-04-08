package seedu.healthbud.parser.goalparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.multilog.TrackGoalCommand;
import seedu.healthbud.exception.EmptyTrackException;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidTrackException;
import seedu.healthbud.parser.DateParser;

/**
 * TrackGoalParser is responsible for parsing the input command to create a TrackGoalCommand.
 * It checks for correct formatting and extracts the date parameter.
 */
public class TrackGoalParser {
    //@@author keanneeee
    /**
     * Parses the given input string and creates a TrackGoalCommand.
     *
     * @param input the input string; must not be null.
     * @param goalLogs the LogList for goals.
     * @param pbLogs the LogList for personal bests.
     * @param mealLogs the LogList for meals.
     * @param workoutLogs the LogList for workouts.
     * @param waterLogs the LogList for water logs.
     * @param cardioLogs the LogList for cardio logs.
     * @return a new TrackGoalCommand created from the input.
     * @throws InvalidTrackException if the input does not conform to the expected format.
     * @throws InvalidDateFormatException if the date parameter is invalid.
     */
    public static TrackGoalCommand parse(String input, LogList goalLogs, LogList pbLogs, LogList mealLogs,
                                         LogList workoutLogs, LogList waterLogs, LogList cardioLogs)
            throws InvalidTrackException, InvalidDateException, InvalidDateFormatException, EmptyTrackException {

        assert input != null : "Input should not be null";
        String[] parts = input.trim().split(" ");

        if (!parts[1].equals("goal") || parts.length < 4 || !parts[2].equals("/d")) {
            throw new InvalidTrackException();
        }

       String rawDate = parts[3];
        String formattedDate = DateParser.formatDate(rawDate);

        return new TrackGoalCommand(formattedDate, goalLogs, pbLogs,
                mealLogs, workoutLogs, waterLogs, cardioLogs);
    }
}

