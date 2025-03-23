package seedu.healthbud.log;

public class Meal extends Log {

    private String name;
    private String calories;
    private String time;
    private static String totalCalories;

    public Meal(String name, String calories, String date, String time){
        super(date);
        this.name = name;
        this.calories = calories;
        this.time = time;
        totalCalories += Integer.parseInt(calories);
    }

    public static String getTotalCalories() {
        return totalCalories;
    }

    public String getName() {
        return name;
    }

    public String  getCalories() {
        return calories;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%s (%s cal) on: %s at: %s", name, calories, getDate(), time);
    }
}
