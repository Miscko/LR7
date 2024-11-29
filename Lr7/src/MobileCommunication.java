import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobileCommunication {

    private List<Tariff> tariffs; // Список тарифів
    private Scanner scanner;

    public MobileCommunication() {
        tariffs = new ArrayList<>(); // Початково порожній список тарифів
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MobileCommunication mobileCommunication = new MobileCommunication();
        mobileCommunication.showMenu();
    }

    // Консольне меню
    public void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("__________________________________________________________________________");
            System.out.println("|------------------------ Tariff Management Menu ------------------------|");
            System.out.println("|1. Підрахувати загальну чисельність клієнтів                            |");
            System.out.println("|2. Здійснити сортування тарифів на основі розміру абонентської плати    |");
            System.out.println("|3. Знайти тариф у компанії, що відповідає заданому діапазону параметрів |");
            System.out.println("|4. Додати тариф                                                         |");
            System.out.println("|5. Видалити тариф                                                       |");
            System.out.println("|6. Знайти тариф за кількістю клієнтів                                   |");
            System.out.println("|7. Показати всі тарифи                                                  |");
            System.out.println("|8. Оновлення тарифу                                                     |");
            System.out.println("|9. Вихід                                                                |");
            System.out.print("Оберіть опцію: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Для коректного зчитування після int

            switch (choice) {
                case 1:
                    executeCommand(new Commands.CountCustomersCommand(tariffs));
                    break;
                case 2:
                    executeCommand(new Commands.SortTariffsCommand(tariffs));
                    break;
                case 3:
                    System.out.println("Введіть мінімальну абонентську плату: ");
                    double minFee = scanner.nextDouble();
                    System.out.println("Введіть максимальну абонентську плату: ");
                    double maxFee = scanner.nextDouble();
                    executeCommand(new Commands.FindTariffByRangeCommand(tariffs, minFee, maxFee));
                    break;
                case 4:
                    System.out.println("Оберіть тип тарифу:");
                    System.out.println("1. StandartTariff");
                    System.out.println("2. PROTariff");
                    System.out.println("3. BusinessTariff");
                    int tariffType = scanner.nextInt();
                    scanner.nextLine(); // Для коректного зчитування

                    System.out.println("Введіть назву тарифу: ");
                    String name = scanner.nextLine();
                    System.out.println("Введіть абонентську плату: ");
                    double fee = scanner.nextDouble();
                    System.out.println("Введіть кількість клієнтів: ");
                    int clients = scanner.nextInt();
                    System.out.println("Введіть обсяг даних (GB): ");
                    double dataLimit = scanner.nextDouble();
                    System.out.println("Введіть кількість хвилин: ");
                    int minutes = scanner.nextInt();

                    Tariff newTariff = null;
                    switch (tariffType) {
                        case 1:
                            newTariff = new StandartTariff(name, fee, clients, dataLimit, minutes);
                            break;
                        case 2:
                            newTariff = new PROTariff(name, fee, clients, dataLimit, minutes);
                            break;
                        case 3:
                            newTariff = new BusinessTariff(name, fee, clients, dataLimit, minutes);
                            break;
                        default:
                            System.out.println("Невірний вибір типу тарифу.");
                            break;
                    }

                    if (newTariff != null) {
                        executeCommand(new Commands.AddTariffCommand(tariffs, newTariff));
                    }
                    break;
                case 5:
                    System.out.println("Введіть назву тарифу для видалення: ");
                    String tariffToRemove = scanner.nextLine();
                    executeCommand(new Commands.RemoveTariffCommand(tariffs, tariffToRemove));
                    break;
                case 6:
                    System.out.println("Введіть кількість клієнтів: ");
                    int clientNumber = scanner.nextInt();
                    executeCommand(new Commands.FindTariffByClientNumberCommand(tariffs, clientNumber));
                    break;
                case 7:
                    executeCommand(new Commands.ShowAllTariffsCommand(tariffs)); // Execute the new command
                    break;
                case 8:
                    System.out.println("Введіть назву тарифу для оновлення:");
                    String tariffToUpdate = scanner.nextLine();
                    System.out.println("Введіть параметр для оновлення (name, monthlyFee, clients, dataLimit, minutes):");
                    String parameter = scanner.nextLine();
                    System.out.println("Введіть нове значення:");
                    String newValue = scanner.nextLine();
                    executeCommand(new Commands.UpdateTariffCommand(tariffs, tariffToUpdate, parameter, newValue));
                    break;
                case 9:
                    running = false;
                    System.out.println("Вихід з програми.");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }


    // Метод для виконання команди
    private void executeCommand(Commands.Command command) {
        command.execute();
    }
}