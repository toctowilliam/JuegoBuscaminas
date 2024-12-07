import modelo.Tablero;
import modelo.CasillaSinMina;
import modelo.ElementoTablero;
import excepciones.CasillaYaDescubiertaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void testInicializacionTablero() {
        Tablero tablero = new Tablero(10, 10, 10);
        assertNotNull(tablero.getTablero());
        assertEquals(10, tablero.getTablero().length);
    }

    @Test
    public void testColocacionMinas() {
        Tablero tablero = new Tablero(10, 10, 10);
        int minas = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.getTablero()[i][j] instanceof modelo.CasillaConMina) {
                    minas++;
                }
            }
        }
        assertEquals(10, minas);
    }

    @Test
    public void testRevelarCasillaSinMina() throws Exception {
        Tablero tablero = new Tablero(10, 10, 10);
        ElementoTablero casilla = tablero.revelarCasilla(0, 0);
        assertTrue(casilla.estaRevelado());
    }

    /**
     * Prueba TDD para revelar casillas adyacentes si no hay minas cercanas.
     */
    @Test
    public void testRevelarCasillaSinMinasAdyacentes() throws Exception {
        // Configuración: Tablero de 5x5 sin minas
        Tablero tablero = new Tablero(5, 5, 0); // Sin minas

        // Revelar una casilla en el centro
        tablero.revelarCasilla(2, 2);

        // Verificar que todas las casillas estén reveladas porque no hay minas
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertTrue(tablero.getTablero()[i][j].estaRevelado(),
                        "La casilla (" + i + "," + j + ") debería estar revelada.");
            }
        }
    }

    /**
     * Prueba TDD para manejar excepciones al intentar revelar una casilla ya descubierta.
     */
    @Test
    public void testRevelarCasillaYaDescubierta() {
        Tablero tablero = new Tablero(5, 5, 0); // Sin minas

        try {
            // Revelar una casilla
            tablero.revelarCasilla(2, 2);

            // Intentar revelar la misma casilla nuevamente
            tablero.revelarCasilla(2, 2);
            fail("Debería lanzarse una excepción CasillaYaDescubiertaException.");
        } catch (CasillaYaDescubiertaException e) {
            assertEquals("La casilla ya ha sido descubierta.", e.getMessage());
        } catch (Exception e) {
            fail("Se lanzó una excepción inesperada: " + e.getMessage());
        }
    }
}
