package modellierung;

public abstract class Grundflaeche {

    public abstract double umfang();

    public abstract double flaeche();

    public boolean istQuadrat(){
        return false;
    }

    public Quadrat zuQuadrat(){
        return null;
    }

    @Override
    public String toString(){
        return "[umfang = " + umfang() + " flaeche = " + flaeche() + "]";
    }

}
