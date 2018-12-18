package visitor;

public class Quadrat extends Grundflaeche {
  private int laenge;

  public int getLaenge() {
    return laenge;
  }

  public Quadrat(int laenge) {
    this.laenge = laenge;
  }
  
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
