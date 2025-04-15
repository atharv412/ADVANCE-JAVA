class First {
    public First(){}
    synchronized public  void f1(){
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("In Thread"+i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Method & Threadcomplete");
    }
}
class Mythread extends Thread{
    First f;
    Mythread(First ob){
        f=ob;
        start();
    }
    @Override
    public void run() 
    {
        try {f.f1();} catch (Exception e) {System.out.println(e);}
    }
}

public class ThreadSync{
    public static void main(String[] args) {
        try {
            First fob=new First();
            Mythread t1= new Mythread(fob);
            Mythread t2= new Mythread(fob);
            t1.join();
            t2.join();          
        } catch (Exception e) {
            System.out.println("");
        }
    }
}