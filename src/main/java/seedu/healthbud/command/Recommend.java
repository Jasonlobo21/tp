package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.HealthBudException;

public class Recommend extends Command {

    @Override
    public void execute(LogList logList, String input) throws HealthBudException {
        if (!input.contains(" ")) {
            throw new HealthBudException("Invalid workout recommend command (e.g., rec biceps)");
        }

        String NEW_LINE = "\n     ";
        String muscle = input.substring(4);;

        switch (muscle) {
            case "chest":
                System.out.println("Here are some recommended chest exercises: " + NEW_LINE
                        + "1. Incline Smith Machine Bench Press" + NEW_LINE
                        + "2. Dumbbell Chest Press" + NEW_LINE
                        + "3. Cable Chest Flys");
                break;

            case "back":
                System.out.println("Here are some recommended back exercises: " + NEW_LINE
                        + "1. Pull-Ups" + NEW_LINE
                        + "2. Barbell Bent-over Rows" + NEW_LINE
                        + "3. Lat Pulldown");
                break;

            case "biceps":
                System.out.println("Here are some recommended biceps exercises: " + NEW_LINE
                        + "1. Barbell Bicep Curls" + NEW_LINE
                        + "2. Hammer Curls" + NEW_LINE
                        + "3. Cable Curls");
                break;

            case "triceps":
                System.out.println("Here are some recommended triceps exercises: " + NEW_LINE
                        + "1. Close-Grip Bench Press" + NEW_LINE
                        + "2. Tricep Dips" + NEW_LINE
                        + "3. Skull Crushers");
                break;

            case "legs":
                System.out.println("Here are some recommended leg exercises: " + NEW_LINE
                        + "1. Barbell Squats" + NEW_LINE
                        + "2. Leg Extension & Leg Curls" + NEW_LINE
                        + "3. Leg Press");
                break;

            case "shoulders":
                System.out.println("Here are some recommended shoulder exercises: " + NEW_LINE
                        + "1. Overhead Dumbell Shoulder Press (Front Delt)" + NEW_LINE
                        + "2. Lateral Raises (Side Delt)" + NEW_LINE
                        + "3. Rear Delt Flys (Rear Delt)");
                break;

            case "abs":
                System.out.println("Here are some recommended ab exercises: " + NEW_LINE
                        + "1. Hanging Leg Raises" + NEW_LINE
                        + "2. Russian Twists" + NEW_LINE
                        + "3. Planks");
                break;

            case "forearms":
                System.out.println("Here are some recommended forearm exercises: " + NEW_LINE
                        + "1. Wrist Curls" + NEW_LINE
                        + "2. Reverse Wrist Curls" + NEW_LINE
                        + "3. Farmer's Walk");
                break;

            case "help":
                System.out.println("Here are the list of muscle groups: " + NEW_LINE
                        + "1. chest" + NEW_LINE
                        + "2. back" + NEW_LINE
                        + "3. biceps" + NEW_LINE
                        + "4. triceps" + NEW_LINE
                        + "5. legs" + NEW_LINE
                        + "6. shoulders" + NEW_LINE
                        + "7. abs" + NEW_LINE
                        + "8. forearms");
                break;
            default:
                throw new HealthBudException("I don't recognize that muscle group. Type 'rec help' to see the list of muscle groups.");
        }
    }
}
