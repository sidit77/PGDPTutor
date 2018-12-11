public class Rechteck {

    private int width, height;

    public Rechteck(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void resize(int w, int h){
        width = w;
        height = h;
    }

}
