package vista;

import java.util.Scanner;

public class VistaJuego {
  private final Scanner scanner = new Scanner(System.in);

  public String pedirCoordenada() {
    System.out.println("Ingrese una coordenada (Ejemplo: A5): ");
    return scanner.nextLine().trim().toUpperCase();
  }

  public void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
  }
}
