package seedu.healthbud;

import seedu.healthbud.exception.HealthBudException;

public class BMI {
    private double weight; // in kilograms
    private double height; // in meters

    // Constructor
    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public static void calculateFromInput(String input) throws HealthBudException {
        if (!input.contains("/h") || !input.contains("/w")) {
            throw new HealthBudException("Invalid BMI command. (e.g., bmi /w 68 <in_kg> /h 1.77 <height_in_m>)");
        }

        String[] parts = input.split("/");
        parts[1] = parts[1].substring(1).trim();
        parts[2] = parts[2].substring(1).trim();

        double weight = Double.parseDouble(parts[1]);
        double height = Double.parseDouble(parts[2]);

        if (weight <= 0 || height <= 0) {
            throw new HealthBudException("Height and Weight must be greater than zero.");
        }

        double bmi = weight / (height * height);

        Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi));
    }
}
