package seedu.healthbud.parser;

import seedu.healthbud.exception.InvalidTimeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeParser {

    private static final String INPUT_FORMAT = "HHmm";
    private static final String OUTPUT_FORMAT = "h:mma";

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
