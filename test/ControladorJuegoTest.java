
import controlador.ControladorJuego;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ControladorJuegoTest {

    @Test
    public void testInicializacionJuego() {
        ControladorJuego controlador = new ControladorJuego();
        assertNotNull(controlador);
    }
}