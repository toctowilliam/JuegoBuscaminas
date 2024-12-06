package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JugadorView {

    Scanner scanner = new Scanner(System.in);

    public JugadorView() {
    }

    public int mostrarMenuInicial() {
        System.out.println("Bienvenido");
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println("1. Jugar");
        System.out.println("2. Salir");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return switch (opcion) {
                case 1 -> 1;
                case 2 -> 2;
                default -> 0;
            };
        } catch (InputMismatchException ex) {
            System.out.println("Por favor ingrese un opción que corresponda al menú mostrado en formato número");
            scanner.nextLine();
            return 0;
        }
    }

    public int mostrarOpcionesJuego() {
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println("1. ingresar coordenada");
        System.out.println("2. ingresar advertencia"); // El jugador puede marcar casillas que considera que contienen minas.
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return switch (opcion) {
                case 1 -> 1;
                case 2 -> 2;
                default -> 0;
            };
        } catch (InputMismatchException ex) {
            System.out.println("Ingrese de forma correcta una de las opciones de juego mostradas");
            scanner.nextLine();
            return 0;
        }
    }

    public int preguntarCoordenadaX() {
        Scanner scanner = new Scanner(System.in);
        int x;
        System.out.println("Ingrese la coordenada en x entre 1 y 10:");

        while (true) {
            // Verifica si la entrada es un entero válido
            if (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número entero válido: ");
                scanner.next(); // Limpia el input inválido
                continue; // Vuelve a pedir el número
            }
            x = scanner.nextInt();
            // Verifica si el número está dentro del rango permitido
            if (x < 1 || x > 10) {
                System.out.print("El número debe estar entre 1 y 10. Intente nuevamente: ");
            } else {
                break; // El número es válido, salir del bucle
            }
        }
        return x;
    }

    public int preguntarCoordenadaY() {
        int y = 0;
        boolean ingresoCorrecto;

        do {
            System.out.println("Ingrese la coordenada en y (A-J)");
            String letra = scanner.next().trim().toLowerCase();
            ingresoCorrecto = true;
            switch (letra) {
                case "a":
                    y = 1;
                    break;
                case "b":
                    y = 2;
                    break;
                case "c":
                    y = 3;
                    break;
                case "d":
                    y = 4;
                    break;
                case "e":
                    y = 5;
                    break;
                case "f":
                    y = 6;
                    break;
                case "g":
                    y = 7;
                    break;
                case "h":
                    y = 8;
                    break;
                case "i":
                    y = 9;
                    break;
                case "j":
                    y = 10;
                    break;
                default:
                    ingresoCorrecto = false;
                    System.out.println("Por favor ingrese la coordenada en Y en el formato correcto (A-J)");
            }
        } while (!ingresoCorrecto);
        return y;
    }

    public void imprimirDerrota(boolean esGameOver) {
        if (esGameOver) {
            System.out.println("Perdiste, existe un mina!!");
        }
    }

    public void imprimirVictoria() {
        System.out.println("Felicidades has gando la partida!!");
    }

    public void imprimirCasillasDesbloqueadas(int numCasillas) {
        System.out.println("-------------------------------------");
        System.out.println("\t\t" + numCasillas + " desbloqueadas");
        System.out.println("-------------------------------------");

    }
}
