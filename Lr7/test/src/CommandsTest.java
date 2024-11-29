import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandsTest {

    @Test
    void testCountCustomersCommand() {
        List<Tariff> tariffs = new ArrayList<>(); // Використовуйте List<Tariff> замість ArrayList<Object>
        tariffs.add(new StandartTariff("Tariff1", 10.0, 100, 5.0, 100)); // Додайте об'єкт типу Tariff
        Commands.Command command = new Commands.CountCustomersCommand(tariffs);

        assertDoesNotThrow(command::execute);
    }

    @Test
    void testSortTariffsCommand() {
        List<Tariff> tariffs = new ArrayList<>(); // Використовуйте правильний тип
        tariffs.add(new StandartTariff("Tariff1", 20.0, 100, 5.0, 100));
        tariffs.add(new PROTariff("Tariff2", 10.0, 200, 10.0, 200));

        Commands.Command command = new Commands.SortTariffsCommand(tariffs);
        command.execute();

        assertEquals("Tariff2", tariffs.get(0).getName());
    }

    @Test
    void testAddTariffCommand() {
        List<Tariff> tariffs = new ArrayList<>(); // Правильний тип
        Tariff tariff = new StandartTariff("Tariff1", 10.0, 100, 5.0, 100);

        Commands.Command command = new Commands.AddTariffCommand(tariffs, tariff);
        command.execute();

        assertEquals(1, tariffs.size());
    }

    @Test
    void testRemoveTariffCommand() {
        List<Tariff> tariffs = new ArrayList<>(); // Правильний тип
        Tariff tariff = new StandartTariff("Tariff1", 10.0, 100, 5.0, 100);
        tariffs.add(tariff);

        Commands.Command command = new Commands.RemoveTariffCommand(tariffs, "Tariff1");
        command.execute();

        assertEquals(0, tariffs.size());
    }

    @Test
    void testFindTariffByClientNumberCommand() {
        List<Tariff> tariffs = new ArrayList<>(); // Правильний тип
        tariffs.add(new PROTariff("Tariff1", 10.0, 100, 5.0, 100));

        Commands.Command command = new Commands.FindTariffByClientNumberCommand(tariffs, 100);
        assertDoesNotThrow(command::execute);
    }
}
