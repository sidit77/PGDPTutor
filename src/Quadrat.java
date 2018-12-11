public class Quadrat extends Rechteck {
    public Quadrat(int width) {
        super(width, width);
    }

    @Override
    public void resize(int w, int h) {
        if(w != h)
            return;
        super.resize(w, h);
    }

    public static void main(String[] ra){
        Quadrat q = new Quadrat(4);
        q.resize(4,4);
    }

}
