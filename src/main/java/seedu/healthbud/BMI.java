package seedu.healthbud;

public class BMI {
    private double weight; // in kilograms
    private double height; // in meters

    // Constructor
    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    // Calculate BMI using weight and height
    public double calculate() {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return weight / (height * height);
    }

    /**
     * Parses a BMI command input and calculates the BMI.
     * Expected input format: "bmi /w 70 /h 1.78"
     *
     * @param input the full input string from the user
     * @return the calculated BMI value
     */
    public static double calculateFromInput(String input) {
        double weight = 0;
        double height = 0;

        // Remove the "bmi" command part; assumes "bmi" is 3 characters plus a space.
        String commandRemoved = input.substring(4).trim(); // yields "/w 70 /h 1.78"

        // Split based on the "/" character.
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

        BMI bmiCalculator = new BMI(weight, height);
        return bmiCalculator.calculate();
    }
}
