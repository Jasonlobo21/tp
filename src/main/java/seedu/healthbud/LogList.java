package seedu.healthbud;

import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.log.Log;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.Water;


import java.util.ArrayList;
import java.util.List;

import seedu.healthbud.parser.DateParser;
import seedu.healthbud.storage.Storage;

/**
 * The {@code LogList} class manages an in-memory collection of {@link Log} objects.
 * It provides methods for adding, deleting, listing, and searching logs.
 * It also handles data persistence by interfacing with {@link Storage}.
 */
public class LogList {

    private List<Log> logs;

    /**
     * Constructs a new empty {@code LogList}.
     */
    public LogList(){
        logs = new ArrayList<>();
    }

    /**
     * Returns the log at the specified index.
     *
     * @param index the index of the log to retrieve
     * @return the log at the specified index
     * @throws AssertionError if index is out of bounds
     */
    public Log getLog(int index){
        assert index >= 0 && index < logs.size() : "Index out of bounds";
        return logs.get(index);
    }

    /**
     * Returns the total number of logs in the list.
     *
     * @return the number of logs
     */
    public int getSize() {
        return logs.size();
    }

    /**
     * Returns true if the log list is empty, false otherwise.
     *
     * @return {@code true} if the log list is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return logs.isEmpty();
    }

    /**
     * Adds a log to the list and updates the persistent storage.
     *
     * @param log the log to add; must not be null
     */
    public void addLog(Log log) {
        assert log != null : "Log to add should not be null";
        logs.add(log);
        Ui.printMessage(String.format("Got it. I've added this %s log:", log.getLogType()));
        Ui.printMessage(" " + getLog(getSize() - 1));
        Storage.appendLogToFile(log);
        Ui.printMessage(String.format("Now you have %d %s logs in the list.", getSize(), log.getLogType()));
    }

    /**
     * Loads a log into the list without updating the persistent storage.
     *
     * @param log the log to load; must not be null
     */
    public void loadLog(Log log) {
        assert log != null : "Log to load should not be null";
        logs.add(log);
    }

    /**
     * Deletes the log at the specified (1-based) index, updates the persistent storage,
     * and prints confirmation.
     *
     * @param index the 1-based index of the log to delete
     * @throws HealthBudException if the index is out of range
     */
    public void deleteLog(int index) throws HealthBudException {
        if (index < 1 || index > getSize()) {
            throw new HealthBudException("Task number not in range");
        }

        Ui.printMessage("Noted. I've removed this log:");
        Ui.printMessage(" " + getLog(index - 1));
        logs.remove(index - 1);
        Storage.rewriteLogsToFile(this);
        Ui.printMessage("Now you have " + getSize() + " logs in the list.");
    }

    /**
     * Lists all logs in the list.
     */
    public void listLogs() {
        if (logs.isEmpty()) {
            Ui.printMessage(" No logs available.");
        } else {
            Ui.printMessage(" Got it, here are your logs: ");
            for (int i = 0; i < logs.size(); i++) {
                Ui.printListedFormat(this, i);
            }
        }
    }

    /**
     * Searches for logs that contain the given keyword.
     *
     * @param keyword the keyword to search for; must not be null
     */
    public void findLog(String keyword) {
        assert keyword != null : "Keyword should not be null";
        boolean notFound = true;
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).toString().contains(keyword)) {
                notFound = false;
                Ui.printListedFormat(this, i);
            }
        }

        if (notFound) {
            Ui.printMessage("No matching '" + keyword +  "' logs found.");
        }
    }

    /**
     * Searches for logs with the specified date.
     *
     * @param date the date to search for
     */
    public void findLogByDate(String date) {
        boolean notFound = true;
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).getDate().equals(date)) {
                notFound = false;
                Ui.printListedFormat(this, i);
            }
        }

        if (notFound) {
            Ui.printMessage("No logs found for this date: " + date);
        }
    }

    /**
     * Clears all logs from the list and updates persistent storage.
     */
    public void clearLogs() {
        if (logs.isEmpty()) {
            Ui.printMessage("No logs to clear.");
            return;
        }
        logs.clear();
        Storage.rewriteLogsToFile(this);
        Ui.printMessage("Noted. I've removed all logs.");
    }

    /**
     * Calculates the total calories consumed for meal logs on the given date.
     *
     * @param date the date to sum calories for; must not be null
     * @return the total calories consumed
     */
    public int getCaloriesSum(String date) throws InvalidDateFormatException, InvalidDateException {
        assert date != null : "Date should not be null";
        int totalCalories = 0;
        for (Log log : logs) {
            if (log instanceof Meal && DateParser.formatDate(log.getDate()).equals(date)) {
                Meal meal = (Meal) log;
                totalCalories += Integer.parseInt(meal.getCalories());
            }
        }
        Ui.printMessage("Total calories consumed: " + totalCalories + " cal");
        return totalCalories;
    }

    /**
     * Calculates the total calories burned for cardio logs on the given date.
     *
     * @param date the date to sum calories for; must not be null
     * @return the total calories burned
     */
    public int getCardioSum(String date) throws InvalidDateFormatException, InvalidDateException {
        assert date != null : "Date should not be null";
        int totalCardio = 0;
        for (Log log : logs) {
            if (log instanceof Cardio && DateParser.formatDate(log.getDate()).equals(date)) {
                Cardio cardio = (Cardio) log;
                int speed = Integer.parseInt(cardio.getSpeed());
                int duration = Integer.parseInt(cardio.getDuration());
                int incline = Integer.parseInt(cardio.getIncline());

                // Calories = ((speed * 2) + (incline * 5)) * (duration / 60.0) * 100
                totalCardio += (int) (((speed * 2) + (incline * 5)) * (duration / 60.0) * 100);
            }
        }
        Ui.printMessage("Total calories burned: " + totalCardio + " cal");
        return totalCardio;
    }

    /**
     * Calculates the total water consumed for water logs on the given date.
     *
     * @param date the date to sum water volume for; must not be null
     * @return the total water consumed in milliliters
     */
    public int getWaterSum(String date) throws InvalidDateException {
        assert date != null : "Date should not be null";

        int totalWater = 0;
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).getDate().equals(date)) {
                Water water = (Water) logs.get(i);
                totalWater += Integer.parseInt(water.getAmount());
            }
        }
        Ui.printMessage("Total water consumed: " + totalWater + " ml");
        return totalWater;
    }
}

