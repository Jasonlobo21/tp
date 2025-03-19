package seedu.healthbud;

import seedu.healthbud.command.AddLogCommand;
import seedu.healthbud.command.ListCommand;
import seedu.healthbud.command.RecommendCommand;
import seedu.healthbud.command.BMICommand;
import seedu.healthbud.command.FindCommand;
import seedu.healthbud.command.DeleteCommand;

import seedu.healthbud.exception.*;


public class Parser {

    public static final String NEW_LINE = "\n     ";

    public static boolean handleInput(LogList pbLogs, LogList mealLogs, LogList workoutLogs, LogList waterLogs,
                                      String input) {
        try {
            String command = input.split(" ")[0].toLowerCase();
            switch (command) {
            case "bye":
                return Ui.printGoodbye();
            case "add":
                new AddLogCommand().execute(pbLogs, mealLogs, workoutLogs, waterLogs, input);
                return true;
            case "help":
                Ui.printHelp();
                return true;
            case "list":
                new ListCommand().execute(pbLogs, mealLogs, workoutLogs, waterLogs, input);
                return true;
            case "recommend":
                new RecommendCommand().execute(pbLogs, mealLogs, workoutLogs, waterLogs, input);
                return true;
            case "bmi":
                new BMICommand(input).execute(pbLogs, mealLogs, workoutLogs, waterLogs, input);
                return true;
            case "find":
                new FindCommand().execute(pbLogs, mealLogs, workoutLogs, waterLogs, input);
                return true;
            case "delete":
                new DeleteCommand().execute(pbLogs, mealLogs, workoutLogs, waterLogs, input);
                return true;
            default:
                Ui.printUnknownCommand();
                return true;
            }
        } catch (InvalidMealException | InvalidRecommendException | InvalidBMIException | HealthBudException |
                 InvalidLogException | InvalidWaterException | InvalidWorkoutException |
                 InvalidListException | InvalidFindException | InvalidDeleteException | InvalidPBException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
