package modelo;

public abstract class ElementoTablero {
    private boolean estaRevelado;

    public ElementoTablero() {
        this.estaRevelado = false;
    }

    public boolean estaRevelado() {
        return estaRevelado;
    }

    public void revelar() {
        this.estaRevelado = true;
    }

    // Método abstracto que será implementado por las subclases
    public abstract void accion();
}