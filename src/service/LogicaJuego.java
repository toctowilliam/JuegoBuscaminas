package service;
import interfaces.ICondicionesJuego;

import java.awt.*;

public class LogicaJuego implements ICondicionesJuego {

    private final int[][] tableroMinas;

    public LogicaJuego(int[][] tableroMinas){
        this.tableroMinas = tableroMinas;
    }
    @Override
    public boolean existeMina(Point coordenadas) {
        /*or(Point coor : arrayMinas) {
            existeMina = coor.equals(coordenadas); //Si las coordenadas ingresadas  coincide con alguna coordenada dentro de array minas
            if (existeMina){
                return true;
            }
        }*/
        int x = (int) coordenadas.getX();
        int y = (int) coordenadas.getY();
        return tableroMinas[y][x] == 9;
    }
}
