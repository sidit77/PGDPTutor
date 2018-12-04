package modellierung;

public class Rechteck extends Grundflaeche {

    private int laenge, breite;

    public Rechteck(int laenge, int breite) {
        this.laenge = laenge;
        this.breite = breite;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    @Override
    public Quadrat zuQuadrat() {
        if(!istQuadrat())
            return null;
        return new Quadrat(laenge);
    }

    @Override
    public boolean istQuadrat() {
        return laenge == breite;
    }

    @Override
    public double umfang() {
        return 2 * laenge + 2 * breite;
    }

    @Override
    public double flaeche() {
        return laenge * breite;
    }
}
