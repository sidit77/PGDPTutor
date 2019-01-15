import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter extends Thread {
    private long target[]; // used as reference on value
    private long amount; // how many times shall we count

    private Lock lock;

    Counter(long target[], long amount, Lock lock) {
        this.target = target;
        this.amount = amount;
        this.lock = lock;
    }

    public void run() {
        for (long c = 0; c < amount; c++) {

            //lock.lock();

            synchronized (target) {

                long tmp = target[0];
                tmp = tmp + 1;
                target[0] = tmp;

            }
            //lock.unlock();
            // prints id of current thread (makes things slow, so maybe use with smaller amount) :
            // System.out.println(this.getId());

            // equivalent to target[0]++;
        }
    }
}


public class Race {

    public static void main(String args[]) throws InterruptedException {

        long value[] = {0};
        long inc = 100000000; // must be big enough!

        Lock lock = new ReentrantLock();

        Counter c1 = new Counter(value, inc, lock);
        Counter c2 = new Counter(value, inc, lock); // same value!

        /*
         * //alternative version: c1.start(); c1.join();
         *
         * c2.start(); c2.join();
         */

        c1.start();
        c2.start();

        c1.join();
        c2.join();


        System.out.println("counter: expected " + 2 * inc + " got " + value[0]);
    }
}

