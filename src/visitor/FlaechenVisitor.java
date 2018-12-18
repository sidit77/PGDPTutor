package visitor;

public class FlaechenVisitor implements Visitor {
  private double flaeche;
  
  public double getFlaeche() {
    return flaeche;
  }

  @Override
  public void visit(Kreis kreis) {
    flaeche = Math.PI * Math.pow(kreis.getRadius(), 2);
  }

  @Override
  public void visit(NEck neck) {
    flaeche = neck.getN() * Math.pow(neck.getLaenge(), 2) / (4 * Math.tan(Math.PI / neck.getN()));
  }

  @Override
  public void visit(Quadrat quadrat) {
    flaeche = quadrat.getLaenge() * quadrat.getLaenge();
  }

  @Override
  public void visit(Rechteck rechteck) {
    flaeche = rechteck.getBreite() * rechteck.getLaenge();
  }

}
