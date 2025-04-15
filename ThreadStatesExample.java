class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is in RUNNING state3.");

        try {
            // Simulating TIMED_WAITING state using sleep
            System.out.println("Thread is going to sleep...5");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted during sleep.");
        }        
        System.out.println("Thread is finishing execution (TERMINATED state).");
    }
}

public class ThreadStatesExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        // Thread in NEW state
        System.out.println("Thread state (NEW)1: " + thread.getState());
        MyThread thread2 = new MyThread();


        thread.start();
        thread2.start();

        // Thread in RUNNABLE state (ready to run)
        System.out.println("Thread state after start (RUNNABLE)2: " + thread.getState());

        try {
            // Thread.sleep(1000); // Allow time for thread to move to RUNNING and TIMED_WAITING
            System.out.println("Thread state (probably WAITING):4 " + thread.getState());
            thread.join();
            thread2.join();
            //  Thread.sleep(1200); // Wait to let the thread complete
        } catch (Exception e) {
            System.out.println(e);
        }
        // Thread in TERMINATED state after execution
        // thread.interrupt(); 
        System.out.println("Thread state (TERMINATED):6 " + thread.getState());
        System.out.println("Thread state (TERMINATED):6 " + thread2.getState());
    }
}
