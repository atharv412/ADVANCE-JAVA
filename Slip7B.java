import java.awt.*;
public class Slip7B extends Frame implements Runnable
{
    int x=0,x1=0;
    Thread thread;
    Slip7B()
    {
        thread=new Thread(this);
        System.out.println(thread.getState());

        thread.start();
        setSize(800,800);
        setVisible(true);
        System.out.println(thread.getState());
    }
    @Override
    public void run() {
        try {
            while (true) {
                if (x<=700) {
                    x+=10;
                    if (x>=200) {
                        x1+=5;
                        x-=4;
                    }
                    x1+=3;
                    Thread.sleep(50);
                    repaint();
                }
                else{
                    wait();
                    repaint();
                 }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, 50, 70, 50);
        g.setColor(Color.BLUE);
        g.fillRect(x1, 150, 70, 50);
    }
    public static void main(String[] args) {
        Slip7B obj= new Slip7B();
    }
}