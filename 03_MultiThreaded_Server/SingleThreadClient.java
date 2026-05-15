import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SingleThreadClient {

    public static void run() throws IOException{
        int port = 8090;
//        To connect to server we need ip address of the server so we can make a req to it.
//        So using InetAddress class we can get the ip.
//        We are running code on localhost so we use below .getByName method and pass localhost to it to fetch it's ip.
        InetAddress address = InetAddress.getByName("localhost");
//Creating a socket , here client initiates to form a connection with the server.
        Socket socket = new Socket(address,port);

        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello World from Socket " + socket.getLocalSocketAddress());
        String line = fromSocket.readLine();
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    public static void main(String[] args) {

        try{
          run();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
