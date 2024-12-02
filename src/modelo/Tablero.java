package modelo;

public class Tablero {
    private int dimensionesTablero;
    private final char[][] tableroInicial = new char[10][10];


    private void setTable() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroInicial[i][j] = 'c';
            }
        }
    }

    public char[][] getTableroInicial() {
        setTable();
        return tableroInicial;
    }
}
