package seedu.healthbud.log;

public class Water extends Log {

    private String amount;
    private String time;


    public Water(String amount, String date, String time){
        super(date);

        this.amount = amount;
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String toString() {

        return String.format(" %s ml on (%s) at %s", amount, getDate(), time);
    }

}
