package seedu.healthbud.log;

public class Test extends Log {
    private String reps;
    private String sets;

    public Test(String name, String date, String reps, String sets) {
        super(name, date);
        this.reps = reps;
        this.sets = sets;
    }

    @Override
    public String toString() {
        return getDate() + " - " + getName() + " (" + reps + " reps, " + sets + " sets)";

    }
}
