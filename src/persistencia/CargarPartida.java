package persistencia;

import modelo.Tablero;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CargarPartida {

    public static Tablero cargarEstado(String nombreArchivo) {
        try (FileInputStream archivo = new FileInputStream(nombreArchivo);
             ObjectInputStream entrada = new ObjectInputStream(archivo)) {
            return (Tablero) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar la partida: " + e.getMessage());
            return null;
        }
    }
}
