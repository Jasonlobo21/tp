package seedu.healthbud.log;

public class Water extends Log {

    private String amount;
    private String glasses;
    private String time;

    public Water(String name, String amount, String date, String glasses){
        super(name, date);
        this.amount = amount;
        this.glasses = glasses;
        this.time = time;
    }

    public String getAmount() { return amount; }

    public String getGlasses() { return glasses; }

    public String getTime() { return time; }


    public String toString() {
        return String.format("%s %s glasses, %s ml on %s at %s", getName(), glasses, amount, getDate(), time);
    }
}

