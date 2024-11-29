abstract class Tariff {
    protected String name;
    protected double monthlyFee;
    protected int numberOfClients;
    protected double dataLimit;
    protected int minutes;

    public Tariff(String name, double monthlyFee, int numberOfClients, double dataLimit, int minutes) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.numberOfClients = numberOfClients;
        this.dataLimit = dataLimit;
        this.minutes = minutes;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public double getDataLimit() {
        return dataLimit;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public void setDataLimit(double dataLimit) {
        this.dataLimit = dataLimit;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    // Можливо, додати інші методи, які будуть перевизначені в дочірніх класах
    public abstract void printInfo();
}
