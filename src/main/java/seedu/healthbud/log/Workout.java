package seedu.healthbud.log;

public class Workout extends Log {
    private String reps;
    private String sets;

    public Workout(String name, String date, String reps, String sets) {
        super(name, date);
        this.reps = reps;
        this.sets = sets;
    }

    @Override
    public String toString() {
        return getDate() + " - " + getName() + " (" + reps + " reps, " + sets + " sets)";

    }
}
