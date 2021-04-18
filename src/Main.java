import org.apache.commons.net.bsd.RLoginClient;

import java.io.*;
import java.net.InetAddress;

public class Main {



    public static void main(String[] args){
        try {
            System.out.println("hello");
            RLoginClient rClient = new RLoginClient();

            rClient.connect(InetAddress.getByName("192.168.0.10"),513);
            System.out.println("rlogin connected");
            rClient.rlogin("USER","i5","vt100");
            System.out.println("fuck");

            InputStream sin  = rClient.getInputStream();
            OutputStream sout = rClient.getOutputStream();

            DataInputStream in ;
            DataOutputStream out;
            in  = new DataInputStream (sin );
            out = new DataOutputStream(sout);

            InputStreamReader isr;
            isr = new InputStreamReader(System.in);
            BufferedReader keyboard;
            keyboard = new BufferedReader(isr);
            String line = null;
            System.out.println("Type in something and press enter");
            System.out.println();
            while (true) {
                // Пользователь должен ввести строку
                // и нажать Enter
                line = keyboard.readLine();
                // Отсылаем строку серверу
                out.writeUTF(line);
                // Завершаем поток
                out.flush();
                // Ждем ответа от сервера
                line = in.readUTF();
                if (line.endsWith("quit"))
                    break;
                else {
                    System.out.println(
                            "The server sent me this line :\n\t"
                                    + line);
                }
            }



        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
