package vista;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class VistaInicial {

  public String mostrarBienvenida() {
    System.out.println("=====================================");
    System.out.println("  Bienvenido a Juego Buscaminas WiSH-MaNi");
    System.out.println("=====================================");
    System.out.println("Por favor, ingresa tu nombre: ");
    return new Scanner(System.in).nextLine().trim();
  }

  public int mostrarOpcionesIniciales(String nombre) {
    System.out.println("\nHola, " + nombre + "! ¿Qué deseas hacer?");
    System.out.println("1. Reanudar partida");
    System.out.println("2. Iniciar nueva partida");
    System.out.println("3. Salir del juego");

    int opcion = 0;
    while (opcion < 1 || opcion > 3) {
      System.out.print("Selecciona una opción (1-3): ");
      try {
        opcion = Integer.parseInt(new Scanner(System.in).nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Por favor ingresa un número válido.");
      }
    }
    return opcion;
  }

  public File seleccionarArchivo() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Selecciona un archivo de partida guardada");
    int seleccion = fileChooser.showOpenDialog(null);

    if (seleccion == JFileChooser.APPROVE_OPTION) {
      return fileChooser.getSelectedFile();
    }
    return null;
  }

  public int leerOpcion(int min, int max) {
    int opcion = 0;
    while (opcion < min || opcion > max) {
      System.out.print("Selecciona una opción (" + min + "-" + max + "): ");
      try {
        opcion = Integer.parseInt(new Scanner(System.in).nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Por favor, ingresa un número válido.");
      }
    }
    return opcion;
  }

  public void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
  }
}
