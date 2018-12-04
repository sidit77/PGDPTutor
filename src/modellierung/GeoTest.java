package modellierung;

public class GeoTest {

    public static void main(String[] args){
        Grundflaeche g1 = new Kreis(3);
        Grundflaeche g2 = new Rechteck(3, 5);

        System.out.println(g1.toString());
    }

}
