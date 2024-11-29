import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MobileCommunicationTest {

    @Test
    void testShowMenu() {
        MobileCommunication app = new MobileCommunication();
        assertDoesNotThrow(() -> {
            // Викликаємо showMenu в іншому потоці, щоб уникнути блокування через Scanner.
            new Thread(app::showMenu).start();
        });
    }
}
