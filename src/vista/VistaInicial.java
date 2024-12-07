package vista;

import java.util.Scanner;

public class VistaInicial {
  private final Scanner scanner = new Scanner(System.in);

  public String mostrarBienvenida() {
    System.out.println("=====================================");
    System.out.println("  Bienvenido a Juego Buscaminas WiSH-MaNi");
    System.out.println("=====================================");
    System.out.println("Por favor, ingresa tu nombre: ");
    return scanner.nextLine().trim();
  }

  public int mostrarOpcionesIniciales(String nombre) {
    System.out.println("\nHola, " + nombre + " Escoge una opción: ");
    System.out.println("1. Iniciar juego");
    System.out.println("2. Salir del juego");

    int opcion = 0;
    while (opcion < 1 || opcion > 2) {
      System.out.print("Selecciona una opción (1 o 2): ");
      try {
        opcion = Integer.parseInt(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Por favor ingresa un número válido.");
      }
    }
    return opcion;
  }

  public void despedirse(String nombre) {
    System.out.println("Gracias por jugar Buscaminas WiSH-MaNi, " + nombre + ". ¡Hasta la próxima!");
  }
}
