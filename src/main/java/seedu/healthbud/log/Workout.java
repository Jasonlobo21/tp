package seedu.healthbud.log;

public class Workout extends Log {

    private String name;
    private String reps;
    private String sets;

    public Workout(String name, String date, String reps, String sets) {
        super(date);
        this.name = name;
        this.reps = reps;
        this.sets = sets;
    }

    @Override
    public String toString() {
        return getDate() + " - " + name + " (" + reps + " reps, " + sets + " sets)";

    }
}
