public class Quersumme {

    public static int quersummeIt(int zahl){
        int sum = 0;
        while (zahl != 0){
            sum += zahl % 10;
            zahl /= 10;
        }
        return sum;
    }

    public static int quersummeRec(int zahl){
        if(zahl == 0)
            return 0;
        return (zahl % 10) + quersummeRec(zahl / 10);
    }

    public static int fib(int a){
        if(a == 0)
            return 0;
        if(a == 1)
            return 1;
        return fib(a - 2) + fib(a - 1);
    }

    public static int fac(int a){
        if(a == 0)
            return 0;
        return a * fac(a - 1);
    }

    public static void main(String[] args){
        System.out.print(quersummeIt(12345) != 15 ? "Error iter\n" : "");
        System.out.print(quersummeRec(12345) != 15 ? "Error rec\n" : "");

    }

}
