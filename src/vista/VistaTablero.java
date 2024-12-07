package vista;

import modelo.ElementoTablero;

public class VistaTablero {
    public void mostrarTablero(ElementoTablero[][] tablero) {
        System.out.println("    1  2  3  4  5  6  7  8  9  10");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((char) ('A' + i) + "  ");
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].estaRevelado()) {
                    if (tablero[i][j] instanceof modelo.CasillaConMina) {
                        System.out.print("M  ");
                    } else if (tablero[i][j] instanceof modelo.CasillaSinMina) {
                        System.out.print(((modelo.CasillaSinMina) tablero[i][j]).getMinasAdyacentes() + "  ");
                    }
                } else {
                    System.out.print("X  ");
                }
            }
            System.out.println();
        }
    }
}
