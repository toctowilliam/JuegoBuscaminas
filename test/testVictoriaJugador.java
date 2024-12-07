import modelo.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class testVictoriaJugador {


    @Test
    public void testVictoriaJugador() {
        Tablero tablero = new Tablero(5, 5, 1); // Solo una mina

        // Revelar todas las casillas excepto la mina
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!(tablero.getTablero()[i][j] instanceof modelo.CasillaConMina)) {
                    try {
                        tablero.revelarCasilla(i, j);
                    } catch (Exception e) {
                        fail("No lanza una excepción.");
                    }
                }
            }
        }

        // Comprobar que el jugador gana
        assertTrue(tablero.esVictoria(), "El jugador debería ganar después de revelar todas las casillas sin minas.");
    }
}
