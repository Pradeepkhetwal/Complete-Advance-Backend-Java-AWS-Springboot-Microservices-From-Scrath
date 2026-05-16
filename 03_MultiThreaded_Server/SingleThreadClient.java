import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SingleThreadClient {

    public static void run() throws IOException{
        int port = 8010;
//        To connect to server we need ip address of the server so we can make a req to it.
//        So using InetAddress class we can get the ip.
//        We are running code on localhost so we use below .getByName method and pass localhost to it to fetch it's ip.
        InetAddress address = InetAddress.getByName("localhost");
//Creating a socket , here client initiates to form a connection with the server.
        Socket socket = new Socket(address,port);

//        Below socket.getOutputStream return outputstream object which is used for below.
//        “Give me the pipe through which I can send data
//        Through outputstream we can  send data but it cannot directly send string it sends bytes only.
//        We need to manually use .getBytes() method to  convert string to bytes , so we simply use Printwriter class.
//        Java prvovides a wrapper class PrintWriter that is used to directly convert string to byte.
/*
      Below true is used for auto flush . Because what happens is when client sends data normally it is stored in
      buffer(memory) first instead of directly going to the server. So if we use this autoflus this buffer storage
      part is skipped and data is directly sent to the server. If we don't use autoflush then Data may stay stuck in memory buffer and not actually reach the other side immediately
 */
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);
//This inputstreamreader class is used to convert bytes to stream bcoz from server data is coming into the forms of
// bytes.
        /*
        .getInputStream() is used to get access to channel which contains data coming from server to client.
        We use BufferedReader class so that we can read the string which we just converted properly as it provide us
        with readLine() method without it , it is difficult to read the data.
         */
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

//        now with the help of tosocket object we can send data to server.  We are also sending client socket address.
        toSocket.println("Hello World from Socket " + socket.getLocalSocketAddress());

//        RECEIVES data from server.
        String line = fromSocket.readLine();
        System.out.println(line);
//        I'm done sending data close the sending channel.
        toSocket.close();
//        I'm done receiving data close the receiving channel.
        fromSocket.close();
//        Cut the call.
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
