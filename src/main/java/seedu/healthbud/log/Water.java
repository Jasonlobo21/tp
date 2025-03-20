package seedu.healthbud.log;

public class Water extends Log {

    private String amount;
    private String time;
    private static int glass;
    private static int bottle;

    public Water(String name, String amount, String date, String time){
        super(name, date);
        this.amount = amount;
        this.time = time;
        updateVariables(amount);
    }

    public void updateVariables(String amount) {
        int amountInt = Integer.parseInt(amount);
        this.glass = amountInt/250;
        this.bottle = amountInt/1000;
    }

    public String getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String toString() {
        return String.format("%s, %s ml on %s at %s", getName(), amount, getDate(), getTime());
    }

    public static int getGlass() {
        return glass;
    }

    public static int getBottle() {
        return bottle;
    }
}
