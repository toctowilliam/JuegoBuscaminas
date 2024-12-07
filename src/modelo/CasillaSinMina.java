package modelo;

public class CasillaSinMina extends ElementoTablero {
    private String minasAdyacentes;

    public CasillaSinMina() {
        this.minasAdyacentes = String.valueOf(0);
    }

    public String getMinasAdyacentes() {
        return minasAdyacentes;
    }

    public void setMinasAdyacentes(String minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }

    @Override
    public void accion() {
        System.out.println("Casilla revelada. Minas adyacentes: " + minasAdyacentes);
    }
}