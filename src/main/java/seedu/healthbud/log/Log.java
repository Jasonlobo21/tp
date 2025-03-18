package seedu.healthbud.log;

public class Log {
    private String name;
    private String date;

    public Log(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name;
    }
}
