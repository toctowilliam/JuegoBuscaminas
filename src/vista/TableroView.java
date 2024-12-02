package vista;

import modelo.Tablero;

public class TableroView {
    Tablero tablero = new Tablero();
    char[][] tableroInicial = tablero.getTableroInicial();

    public void mostrarTablero() {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println("   1  2  3  4  5  6  7  8  9  10");
        for (int i = 0; i < 10; i++) {
            System.out.print(letras[i] + "  ");
            for (int j = 0; j < 10; j++) {
                System.out.print(tableroInicial[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
