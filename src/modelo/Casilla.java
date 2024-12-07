package modelo;

public class Casilla {
  private boolean esMina;
  private boolean estaRevelada;
  private boolean estaMarcada;
  private int minasAdyacentes;

  // Constructor
  public Casilla() {
    this.esMina = false;
    this.estaRevelada = false;
    this.estaMarcada = false;
    this.minasAdyacentes = 0;
  }

  // Getters y Setters
  public boolean esMina() { return esMina; }
  public void setEsMina(boolean esMina) { this.esMina = esMina; }

  public boolean estaRevelada() { return estaRevelada; }
  public void revelar() { this.estaRevelada = true; }

  public boolean estaMarcada() { return estaMarcada; }
  public void marcar() { this.estaMarcada = !estaMarcada; }

  public int getMinasAdyacentes() { return minasAdyacentes; }
  public void setMinasAdyacentes(int minasAdyacentes) { this.minasAdyacentes = minasAdyacentes; }
}
