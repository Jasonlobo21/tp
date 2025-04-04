package seedu.healthbud.parser;

import seedu.healthbud.command.input.BMICommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidBMIException;

import java.util.Map;

/**
 * BMIParser is responsible for parsing the BMI command input.
 * It extracts the weight and height parameters from the input string and returns a BMICommand.
 */
public class BMIParser {

    /**
     * Parses the given input string and returns a BMICommand.
     *
     * @param input the input string containing the BMI command; must not be null.
     * @return a BMICommand with the parsed weight and height values.
     * @throws InvalidBMIException if the input does not contain valid /h and /w parameters,
     *                             or if the weight or height values are invalid.
     */
    public static BMICommand parse(String input) throws InvalidBMIException, HealthBudException {
        assert input != null : "Input should not be null";

        if (!input.contains("/h") || !input.contains("/w")) {
            throw new InvalidBMIException();
        }

        input = input.substring("bmi".length()).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (!param.containsKey("w") || param.get("w").isEmpty()
                || !param.containsKey("h") || param.get("h").isEmpty()) {
            throw new InvalidBMIException();
        }

        if (!param.get("w").matches(
                "^-?\\d+(\\.\\d+)?$") || !param.get("h").matches("^-?\\d+(\\.\\d+)?$")) {
            throw new InvalidBMIException();
        }

        double weight = Double.parseDouble(param.get("w"));
        double height = Double.parseDouble(param.get("h"));

        if(height > 3.0 || height < 0.2 || weight <= 1.5 || weight > 700) {
            throw new HealthBudException(
                    "Weight should be between 1.5kg and 700kg and height should be between 0.2m and 3.0m.");
        }

        return new BMICommand(input, weight, height);
    }
}
