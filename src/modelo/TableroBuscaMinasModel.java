package modelo;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TableroBuscaMinasModel {
    private final TableroInicialModel TableroInicialModel = new TableroInicialModel();
    private Point[] coordinatesMines = new Point[10];
    private final int[][] tableroConMinas = TableroInicialModel.getTableroInicial();


    public TableroBuscaMinasModel(){
        generateCoordinatesMines(); //Genera el array de las coordenadas de minas aleatorias apenas se llama al constructor de esta clase
        setMinasTable(); //Setea las minas en  tablero
        setNumerosMinasAdyacentes();
    }
    //getter
    public Point[] getCoordinatesMines() {
        return this.coordinatesMines;
    }

    public int[][] getTableroConMinas() {
        return this.tableroConMinas;
    }

    public void generateCoordinatesMines() {
        Set<Point> uniqueCoordinates = new HashSet<>(); //It is an unordered collection of objects in which duplicate values cannot be stored.
        Random random = new Random();
        while (uniqueCoordinates.size() < 10) {
            int cooX = random.nextInt(10);
            int cooY = random.nextInt(10);
            Point newCoor = new Point(cooX, cooY);
            uniqueCoordinates.add(newCoor); // Add the new point to the set if it's unique
        }
        // Convert the set to an array
        coordinatesMines = uniqueCoordinates.toArray(new Point[0]);
    }

    private void setMinasTable() {
        for (Point coor : coordinatesMines) {
            int x = (int) coor.getX();
            int y = (int) coor.getY();
            tableroConMinas[y][x] = 9; //9 significa mina
        }
    }

    private void setNumerosMinasAdyacentes() {

        for (Point coor : coordinatesMines) {
            setEsquinaIzqSuperior(coor); //1
            setIzquierda(coor); //2
            setEsquinaIzqInferior(coor); //3
            setMedioInferior(coor); //4
            setEsquinaDerechaInferior(coor); //5
            setDerecha(coor); //6
            setEsquinaDerechaSuperior(coor); //7
            setMedioSuperior(coor); //8
        }

    }

    private boolean verificarLimites(Point coor) {
        return (coor.getX() >= 0 && coor.getX() <= 9) && (coor.getY() >= 0 && coor.getY() <= 9);
    }

    private boolean existeMinaAdyacente(Point coorCheck){
        for (Point coor : coordinatesMines)
        {
            if(coorCheck.equals(coor)){
                return true;
            }
        }
        return false;
    }

    private void setEsquinaIzqSuperior(Point coor) {
        //Coordenadas goes from 0 to 9
        // coordenadas(8,2)
        int x = (int) coor.getX() - 1; //7
        int y = (int) coor.getY() - 1; //1
        Point nuevaCoor = new Point(x, y);
        boolean estaDentroLimites = verificarLimites(nuevaCoor);
        boolean chocaConMina = existeMinaAdyacente(nuevaCoor);
        if (estaDentroLimites && !chocaConMina) {
            //Array 2D
            tableroConMinas[y][x] += 1;
        }
    }

    private void setIzquierda(Point coor) {
        //Coordenadas goes from 0 to 9
        // coordenadas(8,2)
        int x = (int) coor.getX() - 1; //7
        int y = (int) coor.getY(); //2
        Point nuevaCoor = new Point(x, y);
        boolean estaDentroLimites = verificarLimites(nuevaCoor);
        boolean chocaConMina = existeMinaAdyacente(nuevaCoor);
        if (estaDentroLimites && !chocaConMina) {
            //Array 2D
            tableroConMinas[y][x] += 1;
        }
    }

    private void setEsquinaIzqInferior(Point coor) {
        //Coordenadas goes from 0 to 9
        // coordenadas(8,2)
        int x = (int) coor.getX() - 1; //7
        int y = (int) coor.getY() + 1; //3
        Point nuevaCoor = new Point(x, y);
        boolean estaDentroLimites = verificarLimites(nuevaCoor);
        boolean chocaConMina = existeMinaAdyacente(nuevaCoor);
        if (estaDentroLimites && !chocaConMina) {
            //Array 2D
            tableroConMinas[y][x] += 1;
        }
    }

    private void setMedioInferior(Point coor) {
        //Coordenadas goes from 0 to 9
        // coordenadas(8,2)
        int x = (int) coor.getX(); //8
        int y = (int) coor.getY() + 1; //3
        Point nuevaCoor = new Point(x, y);
        boolean estaDentroLimites = verificarLimites(nuevaCoor);
        boolean chocaConMina = existeMinaAdyacente(nuevaCoor);
        if (estaDentroLimites && !chocaConMina) {
            //Array 2D
            tableroConMinas[y][x] += 1;
        }
    }

    private void setEsquinaDerechaInferior(Point coor) {
        //Coordenadas goes from 0 to 9
        // coordenadas(8,2)
        int x = (int) coor.getX() + 1; //9
        int y = (int) coor.getY() + 1; //3
        Point nuevaCoor = new Point(x, y);
        boolean estaDentroLimites = verificarLimites(nuevaCoor);
        boolean chocaConMina = existeMinaAdyacente(nuevaCoor);
        if (estaDentroLimites && !chocaConMina) {
            //Array 2D
            tableroConMinas[y][x] += 1;
        }
    }

    private void setDerecha(Point coor) {
        //Coordenadas goes from 0 to 9
        // coordenadas(8,2)
        int x = (int) coor.getX() + 1; //9
        int y = (int) coor.getY(); //2
        Point nuevaCoor = new Point(x, y);
        boolean estaDentroLimites = verificarLimites(nuevaCoor);
        boolean chocaConMina = existeMinaAdyacente(nuevaCoor);
        if (estaDentroLimites && !chocaConMina) {
            //Array 2D
            tableroConMinas[y][x] += 1;
        }
    }


    private void setEsquinaDerechaSuperior(Point coor) {
        //Coordenadas goes from 0 to 9
        // coordenadas(8,2)
        int x = (int) coor.getX() + 1; //9
        int y = (int) coor.getY() - 1; //1
        Point nuevaCoor = new Point(x, y);
        boolean estaDentroLimites = verificarLimites(nuevaCoor);
        boolean chocaConMina = existeMinaAdyacente(nuevaCoor);
        if (estaDentroLimites && !chocaConMina) {
            //Array 2D
            tableroConMinas[y][x] += 1;
        }
    }

    private void setMedioSuperior(Point coor) {
        //Coordenadas goes from 0 to 9
        // coordenadas(8,2)
        int x = (int) coor.getX(); //8
        int y = (int) coor.getY() - 1; //1
        Point nuevaCoor = new Point(x, y);
        boolean estaDentroLimites = verificarLimites(nuevaCoor);
        boolean chocaConMina = existeMinaAdyacente(nuevaCoor);
        if (estaDentroLimites && !chocaConMina) {
            //Array 2D
            tableroConMinas[y][x] += 1;
        }
    }
}
