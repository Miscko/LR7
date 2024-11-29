import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOfCommandsTest {

    @Test
    void testCountNumberOfCustomers() {
        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new StandartTariff("Tariff1", 10.0, 100, 5.0, 100));
        tariffs.add(new PROTariff("Tariff2", 20.0, 200, 10.0, 200));

        ListOfCommands listOfCommands = new ListOfCommands();
        assertEquals(300, listOfCommands.countNumberOfCustomers(tariffs));
    }

    @Test
    void testSort() {
        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new StandartTariff("Tariff1", 20.0, 100, 5.0, 100));
        tariffs.add(new PROTariff("Tariff2", 10.0, 200, 10.0, 200));

        ListOfCommands listOfCommands = new ListOfCommands();
        listOfCommands.sort(tariffs);

        assertEquals("Tariff2", tariffs.get(0).getName());
        assertEquals("Tariff1", tariffs.get(1).getName());
    }

    @Test
    void testFindTariffByFewParameters() {
        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new StandartTariff("Tariff1", 10.0, 100, 5.0, 100));
        tariffs.add(new PROTariff("Tariff2", 20.0, 200, 10.0, 200));

        ListOfCommands listOfCommands = new ListOfCommands();
        Tariff result = listOfCommands.findTariffByFewParameters(tariffs, 15.0, 25.0);

        assertNotNull(result);
        assertEquals("Tariff2", result.getName());
    }

    @Test
    void testAddAndRemoveTariff() {
        List<Tariff> tariffs = new ArrayList<>();
        Tariff tariff = new StandartTariff("Tariff1", 10.0, 100, 5.0, 100);

        ListOfCommands listOfCommands = new ListOfCommands();
        listOfCommands.addTariff(tariffs, tariff);
        assertEquals(1, tariffs.size());

        listOfCommands.removeTariff(tariffs, tariff);
        assertEquals(0, tariffs.size());
    }

    @Test
    void testFindTariffByNumberOfClients() {
        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new StandartTariff("Tariff1", 10.0, 100, 5.0, 100));
        tariffs.add(new PROTariff("Tariff2", 20.0, 200, 10.0, 200));

        ListOfCommands listOfCommands = new ListOfCommands();
        Tariff result = listOfCommands.findTariffByNumberOfClients(tariffs, 200);

        assertNotNull(result);
        assertEquals("Tariff2", result.getName());
    }
}
