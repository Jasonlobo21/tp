package seedu.healthbud;

import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.log.Meal;

public class Parser {
    public static boolean handleInput(LogList logs, String input) {
        try {
            String command = input.split(" ")[0].toLowerCase();
            switch (command) {
            case "bye":
                return Ui.printGoodbye();
            case "meal":
                handleMeal(logs, input);
                return true;
            case "help":
                Ui.printHelp();
                return true;
            case "list":
                handleMealList(logs);
                return true;
            default:
                Ui.printUnknownCommand();
                return true;
            }
        } catch (HealthBudException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static void handleMeal(LogList logs, String input){
        if (input == null || !input.contains("/d") || !input.contains("/t") || !input.contains("/cal")) {
            throw new HealthBudException("Invalid meal command (e.g., meal chicken rice /cal 550 /d 12-01-25 /t 9pm)");
        }

        String[] meal = input.substring(5).split("/");

        if(meal.length != 4){
            throw new HealthBudException("Invalid meal command (e.g., meal chicken rice /cal 550 /d 12-01-25 /t 9pm)");
        }
        meal[1] = meal[1].substring(3);
        meal[2] = meal[2].substring(1);
        meal[3] = meal[3].substring(1);
        if (meal[1].isEmpty() || meal[2].isEmpty() || meal[3].isEmpty()) {
            throw new HealthBudException("Invalid meal command (e.g., meal chicken rice /cal 550 /d 12-01-25 /t 9pm)");
        }

        Meal newMeal = new Meal(meal[0].trim(), meal[1].trim(), meal[2].trim(), meal[3].trim());
        logs.addlog(newMeal);

        Ui.printMessage(" Got it. I've added this task:");
        Ui.printMessage("   " + logs.getLog(logs.getSize() - 1));
        Ui.printMessage(" Now you have " + logs.getSize() + " tasks in the list.");
    }

    public static void handleMealList(LogList logs){
        if (logs.isEmpty()) {
            Ui.printMessage(" No tasks available.");
        } else {
            for (int i = 0; i < logs.getSize(); i++) {
                Ui.printListedFormat(logs, i);
            }
        }
    }
}
