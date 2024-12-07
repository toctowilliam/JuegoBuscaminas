package vista;

import modelo.ElementoTablero;

import java.util.Scanner;

public class VistaJuego {
  private final Scanner scanner = new Scanner(System.in);

  public String pedirCoordenada() {
    System.out.println("Ingrese una coordenada (Ejemplo: A5): ");
    System.out.println("Si deseas guardar la partida, escribe 'guardar'.");

    return scanner.nextLine().trim().toUpperCase();
  }


  public void mostrarErrorEntrada() {
    System.out.println("Entrada inválida. Por favor, ingresa una coordenada en el formato correcto (Ejemplo: A5).");
  }

  public void mostrarResultado(String coordenada, ElementoTablero elemento) {
    System.out.println("Casilla revelada " + coordenada + ": " + elemento);
  }

  public void mostrarVictoria(String nombre) {
    System.out.println("¡Felicidades, " + nombre + "! Has ganado.");
  }

  public void mostrarDespedida(String nombre) {
    System.out.println("Gracias por jugar, " + nombre + ". ¡Hasta la próxima!");
  }

  // Método para mostrar mensajes genéricos
  public void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
  }
}
