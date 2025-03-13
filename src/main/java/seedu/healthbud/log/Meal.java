package seedu.healthbud.log;

public class Meal extends Log {

    private String calories;
    private String date;
    private String time;

    public Meal(String name, String calories, String date, String time){
        super(name);
        this.calories = calories;
        this.time = time;
        this.date = date;
    }

    public String getCalories() {
        return calories;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
    @Override
    public String toString() {
        return String.format("%s (%s cal) on: %s at: %s", super.toString(), calories, date, time);
    }
}
