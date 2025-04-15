import java.io.*;
import java.net.*;
import java.time.*;
public class Slip14AServer {
    public static void main(String[] args) {
        try {
            System.out.println("server connected");
            ServerSocket sSoc=new ServerSocket(7000);
            Socket soc=sSoc.accept();            
            PrintWriter pw= new PrintWriter(soc.getOutputStream());
            LocalDate date=LocalDate.now();
            LocalTime time=LocalTime.now();
            time.getHour();
            pw.println("the date is: "+date+" and the time is: "+time);
            pw.flush();
            sSoc.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
