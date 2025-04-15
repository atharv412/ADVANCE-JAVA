import java.io.*;
import java.net.*;
import java.util.*;
public class Slip13BServer {
    public static void main(String[] args) {
        try {
            System.out.println("server running  ");
            
            ServerSocket servsoc=new ServerSocket(7000);
            Socket soc=servsoc.accept();
            
            BufferedReader buf=new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter pw=new PrintWriter(soc.getOutputStream());
            String ans;
            while (true) {
                String mString=new String();
                mString=buf.readLine();
                if (mString.equalsIgnoreCase("end")) {
                    break;
                }
                else{
                    System.out.println(soc.getInetAddress()+":"+mString);
                    System.out.println("Enter the text");
                    Scanner sc=new Scanner(System.in);
                    ans=sc.nextLine();
                    pw.println(ans);
                    pw.flush();
                }
            }
            servsoc.close();
            soc.close();
            buf.close();
            pw.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
