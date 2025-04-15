import java.awt.*;

public class Slip5B extends  Frame implements  Runnable{
    int x=0;
    Thread t1;
    public Slip5B() {
        t1= new  Thread(this);
        t1.start();
        setSize(500,500);
        setVisible(true);
    }
    @Override
    public void run() {
        try {
            while (x<=380) { 
                x+=10;
                Thread.sleep(60);
                repaint();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, 50, 100, 100);
    }
    public static void main(String[] args) {
        new Slip5B();
    }
}