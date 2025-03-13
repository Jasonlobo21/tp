package seedu.healthbud.log;

public class Log {
    private String name;

    public Log(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
