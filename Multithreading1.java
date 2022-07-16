public class Multithreading1 {
    int count =1;
    public static void main(String[] args){
       /* System.out.println("Hello");
        ExecutorService es = Executors.newFixedThreadPool(2);

        Multithreading1 mt=new Multithreading1();
        Thread t1=new Thread(){
            @Override
            public void run() {
                mt.printOddNumbers();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                mt.printEvenNumbers();
            }
        };

        es.submit(t1);
        es.submit(t2);

        //es.shutdownNow();
        */


    }

    void printEvenNumbers(){
        synchronized (this) {
            while (count < 50) {
                while (count % 2 == 1) {
                    try {
                        wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName()+"::" +count++);
                notifyAll();
            }
        }
    }
    void printOddNumbers(){
        synchronized (this) {
            while (count < 50) {
                while (count % 2 == 0) {
                    try {
                        wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName()+"::" +count++);
                notifyAll();
            }
        }
    }



}

