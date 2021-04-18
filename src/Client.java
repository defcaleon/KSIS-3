import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client implements  AutoCloseable {

    private Socket client;

    public Client(){
        client = new Socket();

    }
    public  void  setIp() throws  Exception{
        InetAddress inetAddress=InetAddress.getByName("localhost");
        SocketAddress socketAddress=new InetSocketAddress(inetAddress,0);
        client.bind(socketAddress);
    }

    @Override
    public void close() throws IOException{
        client.close();
    }


}
