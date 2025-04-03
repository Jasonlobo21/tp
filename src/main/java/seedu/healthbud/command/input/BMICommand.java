package seedu.healthbud.command.input;

import seedu.healthbud.Ui;
import seedu.healthbud.command.InputCommand;

/**
 * BMICommand calculates the Body Mass Index (BMI) based on the user's weight and height.
 * When executed, it prints a message indicating the user's BMI category.
 */
public class BMICommand extends InputCommand {

    private final double weight; // in kilograms
    private final double height; // in meters

    /**
     * Constructs a BMICommand with the specified input, weight, and height.
     *
     * @param input  the user input string; must not be null.
     * @param weight the weight in kilograms.
     * @param height the height in meters.
     */
    public BMICommand(String input, double weight, double height) {
        //@@author Ahmish15
        super(input);
        this.weight = weight;
        this.height = height;
    }


    /**
     * Executes the BMI command by calculating the BMI and printing the appropriate message.
     * It uses the formula: BMI = weight / (height * height) and prints the BMI value along with
     * the corresponding weight category.
     */
    @Override
    public void execute() {

        assert weight > 0 : "Weight should be positive at execution time.";
        assert height > 0 : "Height should be positive at execution time.";

        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi) + ", you are underweight.");
        } else if (bmi < 25) {
            Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi) + ", you are of normal weight.");
        } else if (bmi < 30) {
            Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi) + ", you are overweight.");
        } else {
            Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi) + ", you are obese.");
        }
    }
}
