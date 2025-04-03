package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;

import seedu.healthbud.exception.InvalidDeleteException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidMLException;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.parser.DeleteParser;
import seedu.healthbud.parser.addcommandparser.AddMealParser;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteCommandTest {

    @Test
    void deleteMeal_correctInput_expectSuccess() throws InvalidPersonalBestException, InvalidMLException,
            InvalidCardioException, HealthBudException, InvalidMealException,
            InvalidDateFormatException, InvalidDeleteException {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d 12-01-25 /t 9pm";

        AddMealCommand command = AddMealParser.parse(mealLogs, input);
        command.execute();
        
        assertEquals(1, mealLogs.getSize());

        String deleteInput = "delete meal 1";
        DeleteCommand deleteCommand = DeleteParser.parse(deleteInput, mealLogs,
                new LogList(), new LogList(), new LogList(), new LogList());
        deleteCommand.execute();

        String expected = "Noted. I've removed this log:";
        assertTrue(output.toString().contains(expected));

        assertEquals(0, mealLogs.getSize());
    }

    @Test
    void deleteMeal_wrongInput_expectFailure() {

        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete meal"; // missing index

        assertThrows(InvalidDeleteException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void deleteParser_nonNumericIndex_expectThrowsInvalidDeleteException() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        // Non-numeric index provided
        String input = "delete meal one";

        InvalidDeleteException exception = assertThrows(InvalidDeleteException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
        assertEquals("Invalid delete command - delete <meal|workout|water|pb> <index>", exception.getMessage());
    }

    @Test
    void deleteParser_invalidLogType_expectThrowsInvalidDeleteException() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete unknown 1";

        assertThrows(InvalidDeleteException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void deleteWorkout_correctInput_expectSuccess() throws Exception {
        LogList workoutLogs = new LogList();
        LogList empty = new LogList();
        String input = "delete workout 1";
        DeleteCommand command = DeleteParser.parse(input, empty, workoutLogs, empty, empty, empty);
        assertEquals(workoutLogs, command.getLogList());
    }

    @Test
    void deleteWater_correctInput_expectSuccess() throws Exception {
        LogList waterLogs = new LogList();
        LogList empty = new LogList();
        String input = "delete water 1";
        DeleteCommand command = DeleteParser.parse(input, empty, empty, waterLogs, empty, empty);
        assertEquals(waterLogs, command.getLogList());
    }

    @Test
    void deletePB_correctInput_expectSuccess() throws Exception {
        LogList pbLogs = new LogList();
        LogList empty = new LogList();
        String input = "delete pb 1";
        DeleteCommand command = DeleteParser.parse(input, empty, empty, empty, pbLogs, empty);
        assertEquals(pbLogs, command.getLogList());
    }

    @Test
    void deleteCardio_correctInput_expectSuccess() throws Exception {
        LogList cardioLogs = new LogList();
        LogList empty = new LogList();
        String input = "delete cardio 1";
        DeleteCommand command = DeleteParser.parse(input, empty, empty, empty, empty, cardioLogs);
        assertEquals(cardioLogs, command.getLogList());
    }
}


