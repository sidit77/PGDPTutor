package visitor;

public class Rechteck extends Grundflaeche {
  private int breite;

  public int getBreite() {
    return breite;
  }

  private int laenge;

  public int getLaenge() {
    return laenge;
  }
  
  public Rechteck(int breite, int laenge) {
    this.breite = breite;
    this.laenge = laenge;
  }
  
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
