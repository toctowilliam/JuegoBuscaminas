package controlador;

import interfaces.ICondicionesJuego;
import vista.JugadorView;
import vista.TableroView;

import java.awt.*;

public class JugadorController {

    private final JugadorView jugadorView = new JugadorView();
    private final TableroView tableroView;
    ICondicionesJuego condicionesJuego;

    public JugadorController(TableroView tableroView, ICondicionesJuego condicionesJuego) {
        this.condicionesJuego = condicionesJuego;
        this.tableroView = tableroView;
    }


    public void iniciarJuego() {
        boolean exitMenuInicial = false;
        while (!exitMenuInicial) {
            int opcionUsuario = jugadorView.mostrarMenuInicial();
            switch (opcionUsuario) {
                case 1:
                    boolean exit = false;
                    tableroView.mostrarTableroFinal(); //this is just for test
                    System.out.println();
                    tableroView.mostrarTablero(); //This is the table seen by the user
                    do {
                        int opcionJuego = jugadorView.mostrarOpcionesJuego();
                        switch (opcionJuego) {
                            case 1:
                                //int x = coordenadaX() - 1;
                                //int y = coordenadaY() - 1;
                                int x = coordenadaX();
                                int y = coordenadaY();
                                int xLogica = x - 1;
                                int yLogica = y - 1;
                                System.out.println("You enter the following coordinate (" + x + "," + y + ")");
                                boolean esGameOver = existeMina(new Point(xLogica, yLogica));
                                if (esGameOver) {
                                    jugadorView.imprimirDerrota(true);
                                    tableroView.actualizarTablero(new Point(xLogica, yLogica), true);
                                    exit = true;
                                    exitMenuInicial = true;
                                } else {
                                    tableroView.actualizarTablero(new Point(xLogica, yLogica), false);
                                }
                                break;
                            case 2:
                                //Under construction
                                break;
                            case 3:
                                break;
                        }

                    } while (!exit);
                    break;
                case 2:
                    System.out.println("Bye!");
                    exitMenuInicial = true;
                    break;
                default:
                    System.out.println("Por favor ingrese correcta una de las opciones que se muestran (1-2)");
            }
        }
    }
    private int coordenadaX() {
        return jugadorView.preguntarCoordenadaX();
    }

    private int coordenadaY() {
        return jugadorView.preguntarCoordenadaY();
    }

    private boolean existeMina(Point puntos) {
        return condicionesJuego.existeMina(puntos);
    }

}
