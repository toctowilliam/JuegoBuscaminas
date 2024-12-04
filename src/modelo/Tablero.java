package modelo;

public class Tablero {
    private final int[][] tableroInicial = new int[10][10];

    private void setTable() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroInicial[i][j] = 0;
            }
        }
    }
    public int[][] getTableroInicial() {
        setTable();
        return tableroInicial;
    }
}
