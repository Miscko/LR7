class PROTariff extends Tariff {
    public PROTariff(String name, double monthlyFee, int numberOfClients, double dataLimit, int minutes) {
        super(name, monthlyFee, numberOfClients, dataLimit, minutes);
    }

    @Override
    public void printInfo() {
        System.out.println("PRO Tariff: " + name + ", Monthly Fee: " + monthlyFee);
    }
}
