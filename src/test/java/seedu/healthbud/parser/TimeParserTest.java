package seedu.healthbud.parser;

import org.junit.jupiter.api.Test;
import seedu.healthbud.exception.InvalidTimeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeParserTest {

    @Test
    void formatTime_validInput_returnsFormattedTime() throws InvalidTimeException {
        assertEquals("0800", TimeParser.formatTime("0800"));
        assertEquals("1200", TimeParser.formatTime("1200"));
        assertEquals("1345", TimeParser.formatTime("1345"));
        assertEquals("2359", TimeParser.formatTime("2359"));
        assertEquals("0000", TimeParser.formatTime("0000"));
    }

    @Test
    void formatTime_invalidLength_throwsInvalidTimeException() {
        assertThrows(InvalidTimeException.class, () -> TimeParser.formatTime("800"));
        assertThrows(InvalidTimeException.class, () -> TimeParser.formatTime("08000"));
    }

    @Test
    void formatTime_invalidCharacters_throwsInvalidTimeException() {
        assertThrows(InvalidTimeException.class, () -> TimeParser.formatTime("12ab"));
        assertThrows(InvalidTimeException.class, () -> TimeParser.formatTime("time"));
    }

    @Test
    void formatTime_invalidHourMinuteRange_throwsInvalidTimeException() {
        assertThrows(InvalidTimeException.class, () -> TimeParser.formatTime("2560"));
        assertThrows(InvalidTimeException.class, () -> TimeParser.formatTime("1161"));
    }

    @Test
    void formatTime_nullInput_throwsInvalidTimeException() {
        assertThrows(InvalidTimeException.class, () -> TimeParser.formatTime(null));
    }
}
