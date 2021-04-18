import org.apache.commons.net.bsd.RLoginClient;

import java.net.InetAddress;

public class Main {



    public static void main(String[] args){
        try {
            System.out.println("hello");
            RLoginClient rClient = new RLoginClient();
            //rClient.rlogin("nikita","server","csh");
            rClient.connect(InetAddress.getLocalHost(),513);
            System.out.println("connected");


        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
