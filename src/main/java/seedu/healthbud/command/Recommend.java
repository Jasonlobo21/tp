package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.HealthBudException;

public class Recommend extends Command {

    @Override
    public void execute(LogList logList, String input) throws HealthBudException {
        if (!input.contains(" ")) {
            throw new HealthBudException("Invalid workout recommend command (e.g., rec biceps)");
        }

        String newLine = "\n     ";
        String muscle = input.substring(4);
        ;

        switch (muscle) {
        case "chest":
            System.out.println("Here are some recommended chest exercises: " + newLine
                    + "1. Incline Smith Machine Bench Press" + newLine
                    + "2. Dumbbell Chest Press" + newLine
                    + "3. Cable Chest Flys");
            break;

        case "back":
            System.out.println("Here are some recommended back exercises: " + newLine
                    + "1. Pull-Ups" + newLine
                    + "2. Barbell Bent-over Rows" + newLine
                    + "3. Lat Pulldown");
            break;

        case "biceps":
            System.out.println("Here are some recommended biceps exercises: " + newLine
                    + "1. Barbell Bicep Curls" + newLine
                    + "2. Hammer Curls" + newLine
                    + "3. Cable Curls");
            break;

        case "triceps":
            System.out.println("Here are some recommended triceps exercises: " + newLine
                    + "1. Close-Grip Bench Press" + newLine
                    + "2. Tricep Dips" + newLine
                    + "3. Skull Crushers");
            break;

        case "legs":
            System.out.println("Here are some recommended leg exercises: " + newLine
                    + "1. Barbell Squats" + newLine
                    + "2. Leg Extension & Leg Curls" + newLine
                    + "3. Leg Press");
            break;

        case "shoulders":
            System.out.println("Here are some recommended shoulder exercises: " + newLine
                    + "1. Overhead Dumbell Shoulder Press (Front Delt)" + newLine
                    + "2. Lateral Raises (Side Delt)" + newLine
                    + "3. Rear Delt Flys (Rear Delt)");
            break;

        case "abs":
            System.out.println("Here are some recommended ab exercises: " + newLine
                    + "1. Hanging Leg Raises" + newLine
                    + "2. Russian Twists" + newLine
                    + "3. Planks");
            break;

        case "forearms":
            System.out.println("Here are some recommended forearm exercises: " + newLine
                    + "1. Wrist Curls" + newLine
                    + "2. Reverse Wrist Curls" + newLine
                    + "3. Farmer's Walk");
            break;

        case "help":
            System.out.println("Here are the list of muscle groups: " + newLine
                    + "1. chest" + newLine
                    + "2. back" + newLine
                    + "3. biceps" + newLine
                    + "4. triceps" + newLine
                    + "5. legs" + newLine
                    + "6. shoulders" + newLine
                    + "7. abs" + newLine
                    + "8. forearms");
            break;
        default:
            throw new HealthBudException("I don't recognize that muscle group. Type 'rec help' to see the list of muscle groups.");
        }
    }
}
