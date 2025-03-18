package seedu.healthbud.log;

public class Meal extends Log {

    private String calories;
    private String time;

    public Meal(String name, String calories, String date, String time){
        super(name, date);
        this.calories = calories;
        this.time = time;
    }

    public String getCalories() {
        return calories;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%s (%s cal) on: %s at: %s", getName(), calories, getDate(), time);
    }
}
