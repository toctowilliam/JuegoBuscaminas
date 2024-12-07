package modelo;

import java.util.Random;

public class Tablero {
    private final ElementoTablero[][] tablero;
    private final int filas;
    private final int columnas;
    private final int cantidadMinas;

    public Tablero(int filas, int columnas, int cantidadMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.cantidadMinas = cantidadMinas;
        this.tablero = new ElementoTablero[filas][columnas];
        inicializarTablero();
        colocarMinas();
        calcularMinasAdyacentes();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new CasillaSinMina(); // Inicialmente todas son casillas sin minas
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < cantidadMinas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);

            if (!(tablero[fila][columna] instanceof CasillaConMina)) {
                tablero[fila][columna] = new CasillaConMina();
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAdyacentes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] instanceof CasillaSinMina) {
                    int minas = contarMinasAdyacentes(i, j);
                    ((CasillaSinMina) tablero[i][j]).setMinasAdyacentes(minas);
                }
            }
        }
    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int minas = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (esCoordenadaValida(nuevaFila, nuevaColumna) &&
                        tablero[nuevaFila][nuevaColumna] instanceof CasillaConMina) {
                    minas++;
                }
            }
        }
        return minas;
    }

    private boolean esCoordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public ElementoTablero[][] getTablero() {
        return tablero;
    }

    public ElementoTablero revelarCasilla(int fila, int columna) {
        ElementoTablero elemento = tablero[fila][columna];
        elemento.revelar();
        return elemento;
    }
}

