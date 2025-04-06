package seedu.healthbud.parser;

import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * DateParser provides utility methods for parsing and formatting date strings.
 * It attempts to parse the input date using several predefined formats and returns the date
 * formatted as "dd MMM yyyy". If the input date cannot be parsed using any supported format,
 * an InvalidDateFormatException is thrown.
 */
public class DateParser {

    private static final String OUTPUT_FORMAT = "dd MMM yyyy";

    // List of possible input date formats to try
    private static final List<String> INPUT_FORMATS = Arrays.asList(
            "dd/MM/yy",         // e.g., 12/11/25 -> 12 Nov 2025 (due to pivot date)
            "dd/MM/yyyy",       // e.g., 25/12/2023
            "dd-MM-yy",         // e.g., 12-11-23 -> 12 Nov 2023 (due to pivot date)
            "dd-MM-yyyy"        // e.g., 25-12-2023
    );

    /**
     * Formats the input date string into the standard output format "dd MMM yyyy".
     *
     * @param inputDate the input date string; must not be null or empty.
     * @return the formatted date string.
     * @throws InvalidDateFormatException if the input date cannot be parsed using any supported format.
     */
    public static String formatDate(String inputDate) throws InvalidDateFormatException, InvalidDateException {
        assert inputDate != null : "Input date should not be null";

        if (inputDate == null || inputDate.trim().isEmpty()) {
            throw new InvalidDateException();
        }

        Date maxAllowedDate;
        try {
            maxAllowedDate = new SimpleDateFormat("dd MMM yyyy").parse("30 Apr 2025");
        } catch (ParseException e) {
            throw new InvalidDateException(); // Should never happen
        }

        boolean looksLikeDate = inputDate.matches(".*\\d{1,2}.*[\\-/ _.,].*\\d{1,2}.*");

        for (String format : INPUT_FORMATS) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);

                if (format.contains("yy") && !format.contains("yyyy")) {
                    sdf.set2DigitYearStart(new SimpleDateFormat("yyyy").parse("2000"));
                }

                Date parsedDate = sdf.parse(inputDate);

                if (parsedDate.after(maxAllowedDate)) {
                    throw new InvalidDateException();
                }

                return new SimpleDateFormat(OUTPUT_FORMAT).format(parsedDate);

            } catch (ParseException e) {
                // ignore and try next
            }
        }
        if (looksLikeDate) {
            throw new InvalidDateFormatException(); // valid date but wrong format
        } else {
            throw new InvalidDateException(); // gibberish or date past 30th April 2025
        }
    }
}
