package vista;

import java.awt.*;

public class TableroView {
    private final char[][] table;
    private final int[][] tableroLogica;

    public TableroView(char[][] table, int[][] tableroLogica) {
        this.table = table;
        this.tableroLogica = tableroLogica;
    }

    public void mostrarTableroFinal() {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println("    1    2    3    4    5    6    7    8    9    10\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(letras[i] + "    ");
            for (int j = 0; j < 10; j++) {
                switch (tableroLogica[i][j]) {
                    case 0:
                        System.out.print('V' + "    ");
                        break;
                    case 9:
                        System.out.print('M' + "    ");
                        break;
                    default:
                        System.out.print(tableroLogica[i][j] + "    ");
                }
                // System.out.print(tableroLogica[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public void mostrarTablero() {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println("    1    2    3    4    5    6    7    8    9    10\n");

        for (int i = 0; i < 10; i++) {
            System.out.print(letras[i] + "    ");
            for (int j = 0; j < 10; j++) {
                System.out.print(table[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public void actualizarTablero(Point coordenadas, boolean esGameOver) {
        int x = (int) coordenadas.getX();
        int y = (int) coordenadas.getY();
        if (esGameOver) {
            table[y][x] = 'M';
            mostrarTableroFinal();
        } else {
            table[y][x] = 'V';
            mostrarDerecha(coordenadas); //1
            mostrarArriba(coordenadas); //2
            mostrarAbajo(coordenadas); //3
            mostrarIzquierda(coordenadas); //4
            mostrarDiagonalDerechaSuperior(coordenadas); //5
            mostrarDiagonalIzquierdaInferior(coordenadas); //6
            mostrarDiagonalIzquierdaSuperior(coordenadas); //7
            mostrarDiagonalDerechaInferior(coordenadas); //8
        }
        mostrarTableroFinal();
        System.out.println();
        mostrarTablero();
    }

    public void mostrarDerecha(Point coor) {
        //x,y
        //4,5
        if (coor.getX() < 9) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            int nextCasilla = x + 1;
            int casillasPorChequear = (table.length - 1) - x; //Casillas por chequear
            while (casillasPorChequear > 0) {
                if (tableroLogica[y][nextCasilla] == 9) {
                    table[y][nextCasilla] = 'c';
                    break;
                } else if (tableroLogica[y][nextCasilla] != 0) {
                    char character = Character.forDigit(tableroLogica[y][nextCasilla], 10);
                    table[y][nextCasilla] = character;
                    break;
                } else {
                    table[y][nextCasilla] = 'V';
                    nextCasilla++;
                    casillasPorChequear--;
                }
            }
        }
    }

    public void mostrarArriba(Point coor) {
        if (coor.getY() > 0) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            int nextCasilla = y - 1;
            int casillasPorChequear = y; //Casillas por chequear
            while (casillasPorChequear > 0) {
                if (tableroLogica[nextCasilla][x] == 9) {
                    table[nextCasilla][x] = 'c';
                    break;
                } else if (tableroLogica[nextCasilla][x] != 0) {
                    char character = Character.forDigit(tableroLogica[nextCasilla][x], 10);
                    table[nextCasilla][x] = character;
                    break;
                } else {
                    table[nextCasilla][x] = 'V';
                    nextCasilla--;
                    casillasPorChequear--;
                }
            }
        }
    }

    public void mostrarAbajo(Point coor) {
        if (coor.getY() < 9) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            int nextCasilla = y + 1;
            int casillasPorChequear = (table.length - 1) - y; //Casillas por chequear
            while (casillasPorChequear > 0) {
                if (tableroLogica[nextCasilla][x] == 9) {
                    table[nextCasilla][x] = 'c';
                    break;
                } else if (tableroLogica[nextCasilla][x] != 0) {
                    char character = Character.forDigit(tableroLogica[nextCasilla][x], 10);
                    table[nextCasilla][x] = character;
                    break;
                } else {
                    table[nextCasilla][x] = 'V';
                    nextCasilla++;
                    casillasPorChequear--;
                }
            }
        }
    }

    public void mostrarIzquierda(Point coor) {
        if (coor.getX() > 0) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            int nextCasilla = x - 1;
            int casillasPorChequear = x; //Casillas por chequear
            while (casillasPorChequear > 0) {
                if (tableroLogica[y][nextCasilla] == 9) {
                    table[y][nextCasilla] = 'c';
                    break;
                } else if (tableroLogica[y][nextCasilla] != 0) {
                    char character = Character.forDigit(tableroLogica[y][nextCasilla], 10);
                    table[y][nextCasilla] = character;
                    break;
                } else {
                    table[y][nextCasilla] = 'V';
                    nextCasilla--;
                    casillasPorChequear--;
                }
            }
        }
    }

    public void mostrarDiagonalDerechaSuperior(Point coor) {
        //x,y
        //4,5
        if (coor.getX() < 9 && coor.getY() > 0) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            int nextCasillaX = x + 1;
            int nextCasillaY = y - 1;
            while (nextCasillaX <= 9 && nextCasillaY >= 0) {
                if (tableroLogica[nextCasillaY][nextCasillaX] == 9) {
                    table[nextCasillaY][nextCasillaX] = 'c';
                    break;
                } else if (tableroLogica[nextCasillaY][nextCasillaX] != 0) {
                    char character = Character.forDigit(tableroLogica[nextCasillaY][nextCasillaX], 10);
                    table[nextCasillaY][nextCasillaX] = character;
                    break;
                } else {
                    table[nextCasillaY][nextCasillaX] = 'V';
                    nextCasillaX++;
                    nextCasillaY--;
                }
            }
        }
    }

    public void mostrarDiagonalIzquierdaInferior(Point coor) {
        //x,y
        //4,5
        if (coor.getX() > 0 && coor.getY() < 9) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            int nextCasillaX = x - 1;
            int nextCasillaY = y + 1;
            while (nextCasillaX >= 0 && nextCasillaY <= 9) { //Super Fixed it
                if (tableroLogica[nextCasillaY][nextCasillaX] == 9) {
                    table[nextCasillaY][nextCasillaX] = 'c';
                    break;
                } else if (tableroLogica[nextCasillaY][nextCasillaX] != 0) {
                    char character = Character.forDigit(tableroLogica[nextCasillaY][nextCasillaX], 10);
                    table[nextCasillaY][nextCasillaX] = character;
                    break;
                } else {
                    table[nextCasillaY][nextCasillaX] = 'V';
                    nextCasillaX--;
                    nextCasillaY++;
                }
            }
        }
    }

    public void mostrarDiagonalIzquierdaSuperior(Point coor) {
        //x,y
        //4,5
        if (coor.getX() > 0 && coor.getY() > 0) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            int nextCasillaX = x - 1;
            int nextCasillaY = y - 1;
            while (nextCasillaX >= 0 && nextCasillaY >= 0) {
                if (tableroLogica[nextCasillaY][nextCasillaX] == 9) {
                    table[nextCasillaY][nextCasillaX] = 'c';
                    break;
                } else if (tableroLogica[nextCasillaY][nextCasillaX] != 0) {
                    char character = Character.forDigit(tableroLogica[nextCasillaY][nextCasillaX], 10);
                    table[nextCasillaY][nextCasillaX] = character;
                    break;
                } else {
                    table[nextCasillaY][nextCasillaX] = 'V';
                    nextCasillaX--;
                    nextCasillaY--;
                }
            }
        }
    }

    public void mostrarDiagonalDerechaInferior(Point coor) {
        //x,y
        //4,5
        if (coor.getX() < 9 && coor.getY() < 9) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            int nextCasillaX = x + 1;
            int nextCasillaY = y + 1;
            while (nextCasillaX <= 9 && nextCasillaY <= 9) {
                if (tableroLogica[nextCasillaY][nextCasillaX] == 9) {
                    table[nextCasillaY][nextCasillaX] = 'c';
                    break;
                } else if (tableroLogica[nextCasillaY][nextCasillaX] != 0) {
                    char character = Character.forDigit(tableroLogica[nextCasillaY][nextCasillaX], 10);
                    table[nextCasillaY][nextCasillaX] = character;
                    break;
                } else {
                    table[nextCasillaY][nextCasillaX] = 'V';
                    nextCasillaX++;
                    nextCasillaY++;
                }
            }
        }
    }
}
