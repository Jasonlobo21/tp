package seedu.healthbud.storage;

import seedu.healthbud.LogList;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.Workout;
import seedu.healthbud.log.Water;
import seedu.healthbud.log.Log;
import seedu.healthbud.log.PersonalBest;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.log.Goals;
import seedu.healthbud.parser.DateParser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Storage class for the HealthBud application.
 * This class handles all file operations such as loading, appending, and rewriting logs.
 * It also provides utility methods to parse log objects to and from strings.
 */
public class Storage {

    public static final String DATA_DIRECTORY = "data";
    public static final String DATA_FILE = "HealthBud.txt";
    public static final Path DATA_PATH = Paths.get(DATA_DIRECTORY, DATA_FILE);

    /**
     * Loads logs from the storage file into the provided LogLists.
     * If the file or directory does not exist, they are created.
     *
     * @param mealLogs    the LogList to load meal logs into
     * @param workoutLogs the LogList to load workout logs into
     * @param waterLogs   the LogList to load water logs into
     * @param pbLogs      the LogList to load personal best logs into
     * @param cardioLogs  the LogList to load cardio logs into
     * @param goalLogs    the LogList to load goal logs into
     */
    public static void loadLogs(LogList mealLogs, LogList workoutLogs, LogList waterLogs,
                                LogList pbLogs, LogList cardioLogs, LogList goalLogs) {
        try {
            Files.createDirectories(Paths.get(DATA_DIRECTORY));

            if (!Files.exists(DATA_PATH)) {
                Files.createFile(DATA_PATH);
                System.out.println("Created new text file in " +
                        DATA_PATH.toString().replace("\\", "/"));
                return;
            }

            List<String> lines = Files.readAllLines(DATA_PATH);
            for (String line : lines) {
                try {
                    Log log = parseStringToLog(line);
                    // Distribute log based on its type
                    if (log instanceof Meal) {
                        mealLogs.loadLog(log);
                    } else if (log instanceof Workout) {
                        workoutLogs.loadLog(log);
                    } else if (log instanceof Water) {
                        waterLogs.loadLog(log);
                    } else if (log instanceof PersonalBest){
                        pbLogs.loadLog(log);
                    } else if (log instanceof Cardio){
                        cardioLogs.loadLog(log);
                    } else if (log instanceof Goals){
                        goalLogs.loadLog(log);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Warning: Ignoring invalid log in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Warning: Error loading logs from file. Starting with empty lists.");
        }
    }

    /**
     * Parses a log string from the storage file into a Log object.
     *
     * @param line the line from the file representing a log
     * @return the parsed Log object
     * @throws IllegalArgumentException if the log format is invalid or unknown
     */
    public static Log parseStringToLog(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid log format");
        }
        String type = parts[0];

        switch (type) {
        case "M":
            return parseStringToMealLog(line);
        case "WO":
            return parseStringToWorkoutLog(line);
        case "WA":
            return parseStringToWaterLog(line);
        case "P":
            return parseStringToPersonalBestLog(line);
        case "C":
            return parseStringToCardioLog(line);
        case "G":
            return parseStringToGoalLog(line);
        default:
            throw new IllegalArgumentException("Unknown log type: " + type);
        }
    }

    /**
     * Appends the given log to the storage file.
     *
     * @param log the log to append; must not be null.
     */
    public static void appendLogToFile(Log log) {
        try (FileWriter fw = new FileWriter(DATA_PATH.toString(), true)) {
            fw.write(parseLogToString(log) + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error appending log to file: " + e.getMessage());
        }
    }

    /**
     * Rewrites the storage file with the current list of logs.
     *
     * @param logs the LogList containing all current logs
     */
    public static void rewriteLogsToFile(LogList logs) {
        try (FileWriter fw = new FileWriter(DATA_PATH.toString())) {
            for (int i = 0; i < logs.getSize(); i++) {
                fw.write(parseLogToString(logs.getLog(i)) + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error rewriting logs to file: " + e.getMessage());
        }
    }

    /**
     * Converts a Log object into its string representation for storage.
     *
     * @param log the log object to be converted; must not be null.
     * @return the string representation of the log
     * @throws IllegalArgumentException if the log type is unknown
     */
    public static String parseLogToString(Log log) {
        if (log instanceof Meal) {
            Meal meal = (Meal) log;
            return "M | " + meal.getName() + " | " + meal.getCalories()
                    + " | " + meal.getDate() + " | " + meal.getTime();
        } else if (log instanceof Workout) {
            Workout workout = (Workout) log;
            return "WO | " + workout.getName() + " | " + workout.getReps()
                    + " | " + workout.getSets() + " | " + workout.getDate()
                    + " | " + workout.getWeight();
        } else if (log instanceof Water) {
            Water water = (Water) log;
            return "WA | " + water.getAmount() + " | " + water.getDate() + " | " + water.getTime();
        } else if (log instanceof PersonalBest) {
            PersonalBest pb = (PersonalBest) log;
            return "P | " + pb.getExercise() + " | " + pb.getWeight() + " | " + pb.getDate();
        } else if (log instanceof Cardio) {
            Cardio cardio = (Cardio) log;
            return "C | " + cardio.getName() + " | " + cardio.getDuration() + " | " + cardio.getIncline() +
                    " | " + cardio.getSpeed() + " | " + cardio.getDate();
        } else if (log instanceof Goals) {
            Goals goals = (Goals) log;
            return "G | " + goals.getDailyWaterGoal() + " | " + goals.getDailyCalorieGoal()
                    + " | " + goals.getWeightGoal();
        }else {
            throw new IllegalArgumentException("Unknown log type");
        }
    }

    /**
     * Parses a meal log string into a Meal object.
     *
     * @param line the meal log string in the format "M | name | calories | date | time"
     * @return a Meal object representing the log
     * @throws IllegalArgumentException if the meal format is invalid
     */
    public static Log parseStringToMealLog(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid meal format");
        }

        //assuming the format is "M | name | calories | date | time"
        if(parts[1].isEmpty() || parts[2].isEmpty() || parts[3].isEmpty() || parts[4].isEmpty()) {
            throw new IllegalArgumentException("Invalid meal format");
        }

        int cal = Integer.parseInt(parts[2]);
        if (!parts[2].matches("\\d+") || cal < 0 || cal > 10000) {
            throw new IllegalArgumentException("Invalid calorie format");
        }

        if (!DateParser.isValidFormattedDate(parts[3])) {
            throw new IllegalArgumentException("Invalid date format");
        }

        if (!parts[4].matches("\\d{4}")) {
            throw new IllegalArgumentException("Invalid time format");
        }

        String trimmedCalories = parts[2].replaceFirst("^0+(?![.$])", "");

        return new Meal(parts[1], trimmedCalories, parts[3], parts[4]);
    }

    /**
     * Parses a workout log string into a Workout object.
     *
     * @param line the workout log string in the format "WO | name | reps | sets | date | weight"
     * @return a Workout object representing the log
     * @throws IllegalArgumentException if the workout format is invalid
     */
    public static Log parseStringToWorkoutLog(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid workout format");
        }

        //assuming the format is "WO | name | reps | sets | date | weight"
        if(parts[1].isEmpty() || parts[2].isEmpty() || parts[3].isEmpty() || parts[4].isEmpty() || parts[5].isEmpty()) {
            throw new IllegalArgumentException("Invalid workout format");
        }

        if (!parts[2].matches("\\d+") || parts[2].equals("0")) {
            throw new IllegalArgumentException("Invalid reps format");
        }

        if (!parts[3].matches("\\d+") || parts[3].equals("0")) {
            throw new IllegalArgumentException("Invalid sets format");
        }

        if (!DateParser.isValidFormattedDate(parts[4])) {
            throw new IllegalArgumentException("Invalid date format");
        }

        if (!parts[5].matches("\\d+") || parts[5].equals("0")) {
            throw new IllegalArgumentException("Invalid weight format");
        }
        String trimmedReps = parts[2].replaceFirst("^0+(?![.$])", "");
        String trimmedSets = parts[3].replaceFirst("^0+(?![.$])", "");
        String trimmedWeight = parts[5].replaceFirst("^0+(?![.$])", "");

        return new Workout(parts[1], trimmedReps, parts[3], trimmedSets, trimmedWeight);
    }

    /**
     * Parses a cardio log string into a Cardio object.
     *
     * @param line the cardio log string in the format "C | name | duration | incline | speed | date"
     * @return a Cardio object representing the log
     * @throws IllegalArgumentException if the cardio format is invalid
     */
    public static Log parseStringToCardioLog(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid cardio format");
        }

        //assuming the format is "C | name | duration | incline | speed | date"

        if(parts[1].isEmpty() || parts[2].isEmpty() || parts[3].isEmpty() || parts[4].isEmpty() || parts[5].isEmpty()) {
            throw new IllegalArgumentException("Invalid cardio format");
        }

        if (!parts[2].matches("^-?\\d+(\\.\\d+)?$") ||
                !parts[3].matches("^-?\\d+(\\.\\d+)?$") ||
                !parts[4].matches("^-?\\d+(\\.\\d+)?$")) {
            throw new IllegalArgumentException("Invalid duration format");
        }
        double time = Double.parseDouble(parts[2]);
        double incline = Double.parseDouble(parts[3]);
        double speed = Double.parseDouble(parts[4]);

        if (time <= 0 || time > 1440) {
            throw new IllegalArgumentException("Invalid duration format");
        }

        if (incline < 0 || incline > 15) {
            throw new IllegalArgumentException("Invalid incline format");
        }

        if (speed <= 0 || speed > 50) {
            throw new IllegalArgumentException("Invalid speed format");
        }

        String trimmedDuration = parts[2].replaceFirst("^0+(?![.$])", "");
        String trimmedIncline = parts[3].replaceFirst("^0+(?![.$])", "");
        String trimmedSpeed = parts[4].replaceFirst("^0+(?![.$])", "");

        if (!DateParser.isValidFormattedDate(parts[5])) {
            throw new IllegalArgumentException("Invalid date format");
        }

        return new Cardio(parts[1], parts[2], trimmedDuration, trimmedIncline, trimmedSpeed);
    }

    /**
     * Parses a water log string into a Water object.
     *
     * @param line the water log string in the format "WA | amount | date | time"
     * @return a Water object representing the log
     * @throws IllegalArgumentException if the water format is invalid
     */
    public static Log parseStringToWaterLog(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid water format");
        }

        //assuming the format is "WA | amount | date | time"
        if(parts[1].isEmpty() || parts[2].isEmpty() || parts[3].isEmpty()) {
            throw new IllegalArgumentException("Invalid water format");
        }

        double ml = Double.parseDouble(parts[1]);

        if (!parts[1].matches("\\d+") || ml < 0 || ml > 10000) {
            throw new IllegalArgumentException("Invalid amount format");
        }

        if (!DateParser.isValidFormattedDate(parts[2])) {
            throw new IllegalArgumentException("Invalid date format");
        }

        if (!parts[3].matches("\\d{4}")) {
            throw new IllegalArgumentException("Invalid time format");
        }

        String trimmedAmount = parts[1].replaceFirst("^0+(?![.$])", "");

        return new Water(trimmedAmount, parts[2], parts[3]);
    }

    /**
     * Parses a personal best log string into a PersonalBest object.
     *
     * @param line the personal best log string in the format "P | exercise | weight | date"
     * @return a PersonalBest object representing the log
     * @throws IllegalArgumentException if the personal best format is invalid
     */
    public static Log parseStringToPersonalBestLog(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid personal best format");
        }

        //assuming the format is "P | exercise | weight | date"
        if(parts[1].isEmpty() || parts[2].isEmpty() || parts[3].isEmpty()) {
            throw new IllegalArgumentException("Invalid personal best format");
        }

        double weight = Double.parseDouble(parts[2]);

        if (!parts[2].matches("\\d+") || weight <= 0 || weight > 10000) {
            throw new IllegalArgumentException("Invalid weight format");
        }

        if (!DateParser.isValidFormattedDate(parts[3])) {
            throw new IllegalArgumentException("Invalid date format");
        }

        String trimmedWeight = parts[2].replaceFirst("^0+(?![.$])", "");

        return new PersonalBest(parts[1], trimmedWeight, parts[3]);
    }

