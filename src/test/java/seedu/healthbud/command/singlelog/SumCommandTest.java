package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidSumException;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.log.Water;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.SumParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SumCommandTest {

    @Test
    public void sumCommand_calorieSum_correctSumReturned() throws InvalidDateFormatException, InvalidDateException {
        LogList mealLogList = new LogList();
        mealLogList.addLog(new Meal("Eggs", "150", "03-04-2024", "08:00"));
        mealLogList.addLog(new Meal("Chicken", "300", "03-04-2024", "12:00"));
        mealLogList.addLog(new Meal("Soda", "100", "02-04-2024", "15:00"));

        SumCommand command = new SumCommand(mealLogList, "cal", "03-04-2024");
        command.execute();

        String formattedDate = DateParser.formatDate("03-04-2024");
        int expected = 450;
        int actual = mealLogList.getCaloriesSum(formattedDate);
        assertEquals(expected, actual);
    }

    @Test
    public void sumCommand_waterSum_correctSumReturned() throws InvalidDateFormatException, InvalidDateException {
        LogList waterLogList = new LogList();
        waterLogList.addLog(new Water("250", "03-04-2024", "09:00"));
        waterLogList.addLog(new Water("500", "03-04-2024", "11:00"));
        waterLogList.addLog(new Water("300", "02-04-2024", "18:00"));

        SumCommand command = new SumCommand(waterLogList, "vol", "03-04-2024");
        command.execute();

        String formattedDate = DateParser.formatDate("03-04-2024");
        int expected = 750;
        int actual = waterLogList.getWaterSum(formattedDate);
        assertEquals(expected, actual);
    }

    @Test
    public void sumCommand_cardioSum_correctCaloriesBurned() throws InvalidDateFormatException, InvalidDateException {
        LogList cardioLogList = new LogList();
        cardioLogList.addLog(new Cardio("Run", "6", "2", "30", "03-04-2024"));
        cardioLogList.addLog(new Cardio("Cycle", "4", "1", "60", "03-04-2024"));
        cardioLogList.addLog(new Cardio("Walk", "2", "1", "60", "02-04-2024"));

        SumCommand command = new SumCommand(cardioLogList, "cardio", "03-04-2024");
        command.execute();

        String formattedDate = DateParser.formatDate("03-04-2024");
        int expected = 2400;
        int actual = cardioLogList.getCardioSum(formattedDate);
        assertEquals(expected, actual);
    }

    @Test
    public void sumCommand_emptyLogList_returnsZero() throws InvalidDateFormatException, InvalidDateException {
        LogList mealLogList = new LogList();

        SumCommand command = new SumCommand(mealLogList, "cal", "03-04-2024");
        command.execute();

        String formattedDate = DateParser.formatDate("03-04-2024");
        int expected = 0;
        int actual = mealLogList.getCaloriesSum(formattedDate);
        assertEquals(expected, actual);
    }

    @Test
    public void sumCommand_validCalInput_executesCorrectly()
            throws InvalidDateFormatException, InvalidDateException, InvalidSumException {
        LogList mealLogs = new LogList();
        mealLogs.addLog(new Meal("Chicken Rice", "500", "03-04-2024", "12:00"));
        mealLogs.addLog(new Meal("Soup", "200", "03-04-2024", "18:00"));

        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        SumCommand command = SumParser.parse("sum cal /d 03-04-2024", mealLogs, waterLogs, cardioLogs);
        command.execute();

        String formattedDate = DateParser.formatDate("03-04-2024");
        assertEquals(700, mealLogs.getCaloriesSum(formattedDate));
    }

    @Test
    public void sumCommand_validVolInput_executesCorrectly()
            throws InvalidDateFormatException, InvalidDateException, InvalidSumException {
        LogList waterLogs = new LogList();
        waterLogs.addLog(new Water("250", "03-04-2024", "09:00"));
        waterLogs.addLog(new Water("500", "03-04-2024", "14:00"));

        LogList mealLogs = new LogList();
        LogList cardioLogs = new LogList();

        SumCommand command = SumParser.parse("sum vol /d 03-04-2024", mealLogs, waterLogs, cardioLogs);
        command.execute();

        String formattedDate = DateParser.formatDate("03-04-2024");
        assertEquals(750, waterLogs.getWaterSum(formattedDate));
    }

    @Test
    public void sumCommand_validCardioInput_executesCorrectly()
            throws InvalidDateFormatException, InvalidDateException, InvalidSumException {
        LogList cardioLogs = new LogList();
        cardioLogs.addLog(new Cardio("Run", "5", "2", "60", "03-04-2024"));

        LogList mealLogs = new LogList();
        LogList waterLogs = new LogList();

        SumCommand command = SumParser.parse("sum cardio /d 03-04-2024", mealLogs, waterLogs, cardioLogs);
        command.execute();

        String formattedDate = DateParser.formatDate("03-04-2024");
        assertEquals(2000, cardioLogs.getCardioSum(formattedDate));
    }

    @Test
    public void sumCommand_invalidType_throwsInvalidSumException() {
        LogList mealLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        assertThrows(InvalidSumException.class, () ->
                SumParser.parse("sum sleep /d 03-04-2024", mealLogs, waterLogs, cardioLogs));
    }

    @Test
    public void sumCommand_missingDatePrefix_throwsInvalidSumException() {
        LogList mealLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        assertThrows(InvalidSumException.class, () ->
                SumParser.parse("sum cal 03-04-2024", mealLogs, waterLogs, cardioLogs));
    }

    @Test
    void sumCommand_nullType_throwsAssertionError() {
        LogList dummyLogs = new LogList();
        assertThrows(AssertionError.class, () ->
                new SumCommand(dummyLogs, null, "03-04-2024"));
    }

    @Test
    void sumCommand_nullDate_throwsAssertionError() {
        LogList dummyLogs = new LogList();
        assertThrows(AssertionError.class, () ->
                new SumCommand(dummyLogs, "cal", null));
    }

    @Test
    void sumParser_nullInput_throwsAssertionError() {
        LogList mealLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        assertThrows(AssertionError.class, () ->
                SumParser.parse(null, mealLogs, waterLogs, cardioLogs));
    }

    @Test
    void sumParser_tooFewTokens_throwsInvalidSumException() {
        LogList mealLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "sum cal";
        assertThrows(InvalidSumException.class, () ->
                SumParser.parse(input, mealLogs, waterLogs, cardioLogs));
    }
}
