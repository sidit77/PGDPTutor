package modellierung;

public class Kreis extends Grundflaeche {

    private int radius;

    public Kreis(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double umfang() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double flaeche() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
