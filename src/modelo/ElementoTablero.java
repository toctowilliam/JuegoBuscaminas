package modelo;

import java.io.Serializable;

public abstract class ElementoTablero implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean estaRevelado;

    public boolean estaRevelado() {
        return estaRevelado;
    }

    public void revelar() {
        estaRevelado = true;
    }

    public abstract void accion();
}
