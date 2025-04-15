import java.io.*;
import java.net.*;

public class Slip6BServer {
    public static void main(String[] args) {
        try {
            System.out.println("Server is running ");

            ServerSocket serverSocket=new ServerSocket(7000);
            Socket soc=serverSocket.accept();

            BufferedReader buf=new BufferedReader
            (new InputStreamReader
            (soc.getInputStream()));
            
            while (true) {
                String reString=buf.readLine();
                System.out.println("File name recevied from client is "+reString);
                FileInputStream fin=new FileInputStream(reString+".txt");
                int data=0;
                while ((data=fin.read())!=-1) 
                {
                    System.out.print((char)data+" ");    
                }
                fin.close();
                serverSocket.close();
                buf.close();
                soc.close();
            }

        } catch (Exception e) {
            e.getStackTrace();
        }        
    }
}
