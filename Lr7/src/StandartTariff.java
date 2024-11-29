class StandartTariff extends Tariff {
    public StandartTariff(String name, double monthlyFee, int numberOfClients, double dataLimit, int minutes) {
        super(name, monthlyFee, numberOfClients, dataLimit, minutes);
    }

    @Override
    public void printInfo() {
        System.out.println("Standart Tariff: " + name + ", Monthly Fee: " + monthlyFee);
    }
}
