import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListOfCommands {

    private List<Tariff> tariffs;

    public ListOfCommands() {
        tariffs = new ArrayList<>();
    }

    // 1. Підрахувати загальну чисельність клієнтів
    public int countNumberOfCustomers(List<Tariff> tariffs) {
        int totalClients = 0;
        for (Tariff tariff : tariffs) {
            totalClients += tariff.getNumberOfClients();
        }
        return totalClients;
    }

    // 2. Здійснити сортування тарифів на основі розміру абонентської плати
    public void sort(List<Tariff> tariffs) {
        tariffs.sort((t1, t2) -> Double.compare(t1.getMonthlyFee(), t2.getMonthlyFee()));
    }

    // 3. Знайти тариф у компанії, що відповідає заданому діапазону параметрів
    public Tariff findTariffByFewParameters(List<Tariff> tariffs, double minFee, double maxFee) {
        for (Tariff tariff : tariffs) {
            if (tariff.getMonthlyFee() >= minFee && tariff.getMonthlyFee() <= maxFee) {
                return tariff;
            }
        }
        return null;
    }

    // 4. Додати тариф
    public void addTariff(List<Tariff> tariffs, Tariff newTariff) {
        tariffs.add(newTariff);
    }

    // 5. Видалити тариф
    public void removeTariff(List<Tariff> tariffs, Tariff tariffToRemove) {
        tariffs.remove(tariffToRemove);
    }

    // 6. Знайти тариф за кількістю клієнтів
    public Tariff findTariffByNumberOfClients(List<Tariff> tariffs, int clientNumber) {
        for (Tariff tariff : tariffs) {
            if (tariff.getNumberOfClients() == clientNumber) {
                return tariff;
            }
        }
        return null;
    }
}
