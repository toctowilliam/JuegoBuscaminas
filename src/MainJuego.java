import controlador.JugadorController;
import modelo.Casilla;
import service.LogicaJuego;
import vista.TableroJuegoView;
import vista.TableroView;

import java.awt.*;

public class MainJuego {
    public static void main(String[] args) {
        char[][] tableJuegoIncial =  TableroJuegoView.setTable() ; // Tabla que se mostrara al jugador
        Casilla tableroBuscaminas = new Casilla();
        Point[] arrayMinas = tableroBuscaminas.getCoordinatesMines();
        int[][] tableroMinas = tableroBuscaminas.getTableroConMinas(); //Tabla con minas seteadas
        for(Point coor : arrayMinas){ //Solo por testing
            System.out.println(coor);
        }
        LogicaJuego logicaJuego = new LogicaJuego(tableroMinas, tableJuegoIncial);
        TableroView tableroView = new TableroView(tableJuegoIncial, tableroMinas);
        JugadorController controller = new JugadorController(tableroView,logicaJuego);
        controller.iniciarJuego();
    }
}
