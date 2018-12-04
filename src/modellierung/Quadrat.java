package modellierung;

public class Quadrat extends Grundflaeche{

    private int laenge;

    public Quadrat(int laenge) {
        this.laenge = laenge;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    @Override
    public boolean istQuadrat() {
        return true;
    }

    @Override
    public Quadrat zuQuadrat() {
        return this;
    }

    @Override
    public double umfang() {
        return 4 * laenge;
    }

    @Override
    public double flaeche() {
        return laenge * laenge;
    }
}
