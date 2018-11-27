
public class Motor {
  private int leistung;
  private int gewicht;
  private int drehmoment;
  private int zylinder;
  private double hubraum;

  public Motor(int pLeistung, int pGewicht, int pDrehmoment, int pZylinder,
               double pHubraum) {
    this.leistung = pLeistung;
    this.gewicht = pGewicht;
    this.drehmoment = pDrehmoment;
    this.zylinder = pZylinder;
    this.hubraum = pHubraum;
  }
}
