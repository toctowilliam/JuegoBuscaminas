package vista;

import java.awt.*;
import java.util.Scanner;

public class JugadorView {
    TableroView view = new TableroView();
    Scanner scanner = new Scanner(System.in);
    public void mostrarMenuInicial() {
        System.out.println("1. Iniciar juego");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        opcionesIngresadas(opcion);
    }
    public int opcionesIngresadas(int opcion) {
        switch (opcion) {
            case 1:
                view.mostrarTablero();
                break;
            case 2:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        return opcion;
    }

    public void imprimirDerrota(boolean esGameOver) {
        if (esGameOver) {
            System.out.println("Game Over");
        }
    }
    public void actualizarTablero(Point point, boolean esGameOver) {
        if (esGameOver) {
            System.out.println("Game Over");
        } else {
            System.out.println("Ingrese las coordenadas (" + point.x + "," + point.y + ")");
        }
    }

}
