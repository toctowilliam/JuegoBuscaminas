package modelo;

public class CasillaConMina extends ElementoTablero {

    @Override
    public void accion() {
        System.out.println("¡Boom! Has perdido.");
    }
}
