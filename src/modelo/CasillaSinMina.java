package modelo;

public class CasillaSinMina extends ElementoTablero {
    private static final long serialVersionUID = 1L;
    private String minasAdyacentes;

    public CasillaSinMina() {
        this.minasAdyacentes = "0";
    }

    public String getMinasAdyacentes() {
        return minasAdyacentes;
    }

    public void setMinasAdyacentes(String minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }

    @Override
    public void accion() {
        this.revelar();
    }

    @Override
    public String toString() {
        return estaRevelado() ? "Minas adyacentes: " + minasAdyacentes : "X";
    }
}
