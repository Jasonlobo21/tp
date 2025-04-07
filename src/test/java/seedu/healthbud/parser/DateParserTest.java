package seedu.healthbud.parser;

import org.junit.jupiter.api.Test;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @Test
    void formatDate_validFormats_expectCorrectOutput() throws Exception {
        assertEquals("25 Dec 2023", DateParser.formatDate("25/12/2023"));
        assertEquals("25 Dec 2023", DateParser.formatDate("25/12/23"));
        assertEquals("25 Dec 2023", DateParser.formatDate("25-12-2023"));
        assertEquals("25 Dec 2023", DateParser.formatDate("25-12-23"));
    }

    @Test
    void formatDate_dateExceedsMax_expectInvalidDateException() {
        assertThrows(InvalidDateException.class, () ->
                DateParser.formatDate("01-05-2025")); // 1 May 2025
    }

    @Test
    void formatDate_invalidWords_expectInvalidDateException() {
        assertThrows(InvalidDateException.class, () ->
                DateParser.formatDate("apple pie"));
    }

    @Test
    void formatDate_looksLikeDateButWrongFormat_expectInvalidDateFormatException() {
        assertThrows(InvalidDateFormatException.class, () ->
                DateParser.formatDate("25th of December 2023"));
    }

    @Test
    void formatDate_emptyInput_expectInvalidDateException() {
        assertThrows(InvalidDateException.class, () ->
                DateParser.formatDate(""));
    }

    @Test
    void formatDate_nullInput_expectAssertionError() {
        assertThrows(AssertionError.class, () ->
                DateParser.formatDate(null));
    }

    @Test
    void formatDate_validDateExactlyOnBoundary_expectCorrectOutput() throws Exception {
        assertEquals("30 Apr 2025", DateParser.formatDate("30-04-2025"));
    }

    @Test
    void formatDate_blankSpacesInput_expectInvalidDateException() {
        assertThrows(InvalidDateException.class, () ->
                DateParser.formatDate("    "));
    }


    @Test
    void isValidFormattedDate_validInput_expectTrue() {
        assertTrue(DateParser.isValidFormattedDate("25 Dec 2023"));
    }

    @Test
    void isValidFormattedDate_invalidDate_expectFalse() {
        assertFalse(DateParser.isValidFormattedDate("32 Jan 2023")); // Invalid day
    }

    @Test
    void isValidFormattedDate_gibberish_expectFalse() {
        assertFalse(DateParser.isValidFormattedDate("random text"));
    }

    @Test
    void isValidFormattedDate_emptyOrNull_expectFalse() {
        assertFalse(DateParser.isValidFormattedDate(""));
        assertFalse(DateParser.isValidFormattedDate("   "));
        assertFalse(DateParser.isValidFormattedDate(null));
    }

}
