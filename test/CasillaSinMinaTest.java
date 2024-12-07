
import modelo.CasillaSinMina;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasillaSinMinaTest {

    @Test
    public void testMinasAdyacentes() {
        CasillaSinMina casilla = new CasillaSinMina();
        casilla.setMinasAdyacentes("2");
        assertEquals("2", casilla.getMinasAdyacentes());
    }

    @Test
    public void testAccionRevelaCasilla() {
        CasillaSinMina casilla = new CasillaSinMina();
        assertFalse(casilla.estaRevelado());
        casilla.accion();
        assertTrue(casilla.estaRevelado());
    }
}
