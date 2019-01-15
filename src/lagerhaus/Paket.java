package lagerhaus;

import java.util.Objects;

public class Paket implements Comparable<Paket> {

    private String adresse;
    private int gewicht;

    public Paket(String adresse, int gewicht) {
        this.adresse = adresse;
        this.gewicht = gewicht;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paket paket = (Paket) o;
        return gewicht == paket.gewicht &&
                Objects.equals(adresse, paket.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresse, gewicht);
    }

    @Override
    public int compareTo(Paket paket) {
        return gewicht - paket.gewicht;
    }
}
