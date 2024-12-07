package modelo;

public class CasillaConMina extends ElementoTablero {
    private static final long serialVersionUID = 1L;

    @Override
    public void accion() {
        this.revelar();
    }

    @Override
    public String toString() {
        return estaRevelado() ? "¡Boom! Has perdido." : "X";
    }
}
