package modellierung;

public class Prisma {

    private Grundflaeche grundflaeche;
    private int hoehe;

    public Prisma(Grundflaeche grundflaeche, int hoehe) {
        this.grundflaeche = grundflaeche;
        this.hoehe = hoehe;
    }

    public Grundflaeche getGrundflaeche() {
        return grundflaeche;
    }

    public void setGrundflaeche(Grundflaeche grundflaeche) {
        this.grundflaeche = grundflaeche;
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public double volumen(){
        return grundflaeche.flaeche() * hoehe;
    }

    public double oberflaeche(){
        return grundflaeche.flaeche() * 2 + grundflaeche.umfang() * hoehe;
    }

    @Override
    public String toString() {
        return String.format("[volumen = %f oberfläche = %f", volumen(), oberflaeche());
    }
}
