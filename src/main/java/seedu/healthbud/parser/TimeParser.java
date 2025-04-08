package seedu.healthbud.parser;

import seedu.healthbud.exception.InvalidTimeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Utility class for parsing and formatting time inputs.
 * <p>
 * Expects time in 24-hour format ("HHmm") and provides validation.
 * Can be extended to convert to different formats such as "h:mma".
 * </p>
 */
public class TimeParser {

    /** Expected input time format (24-hour clock, e.g., "1300" for 1:00 PM). */
    private static final String INPUT_FORMAT = "HHmm";

    /** Desired output format (e.g., "1:00PM"). */
    private static final String OUTPUT_FORMAT = "h:mma";

    /**
     * Validates and parses the given time string to ensure it is in the correct "HHmm" format.
     *
     * @param inputTime A string representing the time in "HHmm" format (e.g., "0900", "1830").
     * @return The original validated time string if parsing succeeds.
     * @throws InvalidTimeException If the input is null, not in the correct format,
     *                              or represents an invalid time (e.g., "2560").
     */
    public static String formatTime(String inputTime) throws InvalidTimeException {
        if (inputTime == null || !inputTime.matches("\\d{4}")) {
            throw new InvalidTimeException();
        }

        SimpleDateFormat inputSdf = new SimpleDateFormat(INPUT_FORMAT);
        inputSdf.setLenient(false);
        Date date;
        try {
            date = inputSdf.parse(inputTime);
        } catch (ParseException e) {
            throw new InvalidTimeException();
        }


        return inputTime;
    }
}
