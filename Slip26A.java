class display extends Thread{
    display(){
        start();
    }
    public void run (){
        try{
            for(char ch = 'A';ch<='Z';ch++){
                System.out.print("\t "+ch);
                Thread.sleep(3000);
            }
        }catch(Exception e){} 
    }
}
public class Slip26A {
    public static void main(String[] args) throws Exception {
        display ob = new display();
        ob.join();
    }
}
