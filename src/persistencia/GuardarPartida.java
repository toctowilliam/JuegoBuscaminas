package persistencia;

import modelo.Tablero;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarPartida {

    public static void guardarEstado(Tablero tablero, String nombreArchivo) {
        try (FileOutputStream archivo = new FileOutputStream(nombreArchivo);
             ObjectOutputStream salida = new ObjectOutputStream(archivo)) {
            salida.writeObject(tablero);
            System.out.println("Partida guardada exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar la partida: " + e.getMessage());
        }
    }
}
