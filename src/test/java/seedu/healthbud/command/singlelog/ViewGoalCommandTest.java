package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidViewException;
import seedu.healthbud.log.Goals;
import seedu.healthbud.parser.goalparser.ViewGoalParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ViewGoalCommandTest {
    //@@author keanneeee
    @Test
    void testExecute_printsCurrentGoalsAndPrompt() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        LogList goalLogs = new LogList();
        ViewGoalCommand command = new ViewGoalCommand(goalLogs);
        command.execute();

        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("Here are your current goals"), "Should display goal header");
        assertTrue(output.contains("What goal would you like to add today?"), "Should prompt for adding goal");
        assertTrue(output.contains(Goals.getInstance().toString()), "Should print the current goal values");
    }

    @Test
    void parse_withTooShortInput_throwsInvalidViewException() {
        LogList goalLogs = new LogList();
        String input = "view";

        assertThrows(InvalidViewException.class, () -> ViewGoalParser.parse(input, goalLogs));
    }

    @Test
    void parse_withInvalidSecondKeyword_throwsInvalidViewException() {
        LogList goalLogs = new LogList();
        String input = "view banana";

        assertThrows(InvalidViewException.class, () -> ViewGoalParser.parse(input, goalLogs));
    }

    @Test
    void parse_withValidInput_returnsViewGoalCommand() throws InvalidViewException {
        LogList goalLogs = new LogList();
        String input = "view goal";

        assertTrue(ViewGoalParser.parse(input, goalLogs) instanceof ViewGoalCommand);
    }

    @Test
    void testExecute_printsExactGoalFormat() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Goals.getInstance().updateGoals("2500", "2000", "70");
        ViewGoalCommand command = new ViewGoalCommand(new LogList());
        command.execute();

        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("Daily Water Goal: 2500 ml"));
        assertTrue(output.contains("Daily Calorie Goal: 2000 cal"));
        assertTrue(output.contains("Weight Goal: 70 kg"));
    }

}
