package controlador;

import modelo.Tablero;
import persistencia.CargarPartida;
import persistencia.GuardarPartida;
import vista.VistaInicial;
import vista.VistaJuego;
import vista.VistaTablero;

import excepciones.CasillaYaDescubiertaException;

import java.io.File;

public class ControladorJuego {
    private Tablero tablero;
    private final VistaJuego vistaJuego;
    private final VistaTablero vistaTablero;
    private final VistaInicial vistaInicial;

    public ControladorJuego() {
        this.tablero = new Tablero(10, 10, 10); // Crear un tablero inicial vacío
        this.vistaJuego = new VistaJuego();
        this.vistaTablero = new VistaTablero();
        this.vistaInicial = new VistaInicial();
    }

    public void iniciarJuego() {
        String nombre = vistaInicial.mostrarBienvenida();

        int opcion = vistaInicial.mostrarOpcionesIniciales(nombre);

        switch (opcion) {
            case 1 -> reanudarPartida();
            case 2 -> nuevaPartida();
            case 3 -> {
                vistaInicial.mostrarMensaje("Gracias por jugar. ¡Hasta la próxima!");
                return;
            }
        }

        ejecutarJuego(); // Comienza el ciclo del juego
    }

    private void ejecutarJuego() {
        boolean juegoActivo = true;

        while (juegoActivo) {
            vistaTablero.mostrarTablero(tablero.getTablero());
            String coordenada = vistaJuego.pedirCoordenada();

            // Manejar opción de guardar la partida
            if (coordenada.equalsIgnoreCase("GUARDAR")) {
                guardarPartida();

                // Mostrar mensaje y opciones después de guardar
                vistaInicial.mostrarMensaje("¿Qué deseas hacer ahora?");
                System.out.println("1. Volver al menú principal");
                System.out.println("2. Continuar jugando");
                System.out.println("3. Salir del juego");

                int opcion = vistaInicial.leerOpcion(1, 3);
                switch (opcion) {
                    case 1 -> {
                        iniciarJuego(); // Volver al menú principal
                        return; // Salir del bucle actual
                    }
                    case 2 -> {
                        continue; // Continuar jugando
                    }
                    case 3 -> {
                        vistaInicial.mostrarMensaje("Gracias por jugar. ¡Hasta la próxima!");
                        System.exit(0); // Terminar el programa
                    }
                }
            }

            if (!validarCoordenada(coordenada)) {
                vistaJuego.mostrarMensaje("Entrada inválida. Por favor, ingresa una coordenada en el formato correcto (Ejemplo: A5).");
                continue;
            }

            int fila = coordenada.charAt(0) - 'A';
            int columna = Integer.parseInt(coordenada.substring(1)) - 1;

            if (manejarAccionCasilla(fila, columna)) {
                juegoActivo = false; // Termina el juego porque el jugador perdió
            }

            if (tablero.esVictoria()) {
                vistaJuego.mostrarVictoria("Jugador");
                juegoActivo = false; // Termina el juego porque el jugador ganó
            }
        }
    }


    private boolean manejarAccionCasilla(int fila, int columna) {
        try {
            modelo.ElementoTablero casilla = tablero.revelarCasilla(fila, columna);
            String coordenada = (char) ('A' + fila) + Integer.toString(columna + 1);

            if (casilla instanceof modelo.CasillaConMina) {
                vistaJuego.mostrarResultado(coordenada, casilla);
                vistaJuego.mostrarMensaje("¡Boom! Has perdido!");
                vistaTablero.mostrarTablero(tablero.getTablero(), true); // Revelar todas las minas
                return true; // Indicar que el jugador perdió
            } else {
                vistaJuego.mostrarResultado(coordenada, casilla);
            }

        } catch (excepciones.CasillaYaDescubiertaException e) {
            vistaJuego.mostrarMensaje("La casilla ya está descubierta. Intenta con otra.");
        } catch (ArrayIndexOutOfBoundsException e) {
            vistaJuego.mostrarMensaje("Coordenadas fuera del tablero. Intenta nuevamente.");
        } catch (Exception e) {
            vistaJuego.mostrarMensaje("Ocurrió un error inesperado: " + e.getMessage());
        }
        return false; // El jugador no perdió
    }


    private void reanudarPartida() {
        File archivo = vistaInicial.seleccionarArchivo();
        if (archivo != null) {
            Tablero cargado = CargarPartida.cargarEstado(archivo.getAbsolutePath());
            if (cargado != null) {
                tablero = cargado;
                vistaInicial.mostrarMensaje("Partida cargada exitosamente.");
            } else {
                vistaInicial.mostrarMensaje("Error al cargar la partida. Se iniciará una nueva partida.");
                nuevaPartida();
            }
        } else {
            vistaInicial.mostrarMensaje("No se seleccionó ningún archivo. Se iniciará una nueva partida.");
            nuevaPartida();
        }
    }

    private void nuevaPartida() {
        tablero = new Tablero(10, 10, 10);
        vistaInicial.mostrarMensaje("Nueva partida iniciada.");
    }

    private void guardarPartida() {
        GuardarPartida.guardarEstado(tablero, "partida_guardada.ser");
        vistaInicial.mostrarMensaje("Partida guardada exitosamente.");
    }

    private boolean validarCoordenada(String coordenada) {
        if (coordenada == null || coordenada.length() < 2) return false;
        char fila = coordenada.charAt(0);
        String columna = coordenada.substring(1);
        return fila >= 'A' && fila <= 'J' && columna.matches("\\d") && Integer.parseInt(columna) >= 1 && Integer.parseInt(columna) <= 10;
    }
}
