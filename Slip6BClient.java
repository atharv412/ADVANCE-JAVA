import java.io.*;
import java.net.*;
import java.util.*;
public class Slip6BClient {
    public static void main(String[] args) {
        try {
            System.out.println("client running");
            Socket soc=new Socket("localhost",7000);
            PrintWriter pWriter=new PrintWriter(soc.getOutputStream());
            Scanner svScanner=new Scanner(System.in);
            System.out.println("Enter the file to search on server");
            String msg;
        
                msg=svScanner.nextLine();
                if (msg==null) {
                    System.out.println("user entered noting");
                }
                else{
                    pWriter.println(msg);
                    pWriter.flush();
                }
            System.out.println("closing client");
            soc.close();
            pWriter.close();
            svScanner.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
