package controlador;

import modelo.ElementoTablero;
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

  public void iniciarJuego() {
    // Vista inicial: Establece el nombre del jugador
    String nombre = vistaInicial.mostrarBienvenida();
    jugador.setNombre(nombre); // Usa el método set para asignar el nombre

    int opcion = vistaInicial.mostrarOpcionesIniciales(jugador.getNombre()); // Usa el getter para mostrar el nombre

    if (opcion == 2) {
      vistaInicial.despedirse(jugador.getNombre());
      return; // Terminar el programa si el usuario elige salir
    }

    // Si elige iniciar el juego
    boolean juegoActivo = true;

    while (juegoActivo) {
      vistaTablero.mostrarTablero(tablero.getTablero());
      String coordenada = vistaJuego.pedirCoordenada();

      int fila = coordenada.charAt(0) - 'A';
      int columna = Integer.parseInt(coordenada.substring(1)) - 1;

      ElementoTablero elemento = tablero.revelarCasilla(fila, columna);
      elemento.accion(); // Polimorfismo: Llama al método específico de la subclase

      if (elemento instanceof modelo.CasillaConMina) {
        System.out.println("Lo siento, " + jugador.getNombre() + ", ¡has perdido!");
        juegoActivo = false; // Termina el juego si se revela una mina
      }
    }

    System.out.println("Gracias por jugar, " + jugador.getNombre() + ". ¡Hasta la próxima!");
  }
}


