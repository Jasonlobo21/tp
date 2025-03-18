package seedu.healthbud;

import seedu.healthbud.storage.Storage;

import java.util.Scanner;

public class HealthBud {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static LogList mealLogs = new LogList();
    public static LogList workoutLogs = new LogList();

    public static void main(String[] args) {

        Ui.printGreeting();
        //Storage.loadMeals(mealLogs);
        Scanner in = new Scanner(System.in);

        boolean isLooping = true;
        while (isLooping) {
            isLooping = Parser.handleInput(mealLogs, workoutLogs, in.nextLine().trim());
        }
    }
}
