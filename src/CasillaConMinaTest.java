import modelo.CasillaConMina;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasillaConMinaTest {

    @Test
    public void testAccionRevelaMina() {
        CasillaConMina casilla = new CasillaConMina();
        assertFalse(casilla.estaRevelado());
        casilla.accion();
        assertTrue(casilla.estaRevelado());
    }

    @Test
    public void testToStringRevelaMina() {
        CasillaConMina casilla = new CasillaConMina();
        casilla.accion();
        assertEquals("¡Boom! Has perdido.", casilla.toString());
    }
}
