package seedu.healthbud.storage;

import seedu.healthbud.LogList;
import seedu.healthbud.log.Meal;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Handles the storage operations for meal logs including reading from and writing to the file.
 */
public class Storage {

    /** Directory where meal data is stored. */
    public static final String DATA_DIRECTORY = "data";

    /** Filename for the meal storage file. */
    public static final String DATA_FILE = "HealthBud.txt";

    /** The complete path to the meal storage file. */
    public static final Path DATA_PATH = Paths.get(DATA_DIRECTORY, DATA_FILE);

    /**
     * Loads meals from the storage file into the provided LogList.
     * <p>
     * If the file or directory does not exist, they are created.
     * </p>
     *
     * @param mealLogs the LogList to load meals into
     */
    public static void loadMeals(LogList mealLogs) {
        try {
            Files.createDirectories(Paths.get(DATA_DIRECTORY));

            if (!Files.exists(DATA_PATH)) {
                Files.createFile(DATA_PATH);
                System.out.println("Created new text file in data/HealthBud.txt");
                return;
            }

            List<String> lines = Files.readAllLines(DATA_PATH);
            for (String line : lines) {
                try {
                    Meal meal = parseStringToMeal(line);
                    mealLogs.addLog(meal);
                } catch (IllegalArgumentException e) {
                    System.out.println("Warning: Ignoring invalid meal in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Warning: Error loading meals from file. Starting with empty list.");
        }
    }

    /**
     * Parses a line from the storage file into a Meal object.
     * Expected format: M | mealName | calories | date | time
     *
     * @param line the line representing a meal
     * @return a Meal object corresponding to the line
     * @throws IllegalArgumentException if the meal format is invalid
     */
    public static Meal parseStringToMeal(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid meal format");
        }
        if (!"M".equals(parts[0])) {
            throw new IllegalArgumentException("Invalid meal type");
        }
        String name = parts[1];
        String calories = parts[2];
        String date = parts[3];
        String time = parts[4];

        return new Meal(name, calories, date, time);
    }

    /**
     * Appends the given meal to the storage file.
     *
     * @param meal the Meal to append to the file
     */
    public static void appendMealToFile(Meal meal) {
        try (FileWriter fw = new FileWriter(DATA_PATH.toString(), true)) {
            fw.write(parseMealToString(meal) + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error appending meal to file: " + e.getMessage());
        }
    }

    /**
     * Rewrites all meals in the LogList to the storage file.
     *
     * @param mealLogs the LogList containing all meals to write
     */
    public static void rewriteMealsToFile(LogList mealLogs) {
        try (FileWriter fw = new FileWriter(DATA_PATH.toString())) {
            for (int i = 0; i < mealLogs.getSize(); i++) {
                // We know that the LogList stores meals as Log objects, so we need to cast them
                fw.write(parseMealToString((Meal) mealLogs.getLog(i)) + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error rewriting meals to file: " + e.getMessage());
        }
    }

    /**
     * Converts a Meal object into its string representation for storage.
     *
     * @param meal the Meal to convert
     * @return the string representation of the meal
     */
    public static String parseMealToString(Meal meal) {
        return "M | " + meal.getName() + " | " + meal.getCalories() + " | "
                + meal.getDate() + " | " + meal.getTime();
    }
}
