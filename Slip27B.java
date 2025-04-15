import  java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;

public class  Slip27B extends  Frame implements ActionListener,Runnable{
    boolean running=false;
    Button start,stop;
    TextField tfField;
    Thread thread;
    int h,m,s;
    Slip27B(){
        start=new Button("Start");
        stop=new Button("Stop");
        tfField=new TextField(20);
        thread=new Thread(this);
        thread.start();
        h=0;m=0;s=0;
        add(tfField);
        add(start);
        add(stop);
        Font f= new Font ("Arial",Font.BOLD,30);
        setFont(f);
        setSize(500,500);
        setLayout(new GridLayout(3,1));
        start.addActionListener(this);
        stop.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==start) {
            try {
                running=true;
                thread=new  Thread(this);
                thread.start();
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
        else{
            running=false;
        }
    }
    @Override
    public void run() {
        try {
            while (running) { 
                LocalTime time=LocalTime.now();
                h=time.getHour();
                m=time.getMinute();
                s=time.getSecond();
                tfField.setText(h+":"+m+":"+s);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Slip27B();
    }
}