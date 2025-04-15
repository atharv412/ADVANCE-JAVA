import java.awt.*;
import java.util.Random;
public class Slip10B extends Frame implements Runnable{
    int y=0,red=0,green=0,blue=0;
    Random tRandom;
    Color randomColor;
    Thread t;
    Slip10B(){
        tRandom = new Random();
        t=new Thread(this);
        // System.out.println(t.getState());//
        t.start();
        setSize(500,500);
        setVisible(true);
    }
    @Override
    public void run() {
        try {
            while (true) {
                if (y<=430) {
                    y+=10;
                }
                if(y==430)
                {
                    red = tRandom.nextInt(256);   
                    blue = tRandom.nextInt(256);  
                    green = tRandom.nextInt(256); 
                    randomColor = new Color(red, green, blue);
                    while(y!=50){
                        y-=10;
                        Thread.sleep(50);
                        repaint();
                    }
                }
                Thread.sleep(50);
                repaint();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(randomColor);
        g.fillOval(50, y, 70, 70);
    }
    public static void main(String[] args) {
        new Slip10B();
    }
}  