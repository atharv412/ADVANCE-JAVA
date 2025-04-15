import java.awt.*;
import java.awt.event.*;
public class Slip12A extends Frame implements Runnable,ActionListener{
        TextField tf;
        Button b1,b2;
        Thread t1;
        int i;
        Slip12A()
        {
            tf=new TextField(20);
            b1=new Button("Start");
            b2=new Button("Stop");
            t1=new Thread(this);
            i=1;
            Font f= new Font("Arial",Font.BOLD,20);
            add(tf);add(b1);add(b2);
            setSize(500,500);
            setFont(f);
            setVisible(true);
            setLayout(new GridLayout(3,1));
            b1.addActionListener(this);
            b2.addActionListener(this);
        }
        public void actionPerformed(ActionEvent e)
        {
            try {
                if (e.getSource()==b1) {
                    if (!t1.isAlive()||t1==null) {
                        t1=new Thread(this);
                        t1.start();
                    }
                }
                else if(e.getSource()==b2){
                    if (t1.isAlive() && t1!=null) {
                        t1.interrupt();
                     
                    } 
                }
            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
        @Override
        public void run() {
        try {
            for(;i<100;i++)
            {
                tf.setText(i+"");
                Thread.sleep(100);
                if (t1.isInterrupted()) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);    
        }
    }

    public static void main(String[] args) {
        try {
            new Slip12A();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
