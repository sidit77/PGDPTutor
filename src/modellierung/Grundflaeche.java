package modellierung;

public abstract class Grundflaeche {

    public abstract double umfang();

    public abstract double flaeche();

    public boolean istQuadrat(){
        return false;
    }

    @Override
    public String toString(){
        return "[umfang = " + umfang() + " flaeche = " + flaeche() + "]";
    }

}
