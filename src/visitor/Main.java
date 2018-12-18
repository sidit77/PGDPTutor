package visitor;

public class Main {

  public static double flaeche(Grundflaeche g) {
    FlaechenVisitor visitor = new FlaechenVisitor();
    g.accept(visitor);
    return visitor.getFlaeche();
  }
  
  public static void main(String[] args) {
    Grundflaeche g1 = new Kreis(7);
    Grundflaeche g2 = new Rechteck(2, 3);
    Grundflaeche g3 = new Rechteck(4, 4);
    Grundflaeche g4 = new NEck(7, 3);
    Grundflaeche g5 = new NEck(4, 5);
    Grundflaeche g6 = new Quadrat(8);
    System.out.println(flaeche(g1));
    System.out.println(flaeche(g2));
    System.out.println(flaeche(g3));
    System.out.println(flaeche(g4));
    System.out.println(flaeche(g5));
    System.out.println(flaeche(g6));

  }

}
