package seedu.healthbud.command.singlelog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidSearchException;
import seedu.healthbud.parser.SearchParser;

public class SearchCommandTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    // =========================================================================
    // Tests for SearchParser.parse() and then executing the returned SearchCommand
    // =========================================================================

    @Test
    void parseSearchByDateWithMatchingLogsExpectSuccess()
            throws InvalidSearchException, InvalidDateFormatException {
        // Prepare a meal log list with one log having date "12 Jan 2025"
        LogList mealLogs = new LogList();
        AddMealCommand addMeal = new AddMealCommand(
                mealLogs, "chicken rice", "550", "12 Jan 2025", "9pm");
        addMeal.execute();
        assertEquals(1, mealLogs.getSize());

        // Prepare empty log lists for other categories
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "search meal /d 12-01-2025";
        SearchCommand command = SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);
        // Execute the command (the search logic is now in SearchCommand.execute())
        command.execute();
        System.out.flush();
        String output = outputStream.toString();

        assertTrue(output.contains("Showing logs for date: 12 Jan 2025"),
                "Should print header indicating date search.");
        assertTrue(output.contains("chicken rice"),
                "Should print the log details containing 'chicken rice'.");
    }

    @Test
    void parseSearchByDateWithNoMatchingLogsExpectNoLogsFoundMessage()
            throws InvalidSearchException, InvalidDateFormatException {
        // Prepare a meal log list with a log having a different date
        LogList mealLogs = new LogList();
        AddMealCommand addMeal = new AddMealCommand(
                mealLogs, "tom yum", "650", "13 Jan 2025", "8pm");
        addMeal.execute();
        assertEquals(1, mealLogs.getSize());

        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "search meal /d 12-01-2025";
        SearchCommand command = SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);
        command.execute();
        System.out.flush();
        String output = outputStream.toString();

        assertTrue(output.contains("Showing logs for date: 12 Jan 2025"),
                "Should print header indicating date search.");
        assertTrue(output.contains("No logs found for this date."),
                "Should print message indicating no logs found.");
    }

    @Test
    void parseSearchByKeywordValidInputExpectSuccess()
            throws InvalidSearchException, InvalidDateFormatException {
        // Prepare a meal log list with logs that match the keyword
        LogList mealLogs = new LogList();
        AddMealCommand addMeal1 = new AddMealCommand(
                mealLogs, "chicken salad", "400", "10 Jan 2025", "6pm");
        AddMealCommand addMeal2 = new AddMealCommand(
                mealLogs, "beef burger", "800", "11 Jan 2025", "8pm");
        addMeal1.execute();
        addMeal2.execute();
        assertEquals(2, mealLogs.getSize());

        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "search meal /k chicken";
        SearchCommand command = SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);
        command.execute();
        System.out.flush();
        String output = outputStream.toString();

        assertTrue(output.contains("Showing logs containing keyword: chicken"),
                "Should print header indicating keyword search.");
        assertTrue(output.contains("chicken salad"),
                "Should print the log containing 'chicken salad'.");
    }

    @Test
    void parseSearchInvalidParameterFlagExpectFailure() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "search meal /x 12-01-2025";
        assertThrows(InvalidSearchException.class, () ->
                SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void parseSearchInvalidLogTypeExpectFailure() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "search invalid /d 12-01-2025";
        assertThrows(InvalidSearchException.class, () ->
                SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void parseSearchMissingParametersExpectFailure() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "search meal";
        assertThrows(InvalidSearchException.class, () ->
                SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void parseSearchInvalidDateFormatExpectFailure() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "search meal /d 2025-13-01"; // invalid month
        assertThrows(InvalidDateFormatException.class, () ->
                SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void parseSearchWithBothParametersProvidedPrintsErrorMessage() {
        // When both parameters are provided (i.e., tokens > 3), the parser should throw an exception.
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "search meal /d 12-01-2025 /k chicken";
        // With our design, we now enforce that there must be exactly 3 tokens.
        assertThrows(InvalidSearchException.class, () ->
                SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void parseSearchNullOrEmptyInputExpectFailure() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        assertThrows(InvalidSearchException.class, () ->
                SearchParser.parse(null, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
        assertThrows(InvalidSearchException.class, () ->
                SearchParser.parse("", mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    // =========================================================================
    // Direct tests for SearchCommand.execute() without using the parser
    // =========================================================================

    @Test
    void executeSearchByDateDirectCallExpectSuccess() {
        // Prepare a meal log list with a matching log
        LogList mealLogs = new LogList();
        AddMealCommand addMeal = new AddMealCommand(
                mealLogs, "pasta", "500", "12 Jan 2025", "7pm");
        addMeal.execute();
        assertEquals(1, mealLogs.getSize());

        outputStream.reset();
        // Construct a SearchCommand directly with a valid date search (keyword is null)
        SearchCommand command = new SearchCommand(mealLogs, "12 Jan 2025", null);
        command.execute();
        System.out.flush();
        String output = outputStream.toString();
        assertTrue(output.contains("Showing logs for date: 12 Jan 2025"),
                "Direct execute should print header for date search.");
        assertTrue(output.contains("pasta"),
                "Direct execute should print the log details.");
    }

    @Test
    void executeSearchByKeywordDirectCallExpectSuccess() {
        // Prepare a meal log list with logs that match the keyword
        LogList mealLogs = new LogList();
        AddMealCommand addMeal1 = new AddMealCommand(
                mealLogs, "veggie wrap", "400", "10 Jan 2025", "6pm");
        AddMealCommand addMeal2 = new AddMealCommand(
                mealLogs, "chicken sandwich", "600", "11 Jan 2025", "8pm");
        addMeal1.execute();
        addMeal2.execute();
        assertEquals(2, mealLogs.getSize());

        outputStream.reset();
        // Construct a SearchCommand directly for a keyword search
        SearchCommand command = new SearchCommand(mealLogs, null, "chicken");
        command.execute();
        System.out.flush();
        String output = outputStream.toString();
        assertTrue(output.contains("Showing logs containing keyword: chicken"),
                "Direct execute should print header for keyword search.");
        assertTrue(output.contains("chicken sandwich"),
                "Direct execute should print the matching log details.");
    }

    @Test
    void executeDirectCallWithInvalidParametersExpectErrorMessage() {
        LogList mealLogs = new LogList();

        outputStream.reset();
        // Test direct call with both parameters provided
        SearchCommand commandBoth = new SearchCommand(mealLogs, "12 Jan 2025", "chicken");
        commandBoth.execute();
        System.out.flush();
        String outputBoth = outputStream.toString();
        assertTrue(outputBoth.contains(
                "Invalid search parameters. Provide either /d <date> or /k <keyword>, but not both."),
                "Direct execute should print error when both parameters are provided.");

        outputStream.reset();
        // Test direct call with neither parameter provided
        SearchCommand commandNeither = new SearchCommand(mealLogs, null, null);
        commandNeither.execute();
        System.out.flush();
        String outputNeither = outputStream.toString();
        assertTrue(outputNeither.contains(
                "Invalid search parameters. Provide either /d <date> or /k <keyword>, but not both."),
                "Direct execute should print error when neither parameter is provided.");
    }
}
