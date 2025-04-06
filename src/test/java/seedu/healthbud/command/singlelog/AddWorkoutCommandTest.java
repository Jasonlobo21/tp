package seedu.healthbud.command.singlelog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.Workout;
import seedu.healthbud.parser.addcommandparser.AddWorkoutParser;

public class AddWorkoutCommandTest {

    @Test
    void workoutLog_validInput_expectSuccess() throws Exception {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w 50";

        AddWorkoutCommand command = AddWorkoutParser.parse(workoutLogs, input);

        command.execute();

        Workout workout = (Workout) workoutLogs.getLog(0);
        assertEquals("squats", workout.getName());
        assertEquals("10", workout.getReps());
        assertEquals("3", workout.getSets());
        assertEquals("25 Dec 2023", workout.getDate());
        assertEquals("50", workout.getWeight());

        String expected = "squats (3 sets of 50 kg for 10 reps) on 25 Dec 2023";
        assertEquals(expected, workout.toString());
    }

    @Test
    void workoutLog_missingName_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout /r 10 /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_missingReps_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_missingSets_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_missingDate_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_missingWeight_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_nonNumericReps_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r ten /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_nonNumericSets_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s three /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_nonNumericWeight_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w fifty";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_emptyInput_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_emptyRepsValue_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_emptySetsValue_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_emptyDateValue_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_emptyWeightValue_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlyName_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout    /r 10 /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlyReps_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r    /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlySets_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s    /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlyDate_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d    /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlyWeight_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w    ";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutConstructor_nullName_throwsAssertionError() {
        assertThrows(AssertionError.class, () ->
                new Workout(null, "10", "3", "25-12-2023", "50")
        );
    }

    @Test
    void workoutConstructor_nullReps_throwsAssertionError() {
        assertThrows(AssertionError.class, () ->
                new Workout("squats", null, "3", "25-12-2023", "50")
        );
    }

    @Test
    void workoutConstructor_nullSets_throwsAssertionError() {
        assertThrows(AssertionError.class, () ->
                new Workout("squats", "10", null, "25-12-2023", "50")
        );
    }

    @Test
    void workoutConstructor_nullWeight_throwsAssertionError() {
        assertThrows(AssertionError.class, () ->
                new Workout("squats", "10", "3", "25-12-2023", null)
        );
    }
    @Test
    void workoutLog_missingOneParameterKey_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_extraParameterKey_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w 50 /x 999";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_allParamsPresentButNameMissing_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout /r 10 /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_repsTooLow_throwsHealthBudException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 0 /s 3 /d 25-12-2023 /w 50";

        assertThrows(HealthBudException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_repsTooHigh_throwsHealthBudException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 101 /s 3 /d 25-12-2023 /w 50";

        assertThrows(HealthBudException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_setsTooLow_throwsHealthBudException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 0 /d 25-12-2023 /w 50";

        assertThrows(HealthBudException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_setsTooHigh_throwsHealthBudException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 101 /d 25-12-2023 /w 50";

        assertThrows(HealthBudException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_weightTooLow_throwsHealthBudException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w 0";

        assertThrows(HealthBudException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_weightTooHigh_throwsHealthBudException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w 1001";

        assertThrows(HealthBudException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void workoutLog_validEdgeBoundaries_expectSuccess() throws Exception {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 1 /s 1 /d 25-12-2023 /w 0.1";

        AddWorkoutCommand command = AddWorkoutParser.parse(workoutLogs, input);
        command.execute();

        Workout workout = (Workout) workoutLogs.getLog(0);
        assertEquals("squats", workout.getName());
        assertEquals("1", workout.getReps());
        assertEquals("1", workout.getSets());
        assertEquals("25 Dec 2023", workout.getDate());
        assertEquals("0.1", workout.getWeight());
    }

}
