import java.io.*;
import java.net.*;
import java.util.*;
public class Slip13BClient {
    public static void main(String[] args) {
        try {   
            System.out.println("Client running  ");
            Socket soc= new Socket("localhost",7000);
            PrintWriter pw=new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
            BufferedReader buf= new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String msg;
            do{
                System.out.println("Enter the text");
                   
                    Scanner sc=new Scanner(System.in);
                    msg=sc.nextLine();
                    if (msg==null) {
                        break;
                    }
                    else{
                    
                        pw.println(msg);
                        pw.flush();
                    }
                    String ans=new String();
                    ans=buf.readLine();
                    ans=ans.trim();
                    System.out.println("server msg: "+ans);
            }while(msg!=null);
            soc.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
