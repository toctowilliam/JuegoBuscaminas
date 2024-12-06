package interfaces;

import java.awt.*;

public interface ICondicionesJuego {
    boolean existeMina(Point coordenadas);
    boolean seGanoPartida();
    int getCasillasDesbloqueadas();
}
