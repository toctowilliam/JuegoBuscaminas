package service;

import interfaces.ICondicionesJuego;

import java.awt.*;

public class LogicaJuego implements ICondicionesJuego {

    private final int[][] tableroMinas;
    private final char[][] tableroPartida;
    private int contadorCasillas;


    public LogicaJuego(int[][] tableroMinas, char[][] tableroPartida) {
        this.tableroMinas = tableroMinas;
        this.tableroPartida = tableroPartida;
    }

    @Override
    public boolean existeMina(Point coordenadas) {
        int x = (int) coordenadas.getX();
        int y = (int) coordenadas.getY();
        return tableroMinas[y][x] == 9;
    }

    @Override
    public boolean seGanoPartida() {
        contadorCasillas = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tableroPartida[i][j] != 'O') {
                    contadorCasillas += 1;
                }
            }
        }
        return contadorCasillas == 90;
    }

    @Override
    public int getCasillasDesbloqueadas() {
        return contadorCasillas;
    }
}
