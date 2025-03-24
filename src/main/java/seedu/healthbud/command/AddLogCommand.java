package seedu.healthbud.command;

// Imports

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidMLException;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.Water;
import seedu.healthbud.log.WorkOUT;
import seedu.healthbud.log.PB;
import seedu.healthbud.log.Goals;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.storage.Storage;

import java.util.Scanner;

public class AddLogCommand extends Command {

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                        LogList waterLogs, LogList cardioLogs, String input)
            throws InvalidMealException, InvalidWorkoutException, InvalidWaterException, InvalidLogException,
            InvalidPBException, InvalidMLException, InvalidCardioException, InvalidGoalException {


        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {

            throw new InvalidLogException();
        }
        String command = parts[1];
        switch (command) {

        case "goal":
            Ui.printMessage("Welcome to Goal Setting! \n");
            Ui.printMessage("Here are your current goals:\n" + "\n" + Goals.getInstance());
            Ui.printMessage("To change a goal please enter /name + value, " +
                    "/w for Water Goal, /c for Calorie Goal, /m for Weight Goal\n");
            Ui.printMessage("To check your progress, type 'progress'!");
            Ui.printMessage("To exit goal setting, type 'exit'!");
            Scanner in = new Scanner(System.in);
            Goals goal = Goals.getInstance();
            LogList logList = new LogList();

            String change = in.nextLine().trim();
            while (!change.contains("exit")) {

                if (change.contains("/w")) {

                    goal.setDailyWaterGoal(change.substring(3));
                    Ui.printMessage("Water Goal has been updated to " + goal.getDailyWaterGoal());
                } else if (change.contains("/c")) {

                    goal.setDailyCalorieGoal(change.substring(3));
                    Ui.printMessage("Calorie Goal has been updated to " + goal.getDailyCalorieGoal());
                } else if (change.contains("/m")) {

                    goal.setWeightGoal(change.substring(3));
                    Ui.printMessage("Weight Goal has been updated to " + goal.getWeightGoal());
                } else if (change.contains("progress")) {
                    Ui.printMessage("Which day would you like to view?");
                    logList.getAllDates();
                    String prog = in.nextLine().trim();
                    try {
                        Ui.printMessage("Here is your progress for " + prog + ":\n");
                        waterLogs.getWaterSum(prog);
                        mealLogs.getCaloriesSum(prog);
                        goal.getWeeklyWeightProgress();
                    } catch (InvalidDateException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                        throw new InvalidGoalException();
                    }
                change = in.nextLine().trim();
                }
            Ui.printMessage("Exited Goal Setting");
            break;

        case "pb":
            if (!input.contains("/e") || !input.contains("/w") || !input.contains("/d")) {

                throw new InvalidPBException();
            }

            String[] pb = input.substring(7).split("/");
            if (pb.length != 4) {

                throw new InvalidPBException();
            }

            String pbExercise = "";
            String pbWeight = "";
            String pbDate = "";

            for (String part : pb) {
                if (part.startsWith("e ")) {
                    pbExercise = part.substring(2).trim();
                } else if (part.startsWith("w ")) {
                    pbWeight = part.substring(2).trim();
                } else if (part.startsWith("d ")) {
                    pbDate = part.substring(2).trim();
                }
            }

            if (pbExercise.isEmpty() || pbWeight.isEmpty() || pbDate.isEmpty()) {
                throw new InvalidPBException();
            }

            PB newPB = new PB(pbExercise, pbWeight, pbDate);
            pbLogs.addLog(newPB);
            Ui.printMessage(" Got it. I've added this pb log:");
            Ui.printMessage("  " + pbLogs.getLog(pbLogs.getSize() - 1));
            Storage.appendLogToFile(newPB);
            Ui.printMessage(" Now you have " + pbLogs.getSize() + " pb logs in the list.");
            break;

        case "water":
            assert input != null : "Invalid water input!";
            assert !input.trim().isEmpty() : "Input should not be empty!";
            if (!input.contains("/ml") || !input.contains("/d") || !input.contains("/t")) {

                throw new InvalidWaterException();
            }

            String[] water = input.substring(10).split("/");
            if (water.length != 4) {

                throw new InvalidMealException();
            }

            // when u define the string use waterDate, waterML, waterTime if not will conflict - kin

            if (water[1].toLowerCase().contains("bottle") || water[1].toLowerCase().contains("bottles")) {

                water[1] = water[1].substring(3).trim();
                int keyIndex = water[1].indexOf("bottle");
                try {
                    int toInteger = Integer.parseInt(water[1].substring(0, keyIndex).trim());
                } catch (InvalidMLException e) {
                    System.out.println(e.getMessage());
                }
                int toInteger = Integer.parseInt(water[1].substring(0, keyIndex).trim()) * 1000;
                water[1] = Integer.toString(toInteger);
            } else if (water[1].toLowerCase().contains("glass")) {

                water[1] = water[1].substring(3).trim();
                int keyIndex = water[1].indexOf("glass");
                try {
                    int toInteger = Integer.parseInt(water[1].substring(0, keyIndex).trim());
                } catch (InvalidMLException e) {
                    System.out.println(e.getMessage());
                }
                int toInteger = Integer.parseInt(water[1].substring(0, keyIndex).trim()) * 250;
                water[1] = Integer.toString(toInteger);
            } else {

                water[1] = water[1].substring(3).trim();
            }

            water[2] = water[2].substring(1).trim();  // Corrected indentation
            water[3] = water[3].substring(1).trim();  // Corrected indentation

            if (water[1].isEmpty() || water[2].isEmpty() || water[3].isEmpty()) {

                throw new InvalidWaterException();
            }

            Water newWater = new Water(water[1], water[2], water[3]);
            waterLogs.addLog(newWater);
            Ui.printMessage(" Got it. I've added this water log:");
            Ui.printMessage("  " + waterLogs.getLog(waterLogs.getSize() - 1));
            Storage.appendLogToFile(newWater);
            Ui.printMessage(" Now you have " + waterLogs.getSize() + " water logs in the list.");
            break;

        case "workout":
            assert input != null : "Invalid workout input!";
            assert !input.trim().isEmpty() : "Input should not be empty!";

            if (!input.contains("/r") || !input.contains("/s") || !input.contains("/d")) {

                throw new InvalidWorkoutException();
            }

            String [] workoutTokens = extractWorkoutDetails(input);
            WorkOUT newWorkout = new WorkOUT(workoutTokens[0], workoutTokens[1], workoutTokens[2], workoutTokens[3]);
            logWorkout(workoutLogs, newWorkout);
            break;

        case "meal":
            if (!input.contains("/d") || !input.contains("/t") || !input.contains("/cal")) {

                throw new InvalidMealException();
            }

            String[] meal = input.substring(8).split("/");
            if (meal.length != 4) {

                throw new InvalidMealException();
            }

            // when u define the string use mealDate, mealCal, mealTime if not will conflict - kin

            meal[1] = meal[1].substring(3).trim();
            meal[2] = meal[2].substring(1).trim();
            meal[3] = meal[3].substring(1).trim();
            if (meal[1].isEmpty() || meal[2].isEmpty() || meal[3].isEmpty()) {

                throw new InvalidMealException();
            }

            Meal newMeal = new Meal(meal[0].trim(), meal[1], meal[2], meal[3]);
            mealLogs.addLog(newMeal);
            Ui.printMessage(" Got it. I've added this meal:");
            Ui.printMessage("   " + mealLogs.getLog(mealLogs.getSize() - 1));
            Storage.appendLogToFile(newMeal);
            Ui.printMessage(" Now you have " + mealLogs.getSize() + " meals in the list.");
            break;

        case "cardio":
            assert input != null : "Invalid cardio input!";
            assert !input.trim().isEmpty() : "Input should not be empty!";

            // Check if all required prefixes are present
            if (!input.contains("/s") || !input.contains("/i") || !input.contains("/t") || !input.contains("/d")) {
                throw new InvalidCardioException();
            }

            // Extract cardio details
            String[] cardioTokens = extractCardioDetails(input);
            Cardio newCardio = new Cardio(cardioTokens[0], cardioTokens[1],
                    cardioTokens[2], cardioTokens[3], cardioTokens[4]);
            logCardio(cardioLogs, newCardio);
            break;

        default:
            Ui.printMessage("Invalid type of log");
        }
    }

    private static void logWorkout(LogList workoutLogs, WorkOUT newWorkout) {
        workoutLogs.addLog(newWorkout);
        Ui.printMessage(" Got it. I've added this workout:");
        Ui.printMessage("   " + workoutLogs.getLog(workoutLogs.getSize() - 1));
        Storage.appendLogToFile(newWorkout);
        Ui.printMessage(" Now you have " + workoutLogs.getSize() + " workout done.");
    }

    private static void logCardio(LogList cardioLogs, Cardio newCardio) throws InvalidCardioException {
        cardioLogs.addLog(newCardio);
        Ui.printMessage(" Got it. I've added this cardio:");
        Ui.printMessage("   " + cardioLogs.getLog(cardioLogs.getSize() - 1));
        Storage.appendLogToFile(newCardio); // Uncomment if needed
        Ui.printMessage(" Now you have " + cardioLogs.getSize() + " cardio logs in the list.");
    }

    private String[] extractCardioDetails(String input) throws InvalidCardioException {
        String cardioDetails = input.substring("add cardio".length()).trim();
        String[] cardioTokens = cardioDetails.split("/");

        String cardioExercise = "";
        String cardioSpeed = "";
        String cardioDuration = "";
        String cardioIncline = "";
        String cardioDate = "";

        // Iterate through the tokens and assign values based on prefixes
        for (String token : cardioTokens) {
            if (token.startsWith("s ")) {
                cardioSpeed = token.substring(2).trim();
            } else if (token.startsWith("i ")) {
                cardioIncline = token.substring(2).trim();
            } else if (token.startsWith("t ")) {
                cardioDuration = token.substring(2).trim();
            } else if (token.startsWith("d ")) {
                cardioDate = token.substring(2).trim();
            } else {
                // If it doesn't start with a prefix, assume it's the workoutExercise name
                cardioExercise = token.trim();
            }
        }
        if (cardioExercise.isEmpty() || cardioSpeed.isEmpty() ||
                cardioIncline.isEmpty() || cardioDuration.isEmpty() || cardioDate.isEmpty()) {
            throw new InvalidCardioException();
        }

        return new String[]{cardioExercise, cardioDuration, cardioIncline, cardioSpeed, cardioDate};
    }

    private String [] extractWorkoutDetails(String input) throws InvalidWorkoutException {
        String workoutDetails = input.substring("add workout ".length()).trim();
        String[] workoutTokens = workoutDetails.split(" /");
        if (workoutTokens.length != 4) {

            throw new InvalidWorkoutException();
        }

        String workoutExercise = "";
        String workoutReps = "";
        String workoutSets = "";
        String workoutDate = "";
        //String name, String reps, String sets, String date
        for (String token : workoutTokens) {
            if (token.startsWith("r ")) {
                workoutReps = token.substring(2).trim();
            } else if (token.startsWith("s ")) {
                workoutSets = token.substring(2).trim();
            } else if (token.startsWith("d ")) {
                workoutDate = token.substring(2).trim();
            } else {
                // If it doesn't start with a prefix, assume it's the workoutExercise name
                workoutExercise = token.trim();
            }
        }

        if (workoutExercise.isEmpty() || workoutReps.isEmpty() || workoutSets.isEmpty() || workoutDate.isEmpty()) {
            throw new InvalidWorkoutException();
        }

        return new String[] {workoutExercise, workoutReps, workoutSets, workoutDate};
    }
    
    

}
