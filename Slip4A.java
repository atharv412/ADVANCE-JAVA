class  HelloThread implements Runnable{

    Thread t;
    int cnt;
    HelloThread(int nn)
    {
        t=new Thread(this);
        t.start();
        cnt=nn;
    }
    public void run()
    {
        try {
            for (int i = 1; i <=cnt; i++) {
                System.out.println(i+"Hello");
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class Slip4A {
public static void main(String[] args) {
    try {
        int n=Integer.parseInt(args[0]);
        HelloThread ob=new HelloThread(n);
        ob.t.join();
    } catch (Exception e) {
        System.out.println(e);
    }
    }
}
