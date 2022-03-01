package MultiThreading;


class EvenOddHelper {
    static int LIMIT = 20;
    int i = 1;

    synchronized void even() {
        while (i <= LIMIT) {
            if (i % 2 == 0) {
                System.out.println("Even: " + i);
                i++;

                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

            }

        }
    }

    synchronized void odd() {

        while (i <= LIMIT) {
            if (i % 2 != 0) {
                System.out.println("Odd: " + i);
                i++;
                notifyAll();
            } else
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

        }
    }
}

public class Evenodd {
    public static void main(String[] args) {
        

        final EvenOddHelper evenOdd = new EvenOddHelper();
        Thread t1=new Thread() {
            public void run() {
                evenOdd.even();
            }
        };
        
        Thread t2=new Thread() {
            public void run() {
                evenOdd.odd();
            }
        };
        long startTime = System.nanoTime();
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){

        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

    }
}

