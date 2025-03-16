package seedu.healthbud;

import seedu.healthbud.command.AddLogCommand;
import seedu.healthbud.command.ListMeal;
import seedu.healthbud.command.Recommend;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidMealException;

public class Parser {

    public static final String NEW_LINE = "\n     ";

    public static boolean handleInput(LogList logs, String input) {
        try {
            String command = input.split(" ")[0].toLowerCase();
            switch (command) {
            case "bye":
                return Ui.printGoodbye();
            case "meal":
                new AddLogCommand().execute(logs, input);
                return true;
            case "help":
                Ui.printHelp();
                return true;
            case "list":
                new ListMeal().execute(logs, input);
                return true;
            case "rec":
                new Recommend().execute(logs, input);
                return true;
            case "bmi":
                BMI.calculateFromInput(input);
                return true;
            default:
                Ui.printUnknownCommand();
                return true;
            }
        } catch (InvalidMealException | HealthBudException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
