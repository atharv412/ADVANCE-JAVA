 class chkVowels extends Thread {
    chkVowels(String s)
    {
        start();
        String temp=s;
        run();
        {
            try {
                for (int i = 0; i < temp.length(); i++) {
                    if (
                    temp.charAt(i)=='a'||
                    temp.charAt(i)=='e'||
                    temp.charAt(i)=='i'||
                    temp.charAt(i)=='o'||
                    temp.charAt(i)=='u') {
                        System.out.println("vowel is at: "+i+"Vowel is"+temp.charAt(i));
                        Thread.sleep(500);
                    }
                }
                System.out.println("END OF THREAD");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
public class Slip2A {
    public static void main(String[] args) {
        try {
            String s=args[0];
            chkVowels ob= new chkVowels(s);
            ob.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
