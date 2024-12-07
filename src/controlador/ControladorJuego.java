package controlador;

import modelo.Jugador;
import modelo.Tablero;
import vista.VistaInicial;
import vista.VistaJuego;
import vista.VistaTablero;

public class ControladorJuego {
  private final Tablero tablero;
  private final VistaJuego vistaJuego;
  private final VistaTablero vistaTablero;
  private final VistaInicial vistaInicial;
  private final Jugador jugador; // Instancia de jugador

  public ControladorJuego() {
    this.tablero = new Tablero(10, 10, 10);
    this.vistaJuego = new VistaJuego();
    this.vistaTablero = new VistaTablero();
    this.vistaInicial = new VistaInicial();
    this.jugador = new Jugador(""); // Inicializa el jugador sin nombre
  }
}

