import java.util.List;

public class Commands {

    // Інтерфейс Command
    public interface Command {
        void execute();
        void undo();
    }

    private static ListOfCommands listOfCommands = new ListOfCommands();

    // Команда для підрахунку загальної чисельності клієнтів
    public static class CountCustomersCommand implements Command {
        private List<Tariff> tariffs;

        public CountCustomersCommand(List<Tariff> tariffs) {
            this.tariffs = tariffs;
        }

        @Override
        public void execute() {
            int totalCustomers = listOfCommands.countNumberOfCustomers(tariffs);
            System.out.println("Загальна чисельність клієнтів: " + totalCustomers);
        }

        @Override
        public void undo() {
            System.out.println("Операцію підрахунку клієнтів неможливо скасувати.");
        }
    }

    // Команда для сортування тарифів на основі розміру абонентської плати
    public static class SortTariffsCommand implements Command {
        private List<Tariff> tariffs;

        public SortTariffsCommand(List<Tariff> tariffs) {
            this.tariffs = tariffs;
        }

        @Override
        public void execute() {
            listOfCommands.sort(tariffs);
            System.out.println("Тарифи відсортовані за розміром абонентської плати.");
        }

        @Override
        public void undo() {
            System.out.println("Операцію сортування неможливо скасувати.");
        }
    }

    // Команда для пошуку тарифу за заданим діапазоном абонентської плати
    public static class FindTariffByRangeCommand implements Command {
        private List<Tariff> tariffs;
        private double minFee;
        private double maxFee;

        public FindTariffByRangeCommand(List<Tariff> tariffs, double minFee, double maxFee) {
            this.tariffs = tariffs;
            this.minFee = minFee;
            this.maxFee = maxFee;
        }

        @Override
        public void execute() {
            Tariff foundTariff = listOfCommands.findTariffByFewParameters(tariffs, minFee, maxFee);

            if (foundTariff != null) {
                System.out.println("Знайдений тариф:");
                foundTariff.printInfo();
            } else {
                System.out.println("Тариф не знайдено.");
            }
        }

        @Override
        public void undo() {
            System.out.println("Операцію пошуку тарифу неможливо скасувати.");
        }
    }

    // Команда для додавання нового тарифу
    public static class AddTariffCommand implements Command {
        private List<Tariff> tariffs;
        private Tariff newTariff;

        public AddTariffCommand(List<Tariff> tariffs, Tariff newTariff) {
            this.tariffs = tariffs;
            this.newTariff = newTariff;
        }

        @Override
        public void execute() {
            listOfCommands.addTariff(tariffs, newTariff);
            System.out.println("Тариф додано успішно.");
        }

        @Override
        public void undo() {
            listOfCommands.removeTariff(tariffs, newTariff);
            System.out.println("Додавання тарифу скасовано.");
        }
    }

    // Команда для видалення тарифу за назвою
    public static class RemoveTariffCommand implements Command {
        private List<Tariff> tariffs;
        private String tariffName;

        public RemoveTariffCommand(List<Tariff> tariffs, String tariffName) {
            this.tariffs = tariffs;
            this.tariffName = tariffName;
        }

        @Override
        public void execute() {
            Tariff tariffToRemove = tariffs.stream()
                    .filter(t -> t.getName().equals(tariffName))
                    .findFirst()
                    .orElse(null);

            if (tariffToRemove != null) {
                listOfCommands.removeTariff(tariffs, tariffToRemove);
                System.out.println("Тариф видалено.");
            } else {
                System.out.println("Тариф не знайдено.");
            }
        }

        @Override
        public void undo() {
            System.out.println("Відміна видалення тарифу недоступна через відсутність даних.");
        }
    }

    // Команда для пошуку тарифу за кількістю клієнтів
    public static class FindTariffByClientNumberCommand implements Command {
        private List<Tariff> tariffs;
        private int clientNumber;

        public FindTariffByClientNumberCommand(List<Tariff> tariffs, int clientNumber) {
            this.tariffs = tariffs;
            this.clientNumber = clientNumber;
        }

        @Override
        public void execute() {
            Tariff clientTariff = listOfCommands.findTariffByNumberOfClients(tariffs, clientNumber);

            if (clientTariff != null) {
                System.out.println("Знайдений тариф:");
                clientTariff.printInfo();
            } else {
                System.out.println("Тариф з такою кількістю клієнтів не знайдено.");
            }
        }

        @Override
        public void undo() {
            System.out.println("Операцію пошуку тарифу за кількістю клієнтів неможливо скасувати.");
        }
    }

    // Команда для відображення всіх тарифів
    public static class ShowAllTariffsCommand implements Command {
        private List<Tariff> tariffs;

        public ShowAllTariffsCommand(List<Tariff> tariffs) {
            this.tariffs = tariffs;
        }

        @Override
        public void execute() {
            if (tariffs.isEmpty()) {
                System.out.println("Список тарифів порожній.");
            } else {
                System.out.println("Список тарифів:");
                tariffs.forEach(Tariff::printInfo);
            }
        }

        @Override
        public void undo() {
            System.out.println("Операцію відображення тарифів неможливо скасувати.");
        }
    }
    public static class UpdateTariffCommand implements Command {
        private List<Tariff> tariffs;
        private String tariffName;
        private String parameterToUpdate;
        private String newValue;

        public UpdateTariffCommand(List<Tariff> tariffs, String tariffName, String parameterToUpdate, String newValue) {
            this.tariffs = tariffs;
            this.tariffName = tariffName;
            this.parameterToUpdate = parameterToUpdate;
            this.newValue = newValue;
        }

        @Override
        public void execute() {
            Tariff tariffToUpdate = tariffs.stream()
                    .filter(t -> t.getName().equals(tariffName))
                    .findFirst()
                    .orElse(null);

            if (tariffToUpdate != null) {
                switch (parameterToUpdate.toLowerCase()) {
                    case "name":
                        tariffToUpdate.setName(newValue);
                        break;
                    case "monthlyfee":
                        tariffToUpdate.setMonthlyFee(Double.parseDouble(newValue));
                        break;
                    case "clients":
                        tariffToUpdate.setNumberOfClients(Integer.parseInt(newValue));
                        break;
                    case "datalimit":
                        tariffToUpdate.setDataLimit(Double.parseDouble(newValue));
                        break;
                    case "minutes":
                        tariffToUpdate.setMinutes(Integer.parseInt(newValue));
                        break;
                    default:
                        System.out.println("Невірний параметр для оновлення.");
                        return;
                }
                System.out.println("Тариф оновлено.");
            } else {
                System.out.println("Тариф не знайдено.");
            }
        }

        @Override
        public void undo() {
            System.out.println("Скасування оновлення тарифу недоступне.");
        }
    }
}

