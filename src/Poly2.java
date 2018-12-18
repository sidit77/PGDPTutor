public class Poly2 {

    static class A {
        public void f(A a){
            System.out.println("A.f(A)");
        }
        public void f(B b){
            System.out.println("A.f(B)");
        }
        public static void A(){
            System.out.println("A");
        }
    }

    static class B extends A {
        public void f(A a){
            System.out.println("B.f(A)");
        }
        public static void A(){
            System.out.println("B");
        }
    }

    static class C extends B {
        public void f(A a){
            System.out.println("C.f(A)");
        }
        //public void f(B b){
        //    System.out.println("C.f(B)");
        //}
        public void fc(){
            System.out.println("C.fc()");
        }
    }

    public static void main(String[] arg){
        A a = new A();
        B b = new B();
        C c = new C();
        B d = new C();
        A e = c;

        d.f(e);
        a.f(a);
        a = new B();
        a.A();
    }

}