    /**
     * Parses a goal log string into a Goals object.
     * The goal log format is "G | dailyWaterGoal | dailyCalorieGoal | weightGoal".
     * Some fields may be empty.
     *
     * @param line the goal log string
     * @return the Goals singleton instance with updated goals
     * @throws IllegalArgumentException if the goal format is invalid
     */
    public static Log parseStringToGoalLog(String line) {
        // it looks slightly different cause for the goals not all 3 has to be present
        // so for eg it could be storing like G | 200 |  | 65
        String[] parts = line.split(" \\| ");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid goal format");
        }

        String waterGoal = parts[1].trim();
        String calorieGoal = parts[2].trim();
        String weightGoal = parts[3].trim();

        if(waterGoal.isEmpty() || calorieGoal.isEmpty() || weightGoal.isEmpty()) {
            throw new IllegalArgumentException("Invalid goal format");
        }

        if (!waterGoal.isEmpty()) {
            if (waterGoal.equals("-")) {
                Goals.getInstance().setDailyWaterGoal(waterGoal);
            } else if (waterGoal.matches("\\d+")) {
                double water = Double.parseDouble(waterGoal);
                if (water < 1 || water > 10000) {
                    throw new IllegalArgumentException("Water goal must be between 1 and 10000");
                }
                waterGoal = waterGoal.replaceFirst("^0+(?=\\d)", "");
                Goals.getInstance().setDailyWaterGoal(waterGoal);
            } else {
                throw new IllegalArgumentException("Invalid water goal format");
            }
        }

