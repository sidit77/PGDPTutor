package kartoffel;

import java.util.Random;

public class Program {

    public static void main(String[] args) throws Exception{
        Graph graph = new PinguGraph(10);

        for(int i = 0; i < 10; i++)
            ((PinguGraph) graph).add(new Node());

        Random r = new Random();
        for(int i = 0; i < 20; i++){
            ((PinguGraph) graph).add(r.nextInt(10), r.nextInt(10));
        }

        Kartoffeluin kp1 = new Kartoffeluin(graph, 1, 30);
        Kartoffeluin kp2 = new Kartoffeluin(graph, 3, 20);
        Kartoffeluin kp3 = new Kartoffeluin(graph, 5, 50);
        Kartoffeluin kp4 = new Kartoffeluin(graph, 9, 14);

        kp1.start();
        kp2.start();
        kp3.start();
        kp4.start();


        kp1.join();
        kp2.join();
        kp3.join();
        kp4.join();

    }

}
