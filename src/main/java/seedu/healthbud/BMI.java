package seedu.healthbud;

import seedu.healthbud.exception.InvalidBmiException;

public class BMI {
    private double weight; // in kilograms
    private double height; // in meters

    // Constructor
    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    // Calculate the BMI using weight and height
    public double calculate() throws InvalidBmiException {
        if (weight <= 0) {
            throw new InvalidBmiException("Weight must be greater than zero.");
        }
        if (height <= 0) {
            throw new InvalidBmiException("Height must be greater than zero.");
        }
        return weight / (height * height);
    }

    /**
     * Parses a BMI command input and calculates the BMI.
     * Expected input format: "bmi /w 70 /h 1.78"
     *
     * @param input the full input string from the user
     * @return the calculated BMI value
     * @throws InvalidBmiException if the command is invalid or cannot be parsed
     */
    public static double calculateFromInput(String input) throws InvalidBmiException {
        double weight = 0;
        double height = 0;
        try {
            // Remove the "bmi" command portion (assumes "bmi" is followed by a space).
            String commandRemoved = input.substring(4).trim(); // yields "/w 70 /h 1.78"

            // Split based on the "/" delimiter.
            String[] parts = commandRemoved.split("/");
            for (String part : parts) {
                part = part.trim();
                // Check for weight token (case-insensitive)
                if (part.toLowerCase().startsWith("w ")) {
                    weight = Double.parseDouble(part.substring(2).trim());
                }
                // Check for height token (case-insensitive)
                else if (part.toLowerCase().startsWith("h ")) {
                    height = Double.parseDouble(part.substring(2).trim());
                }
            }
        } catch (Exception e) {
            throw new InvalidBmiException("Invalid BMI command. Usage: bmi /w <weight_in_kg> /h <height_in_m>");
        }
        return new BMI(weight, height).calculate();
    }
}
