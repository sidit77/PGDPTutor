public class Pi {

    private static double leibniz(long n){
        if(n == 0)
            return 4;
        if(n % 2 == 0)
            return  4.0 / (2 * n + 1) + leibniz(n - 1);

        return -4.0 / (2 * n + 1) + leibniz(n - 1);

    }

    private static long piPrec(long n, double p){
        if(4.0 / (2 * n + 1) < p)
            return n;
        return piPrec(n + 1, p);
    }

    public static double pi(double p){
        return leibniz(piPrec(0, p));
    }

    public static void main(String[] args){
        System.out.println(pi(0.00001));

    }

}
