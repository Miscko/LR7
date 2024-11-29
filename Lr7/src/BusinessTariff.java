class BusinessTariff extends Tariff {
    public BusinessTariff(String name, double monthlyFee, int numberOfClients, double dataLimit, int minutes) {
        super(name, monthlyFee, numberOfClients, dataLimit, minutes);
    }

    @Override
    public void printInfo() {
        System.out.println("Business Tariff: " + name + ", Monthly Fee: " + monthlyFee);
    }
}
