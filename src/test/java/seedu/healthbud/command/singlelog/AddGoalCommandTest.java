package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.healthbud.HealthBud.goalLogs;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidParameterException;
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

    @Test
    public void addGoal_sameAsExistingGoals_expectNoPrintButStillUpdate() {
        Goals goals = Goals.getInstance();
        goals.updateGoals("3000", "2500", "80");

        String input = "add goal /w 3000 /cal 2500 /kg 80";
        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("3000", goals.getDailyWaterGoal());
        assertEquals("2500", goals.getDailyCalorieGoal());
        assertEquals("80", goals.getWeightGoal());
    }

    @Test
    public void addGoal_missingCalorie_expectDefaultUsed() {
        Goals goals = Goals.getInstance();
        goals.updateGoals("3000", "1500", "65");

        String input = "add goal /w 2000 /kg 60";
        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("2000", goals.getDailyWaterGoal());
        assertEquals("1500", goals.getDailyCalorieGoal()); // default
        assertEquals("60", goals.getWeightGoal());
    }

    @Test
    public void addGoal_missingWater_expectDefaultUsed() {
        Goals goals = Goals.getInstance();
        goals.updateGoals("3000", "1500", "65");

        String input = "add goal /cal 1800 /kg 70";
        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("3000", goals.getDailyWaterGoal()); // default
        assertEquals("1800", goals.getDailyCalorieGoal());
        assertEquals("70", goals.getWeightGoal());
    }

    @Test
    public void addGoal_missingWeight_expectDefaultUsed() {
        Goals goals = Goals.getInstance();
        goals.updateGoals("3000", "1500", "65");

        String input = "add goal /w 2500 /cal 2000";
        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("2500", goals.getDailyWaterGoal());
        assertEquals("2000", goals.getDailyCalorieGoal());
        assertEquals("65", goals.getWeightGoal()); // default
    }

    @Test
    public void addGoal_nullInput_expectAssertionError() {
        LogList goalLogs = new LogList();
        assertThrows(AssertionError.class, () -> AddGoalParser.parse(goalLogs, null));
    }

    @Test
    public void addGoal_fourPartsWithZeroParam_expectInvalidParameterException() {
        String input = "add goal /w 0";
        Goals.getInstance().updateGoals("1500", "2000", "70"); // default values
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_fourPartsWithNonZeroValue_expectSuccess() {
        String input = "add goal /w 2000";
        Goals goals = Goals.getInstance();
        goals.updateGoals("2000", "1500", "65");

        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("2000", goals.getDailyWaterGoal());
    }

    @Test
    public void addGoal_sixPartsWithZeroCalorie_expectInvalidParameterException() {
        String input = "add goal /w 2000 /cal 0";
        Goals.getInstance().updateGoals("1500", "2000", "70");
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_sixPartsValid_expectSuccess() {
        String input = "add goal /w 1800 /cal 1500";
        Goals goals = Goals.getInstance();
        goals.updateGoals("2000", "1500", "65");

        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("1800", goals.getDailyWaterGoal());
        assertEquals("1500", goals.getDailyCalorieGoal());
    }

    @Test
    public void addGoal_eightPartsWithZeroWeight_expectInvalidParameterException() {
        String input = "add goal /w 1500 /cal 1200 /kg 0";
        Goals.getInstance().updateGoals("1500", "2000", "70");
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_eightPartsAllValid_expectSuccess() {
        String input = "add goal /w 2500 /cal 2200 /kg 68";
        Goals goals = Goals.getInstance();

        AddGoalCommand command = AddGoalParser.parse(goalLogs, input);
        command.execute();

        assertEquals("2500", goals.getDailyWaterGoal());
        assertEquals("2200", goals.getDailyCalorieGoal());
        assertEquals("68", goals.getWeightGoal());
    }

    @Test
    public void addGoal_waterIsNegative_expectInvalidParameterException() {
        String input = "add goal /w -100 /cal 2000 /kg 70";
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_calorieIsNegative_expectInvalidParameterException() {
        String input = "add goal /w 2000 /cal -1500 /kg 70";
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_weightIsNegative_expectInvalidParameterException() {
        String input = "add goal /w 2000 /cal 1500 /kg -70";
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_weightExceedsMax_expectInvalidParameterException() {
        String input = "add goal /w 2000 /cal 1500 /kg 1000";
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_waterIsNotNumeric_expectInvalidParameterException() {
        String input = "add goal /w abc /cal 1500 /kg 70";
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_calorieIsNotNumeric_expectInvalidParameterException() {
        String input = "add goal /w 2000 /cal xyz /kg 70";
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

    @Test
    public void addGoal_weightIsNotNumeric_expectInvalidParameterException() {
        String input = "add goal /w 2000 /cal 1500 /kg seventy";
        assertThrows(InvalidParameterException.class, () -> AddGoalParser.parse(goalLogs, input));
    }

}
