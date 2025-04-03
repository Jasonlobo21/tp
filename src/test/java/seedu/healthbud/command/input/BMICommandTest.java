package seedu.healthbud.command.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import seedu.healthbud.exception.InvalidBMIException;
import seedu.healthbud.parser.BMIParser;


public class BMICommandTest {

    private String executeAndCaptureOutput(BMICommand command) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        command.execute();
        System.setOut(originalOut);
        return outContent.toString().trim();
    }


    @Test
    void parse_validInput_expectSuccess() throws InvalidBMIException {
        String input = "bmi /w 70 /h 1.75";
        BMICommand command = BMIParser.parse(input);
        String output = executeAndCaptureOutput(command);
        String expected = "Your BMI is: 22.86, you are of normal weight.";
        assertEquals(expected , output);
    }

    @Test
    void parse_missingParameters_expectInvalidBmiException() {
        String input = "bmi 70";
        assertThrows(InvalidBMIException.class, () -> BMIParser.parse(input),
                "Expected InvalidBmiException when missing '/h' or height.");
    }

    @Test
    void parse_nonNumericValues_expectHealthBudException() {
        String input = "bmi /w seventy /h onepointsevenfive";
        assertThrows(InvalidBMIException.class, () -> BMIParser.parse(input),
                "Invalid number format for weight or height.");
    }

    @Test
    void parse_zeroOrNegativeValues_expectHealthBudException() {
        // Zero weight
        String zeroWeightInput = "bmi /w 0 /h 1.75";
        assertThrows(InvalidBMIException.class, () -> BMIParser.parse(zeroWeightInput));


        String negativeHeightInput = "bmi /w 70 /h -1.75";
        assertThrows(InvalidBMIException.class, () -> BMIParser.parse(negativeHeightInput));
    }

    // ---------------- NEW TEST CASES FOR BETTER COVERAGE ---------------- //

    @Test
    void parse_underweightInput_expectUnderweightMessage() throws InvalidBMIException {
        String input = "bmi /w 50 /h 1.75";
        BMICommand command = BMIParser.parse(input);
        String output = executeAndCaptureOutput(command);
        // 50 / (1.75^2) ~ 16.33
        String expected = "Your BMI is: 16.33, you are underweight.";
        assertEquals(expected, output);
    }

    @Test
    void parse_overweightInput_expectOverweightMessage() throws InvalidBMIException {
        String input = "bmi /w 80 /h 1.75";
        BMICommand command = BMIParser.parse(input);
        String output = executeAndCaptureOutput(command);
        // 80 / (1.75^2) ~ 26.12
        String expected = "Your BMI is: 26.12, you are overweight.";
        assertEquals(expected, output);
    }

    @Test
    void parse_obeseInput_expectObeseMessage() throws InvalidBMIException {
        String input = "bmi /w 100 /h 1.75";
        BMICommand command = BMIParser.parse(input);
        String output = executeAndCaptureOutput(command);
        // 100 / (1.75^2) ~ 32.65
        String expected = "Your BMI is: 32.65, you are obese.";
        assertEquals(expected, output);
    }
}




