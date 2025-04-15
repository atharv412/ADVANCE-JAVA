import java.io.*;
import java.net.*;
public class Slip14AClient {
    public static void main(String[] args) {
        try {
            System.out.println("client connected");
            Socket soc=new Socket("localhost",7000);
            BufferedReader buf= new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println("Date and time and time recivied from server ");
            System.out.println(buf.readLine());
            soc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
