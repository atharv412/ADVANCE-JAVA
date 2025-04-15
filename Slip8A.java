import java.awt.*;
public class Slip8A extends Frame implements Runnable{
    Thread t;
    Label l1;
    Slip8A(){
        t=new Thread(this);
        t.start();
        l1=new Label();
        add(l1);
        setVisible(true);
        setSize(300,300);
        setLayout(new FlowLayout());
        Font f= new Font("Arial",Font.BOLD,25);
        l1.setFont(f);
    }
    @Override
    public void run() {
        try {
            while (true) {
                l1.setText("WELCOME");
                Thread.sleep(500);
                l1.setText("");
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        try {
            new Slip8A();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
