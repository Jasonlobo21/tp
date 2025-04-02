package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static seedu.healthbud.HealthBud.goalLogs;

import seedu.healthbud.LogList;
import seedu.healthbud.log.Goals;
import seedu.healthbud.parser.addcommandparser.AddGoalParser;
import seedu.healthbud.exception.InvalidGoalException;


class AddGoalCommandTest {

    @BeforeAll
    public static void setUp() {
        LogList goalLogs = new LogList();
    }

    @BeforeEach
    public void resetGoals() {
        Goals.getInstance().updateGoals("0", "0", "0");
    }

    @Test
    public void testUpdateGoals_setsCorrectValues() {
        Goals goals = Goals.getInstance();
        goals.updateGoals("2500", "2000", "70");

        assertEquals("2500", goals.getDailyWaterGoal());
        assertEquals("2000", goals.getDailyCalorieGoal());
        assertEquals("70", goals.getWeightGoal());
    }

    @Test
    public void testToStringDisplaysCorrectly() {
        Goals goals = Goals.getInstance();
        goals.updateGoals("2000", "1500", "60");

        String output = goals.toString();
        assertTrue(output.contains("Daily Water Goal: 2000 ml"));
        assertTrue(output.contains("Daily Calorie Goal: 1500 cal"));
        assertTrue(output.contains("Weight Goal: 60 kg"));
    }

    @Test
    public void addGoal_emptyInput_expectFailure() {
        Goals goal = Goals.getInstance();
        String input = "add goal";

        assertThrows(InvalidGoalException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_emptyParameters_expectFailure() {
        Goals goal = Goals.getInstance();
        String input = "add goal /w";

        assertThrows(InvalidGoalException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_updateOneParameter_expectSuccess(){
        Goals goals = Goals.getInstance();
        String preCal = goals.getDailyCalorieGoal();
        String preWeight = goals.getWeightGoal();
        String input = "add goal /w 2000";

        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("2000", goals.getDailyWaterGoal());
        assertEquals(preCal, goals.getDailyCalorieGoal());
        assertEquals(preWeight, goals.getWeightGoal());
    }

    @Test
    public void addGoal_updateTwoParameters_expectSuccess(){
        Goals goals = Goals.getInstance();
        String preWeight = goals.getWeightGoal();
        String input = "add goal /w 2000 /cal 100";

        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("2000", goals.getDailyWaterGoal());
        assertEquals("100", goals.getDailyCalorieGoal());
        assertEquals(preWeight, goals.getWeightGoal());
    }

}
