import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TariffTest {

    @Test
    void testSettersAndGetters() {
        Tariff tariff = new StandartTariff("Basic", 10.0, 100, 5.0, 100);

        tariff.setName("Updated");
        assertEquals("Updated", tariff.getName());

        tariff.setMonthlyFee(20.0);
        assertEquals(20.0, tariff.getMonthlyFee());

        tariff.setNumberOfClients(200);
        assertEquals(200, tariff.getNumberOfClients());

        tariff.setDataLimit(10.0);
        assertEquals(10.0, tariff.getDataLimit());

        tariff.setMinutes(200);
        assertEquals(200, tariff.getMinutes());
    }

    @Test
    void testPrintInfo() {
        Tariff tariff = new StandartTariff("Basic", 10.0, 100, 5.0, 100);
        assertDoesNotThrow(tariff::printInfo);
    }
}