        // Process Calorie Goal
        if (!calorieGoal.isEmpty()) {
            if (calorieGoal.equals("-")) {
                Goals.getInstance().setDailyCalorieGoal(calorieGoal);
            } else if (calorieGoal.matches("\\d+")) {
                double cal = Double.parseDouble(calorieGoal);
                if (cal < 1 || cal > 20000) {
                    throw new IllegalArgumentException("Calorie goal must be between 1 and 20000");
                }
                calorieGoal = calorieGoal.replaceFirst("^0+(?=\\d)", "");
                Goals.getInstance().setDailyCalorieGoal(calorieGoal);
            } else {
                throw new IllegalArgumentException("Invalid calorie goal format");
            }
        }

        // Process Weight Goal
        if (!weightGoal.isEmpty()) {
            if (weightGoal.equals("-")) {
                Goals.getInstance().setWeightGoal(weightGoal);
            } else if (weightGoal.matches("\\d+")) {
                double weight = Double.parseDouble(weightGoal);
                if (weight < 1 || weight > 1000) {
                    throw new IllegalArgumentException("Weight goal must be between 1 and 700");
                }
                weightGoal = weightGoal.replaceFirst("^0+(?=\\d)", "");
                Goals.getInstance().setWeightGoal(weightGoal);
            } else {
                throw new IllegalArgumentException("Invalid weight goal format");
            }
        }

        return Goals.getInstance();
    }
}
