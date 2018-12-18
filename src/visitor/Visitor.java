package visitor;

public interface Visitor {
  void visit(Kreis kreis);

  void visit(NEck neck);

  void visit(Quadrat quadrat);

  void visit(Rechteck rechteck);
}
