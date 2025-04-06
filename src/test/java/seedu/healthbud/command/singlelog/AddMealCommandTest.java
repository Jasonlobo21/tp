package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidTimeException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.exception.InvalidMLException;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.log.Meal;
import seedu.healthbud.parser.addcommandparser.AddMealParser;

class AddMealCommandTest {

    @Test
    void mealLog_missingName_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal /cal 550 /d 12-01-2025 /t 9pm";

        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_missingCaloriesParameter_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /d 12-01-2025 /t 9pm";

        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_nonNumericCalories_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal high /d 12-01-2025 /t 9pm";

        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void addMeal_emptyInput_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal";

        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void validMealAddsToLogList_expectSuccess() throws InvalidPersonalBestException, InvalidMLException
            , InvalidCardioException, InvalidMealException, InvalidDateFormatException, HealthBudException {

        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d 12-01-2025 /t 2100";

        AddMealCommand command = AddMealParser.parse(mealLogs, input);

        command.execute();

        Meal meal = (Meal) mealLogs.getLog(0);
        assertEquals("chicken rice", meal.getName());
        assertEquals("550", meal.getCalories());
        assertEquals("12 Jan 2025", meal.getDate());
        assertEquals("2100", meal.getTime());

        String expected = "chicken rice (550 cal) on: 12 Jan 2025 at: 2100";
        assertEquals(expected, meal.toString());
    }

    @Test
    void mealLog_nullInput_expectAssertionError() {
        LogList mealLogs = new LogList();
        assertThrows(AssertionError.class, () -> AddMealParser.parse(mealLogs, null));
    }

    @Test
    void mealLog_extraParameterKey_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d 12-01-2025 /t 9pm /x extra";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_missingCalorieKey_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /d 12-01-2025 /t 9pm";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_missingDateKey_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /t 9pm";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_missingTimeKey_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d 12-01-2025";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_emptyCalorieValue_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal   /d 12-01-2025 /t 9pm";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_emptyDateValue_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d   /t 9pm";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_emptyTimeValue_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d 12-01-2025 /t   ";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_onlyWhitespaceInName_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal    /cal 550 /d 12-01-2025 /t 9pm";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_validInput_expectSuccess() throws Exception {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 0550 /d 12-01-2025 /t 2100";

        AddMealCommand command = AddMealParser.parse(mealLogs, input);
        command.execute();

        Meal meal = (Meal) mealLogs.getLog(0);
        assertEquals("chicken rice", meal.getName());
        assertEquals("550", meal.getCalories()); // leading zero removed
        assertEquals("12 Jan 2025", meal.getDate());
        assertEquals("2100", meal.getTime());
    }

    @Test
    void mealLog_caloriesExceedLimit_expectHealthBudException() {
        LogList mealLogs = new LogList();
        String input = "add meal burger /cal 15000 /d 12-01-2025 /t 9pm";
        assertThrows(HealthBudException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_caloriesNegative_expectHealthBudException() {
        LogList mealLogs = new LogList();
        String input = "add meal fries /cal -100 /d 12-01-2025 /t 9pm";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_missingTimeParam_expectInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal salad /cal 150 /d 12-01-2025";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_typoInParameterKey_expectInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal sandwich /cals 200 /d 12-01-2025 /t 8am";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_whitespaceOnlyName_expectInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal    /cal 500 /d 01-01-2025 /t 8am";
        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_invalidTimeFormat_expectHealthBudException() {
        LogList mealLogs = new LogList();
        String input = "add meal oats /cal 300 /d 12-01-2025 /t badtime";
        assertThrows(InvalidTimeException.class, () -> AddMealParser.parse(mealLogs, input));
    }

}
