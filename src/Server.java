import java.io.*;
import java.net.*;

public class Server extends Thread {

    private Socket server = null;
    private final int PORT = 513;

    private String TEMPL_MSG =
            "The client '%d' sent me message : \n\t";
    private String TEMPL_CONN =
            "The client '%d' closed the connection";


    public Server() throws IOException {
        InetAddress ia;
        ia = InetAddress.getByName("192.168.0.10");
        ServerSocket temp = new ServerSocket(PORT, 0, ia);


        System.out.println("Server started\n\n");

        server = temp.accept();
        System.out.println("+++++ connection +++++");
        start();

    }

    public void run() {
        try {
            // Определяем входной и выходной потоки сокета
            // для обмена данными с клиентом
            InputStream sin = server.getInputStream();
            OutputStream sout = server.getOutputStream();

            DataInputStream dis = new DataInputStream(sin);
            DataOutputStream dos = new DataOutputStream(sout);

            String line = null;
            while (true) {
                // Ожидание сообщения от клиента
                line = dis.readUTF();
                System.out.println(
                        TEMPL_MSG + line);
                System.out.println("I'm sending it back...");
                // Отсылаем клиенту обратно эту самую
                // строку текста
                dos.writeUTF("xuy" + line);
                // Завершаем передачу данных
                dos.flush();
                System.out.println();
                if (line.equalsIgnoreCase("quit")) {
                    // завершаем соединение
                    server.close();
                    System.out.println(TEMPL_CONN);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }

    public int getPort() {
        return PORT;
    }

    public void setIP() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        SocketAddress IPAddress = new InetSocketAddress(inetAddress, PORT);
        server.bind(IPAddress);
    }


    public void close() throws IOException {
        server.close();
    }

    public String getStringIP() {
        return server.getInetAddress().toString();
    }

}



