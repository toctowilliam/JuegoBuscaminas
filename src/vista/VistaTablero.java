package vista;

import modelo.ElementoTablero;

public class VistaTablero {
    public void mostrarTablero(ElementoTablero[][] tablero) {
        mostrarTablero(tablero, false); // Por defecto, no mostrar todas las minas
    }
    public void mostrarTablero(ElementoTablero[][] tablero, boolean revelarMinas) {
        System.out.println("    1  2  3  4  5  6  7  8  9  10");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char) ('A' + i) + "  ");
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].estaRevelado()) {
                    if (tablero[i][j] instanceof modelo.CasillaConMina) {
                        System.out.print("x  "); // Mostrar mina descubierta
                    } else if (tablero[i][j] instanceof modelo.CasillaSinMina) {
                        System.out.print(((modelo.CasillaSinMina) tablero[i][j]).getMinasAdyacentes() + "  ");
                    }
                } else if (revelarMinas && tablero[i][j] instanceof modelo.CasillaConMina) {
                    System.out.print("x  "); // Mostrar todas las minas al final del juego
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
