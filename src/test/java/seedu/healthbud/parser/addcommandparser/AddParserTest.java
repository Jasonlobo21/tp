package seedu.healthbud.parser.addcommandparser;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.command.Command;
import seedu.healthbud.command.singlelog.AddCardioCommand;
import seedu.healthbud.command.singlelog.AddGoalCommand;
import seedu.healthbud.command.singlelog.AddPersonalBestCommand;
import seedu.healthbud.command.singlelog.AddWaterCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidAddLogException;
import seedu.healthbud.exception.InvalidGoalException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddParserTest {

    @Test
    void parse_validWaterInput_success() throws Exception {
        LogList waterLogs = new LogList();
        String input = "add water /ml 2000 /d 12-04-2024 /t 1200";
        Command command = AddParser.parse(input, new LogList(), waterLogs, new LogList(),
                new LogList(), new LogList(), new LogList());
        assertEquals(AddWaterCommand.class, command.getClass());
    }

    @Test
    void parse_validCardioInput_success() throws Exception {
        LogList cardioLogs = new LogList();
        String input = "add cardio run /s 10 /i 5 /t 30 /d 12-04-2024";
        Command command = AddParser.parse(input, new LogList(), new LogList(), cardioLogs,
                new LogList(), new LogList(), new LogList());
        assertEquals(AddCardioCommand.class, command.getClass());
    }

    @Test
    void parse_validPersonalBestInput_success() throws Exception {
        LogList pbLogs = new LogList();
        String input = "add pb deadlift /w 100 /d 12-04-2024";
        Command command = AddParser.parse(input, new LogList(), new LogList(), new LogList(),
                pbLogs, new LogList(), new LogList());
        assertEquals(AddPersonalBestCommand.class, command.getClass());
    }

    @Test
    void parse_validWorkoutInput_success() {
        String input = "add workout pushup /w 0 /r 10 /s 3 /d 12-04-2024";
        assertThrows(HealthBudException.class, () ->
                AddParser.parse(input, new LogList(), new LogList(), new LogList(),
                        new LogList(), new LogList(), new LogList()));
    }

    @Test
    void parse_invalidType_throwsInvalidAddLogException() {
        String input = "add pizza /cal 1000 /d 12-04-2024 /t 1900";
        assertThrows(InvalidAddLogException.class, () ->
                AddParser.parse(input, new LogList(), new LogList(), new LogList(),
                        new LogList(), new LogList(), new LogList()));
    }

    @Test
    void parse_insufficientArguments_throwsInvalidAddLogException() {
        String input = "add";
        assertThrows(InvalidAddLogException.class, () ->
                AddParser.parse(input, new LogList(), new LogList(), new LogList(),
                        new LogList(), new LogList(), new LogList()));
    }

    @Test
    void parse_nullInput_throwsAssertionError() {
        assertThrows(AssertionError.class, () ->
                AddParser.parse(null, new LogList(), new LogList(), new LogList(),
                        new LogList(), new LogList(), new LogList()));
    }

    @Test
    void parse_validGoalInput_success() throws Exception {
        LogList goalLogs = new LogList();
        String input = "add goal /ml 200 /cal 1800 /kg 70";
        Command command = AddParser.parse(input, new LogList(), new LogList(), new LogList(),
                new LogList(), new LogList(), goalLogs);
        assertEquals(AddGoalCommand.class, command.getClass());
    }

    @Test
    void parse_partialGoalInput_success() throws Exception {
        LogList goalLogs = new LogList();
        String input = "add goal /kg 65";
        Command command = AddParser.parse(input, new LogList(), new LogList(), new LogList(),
                new LogList(), new LogList(), goalLogs);
        assertEquals(AddGoalCommand.class, command.getClass());
    }

    @Test
    void parse_invalidGoalParameter_throwsInvalidGoalException() {
        LogList goalLogs = new LogList();
        String input = "add goal /ml 200 /w 70";
        assertThrows(InvalidGoalException.class, () ->
                AddParser.parse(input, new LogList(), new LogList(), new LogList(),
                        new LogList(), new LogList(), goalLogs));
    }
}
