package modelo;

public class CasillaSinMina extends ElementoTablero {
    private int minasAdyacentes;

    public CasillaSinMina() {
        this.minasAdyacentes = 0;
    }

    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    public void setMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }

    @Override
    public void accion() {
        System.out.println("Casilla revelada. Minas adyacentes: " + minasAdyacentes);
    }
}