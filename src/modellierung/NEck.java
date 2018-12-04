package modellierung;

public class NEck extends Grundflaeche {

    private int laenge, ecken;

    public NEck(int laenge, int ecken) {
        this.laenge = laenge;
        this.ecken = ecken;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public int getEcken() {
        return ecken;
    }

    public void setEcken(int ecken) {
        this.ecken = ecken;
    }

    @Override
    public boolean istQuadrat() {
        return ecken == 4;
    }

    @Override
    public double umfang() {
        return laenge * ecken;
    }

    @Override
    public double flaeche() {
        return (ecken * laenge * laenge) / (4 * Math.tan(Math.PI / ecken));
    }
}
