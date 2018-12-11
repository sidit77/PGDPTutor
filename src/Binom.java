public class Binom {

    public static long binom(int n, int k){
        if(n == k || k == 0)
            return 1;
        return binom(n - 1, k - 1) + binom(n - 1, k);
    }

    public static void main(String[] args){
        System.out.print(1.0 / binom(49, 6));

    }

}
