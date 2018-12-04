package modellierung;

public class GeoTest {

    public static void main(String[] args){
        Prisma p1 = new Prisma(new NEck(5, 3), 6);
        Prisma p2 = new Prisma(new Rechteck(4,4),4);

        System.out.print(!p1.istWuerfel() ? "" : "Error 1\n");
        System.out.print(Math.abs(p1.volumen() - (10.8253175473055 * 6)) < 0.01? "" : "Error 2\n");
        System.out.print(Math.abs(p1.oberflaeche() - (10.8253175473055 * 2 + 15 * 6)) < 0.01 ? "" : "Error 3\n");

        System.out.print(p2.istWuerfel() ? "" : "Error 1\n");
        System.out.print(Math.abs(p2.volumen() - (4 * 4 * 4)) < 0.01? "" : "Error 2\n");
        System.out.print(Math.abs(p2.oberflaeche() - (4 * 4 * 6)) < 0.01 ? "" : "Error 3\n");
    }

}
