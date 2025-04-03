package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidListException;
import seedu.healthbud.parser.ListParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ListCommandTest {

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

    // ------------------------------------------------------------------------
    // 1) Parser-based Tests: list <logType>
    // ------------------------------------------------------------------------

    @Test
    void listMealLogsWithNoLogsExpectNoLogsAvailableMessage() throws InvalidListException {
        // Prepare empty lists
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        // "list meal" => should list mealLogs, which is empty
        ListCommand command = ListParser.parse("list meal", mealLogs, workoutLogs, pbLogs, waterLogs, cardioLogs);
        command.execute();

        String output = outputStream.toString();
        assertTrue(output.contains("No logs available."),
                "Should print 'No logs available.' for empty mealLogs.");
    }

    @Test
    void listMealLogsWithExistingLogsExpectLogsListed() throws InvalidListException {
        // Prepare mealLogs with some entries
        LogList mealLogs = new LogList();
        AddMealCommand addMeal1 = new AddMealCommand(
                mealLogs, "chicken rice", "550", "12 Jan 2025", "9pm");
        AddMealCommand addMeal2 = new AddMealCommand(
                mealLogs, "tom yum", "650", "13 Jan 2025", "8pm");
        addMeal1.execute();
        addMeal2.execute();
        assertEquals(2, mealLogs.getSize());

        // Other categories remain empty
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        // "list meal" => should list the two meal logs
        outputStream.reset();
        ListCommand command = ListParser.parse("list meal", mealLogs, workoutLogs, pbLogs, waterLogs, cardioLogs);
        command.execute();

        String output = outputStream.toString();
        assertTrue(output.contains("chicken rice"),
                "Should list 'chicken rice' in mealLogs.");
        assertTrue(output.contains("tom yum"),
                "Should list 'tom yum' in mealLogs.");
    }

    @Test
    void listInvalidLogTypeExpectException() {
        // All logs are empty, but that doesn't matter for invalid log type
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "list invalidType";
        assertThrows(InvalidListException.class, () ->
                ListParser.parse(input, mealLogs, workoutLogs, pbLogs, waterLogs, cardioLogs));
    }

    @Test
    void listMissingLogTypeExpectException() {
        // Only "list" => missing the second token for log type
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "list";
        assertThrows(InvalidListException.class, () ->
                ListParser.parse(input, mealLogs, workoutLogs, pbLogs, waterLogs, cardioLogs));
    }

    // ------------------------------------------------------------------------
    // 2) Direct Command Execution Tests
    // ------------------------------------------------------------------------

    @Test
    void executeDirectCallNoLogsExpectNoLogsAvailableMessage() {
        // Directly construct a ListCommand with an empty LogList
        LogList mealLogs = new LogList();
        ListCommand command = new ListCommand(mealLogs);

        outputStream.reset();
        command.execute();

        String output = outputStream.toString();
        assertTrue(output.contains("No logs available."),
                "Should print 'No logs available.' when log list is empty.");
    }

    @Test
    void executeDirectCallWithLogsExpectLogsListed() {
        // Populate a LogList with a single meal
        LogList mealLogs = new LogList();
        AddMealCommand addMeal = new AddMealCommand(
                mealLogs, "fried rice", "600", "12 Jan 2025", "7pm");
        addMeal.execute();
        assertEquals(1, mealLogs.getSize());

        // Construct a ListCommand directly
        outputStream.reset();
        ListCommand command = new ListCommand(mealLogs);
        command.execute();

        String output = outputStream.toString();
        assertTrue(output.contains("fried rice"),
                "Should print 'fried rice' in the list.");
    }
}
