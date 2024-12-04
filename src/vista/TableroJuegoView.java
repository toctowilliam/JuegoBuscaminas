package vista;

public class TableroJuegoView {
    public static char[][] setTable() {
        char[][] tableWithoutMines = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableWithoutMines[i][j] = 'c';
            }
        }
        return tableWithoutMines;
    }
}
