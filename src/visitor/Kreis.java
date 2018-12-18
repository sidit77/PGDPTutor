package visitor;

public class Kreis extends Grundflaeche {
  private int radius;

  public int getRadius() {
    return radius;
  }
  
  public Kreis(int radius) {
    this.radius = radius;
  }
  
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
