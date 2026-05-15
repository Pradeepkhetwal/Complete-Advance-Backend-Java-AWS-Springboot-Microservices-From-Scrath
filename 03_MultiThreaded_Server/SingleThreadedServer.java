import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServer {
    public static void run() throws IOException {
//        To create a server we first need to create a port , to which the server will listen for client req.
//        We create server using ServerSocket class we pass port in it and a server object is created.
//        This server object listens to the port specified. (to be precise it is a Serversocket object.
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
//       Below means the server will wait for 10sec(we have millisec below) and if req will not come from client the
//       server will throw exception and will not be in always waiting state.
        socket.setSoTimeout(10000);


        while(true) {
            try {
                System.out.println("Server is listening to the port " + port);
//                This accept method returns a socket object (simply socket which is created) so it waits for an
//                client and accept the connection create a socket .
                Socket acceptedConnection = socket.accept();
                System.out.println("Connection established " + acceptedConnection.getRemoteSocketAddress());
//
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());

//                acceptedConnection.getInputstream() means “Give me the stream of data coming FROM the client.”
                /*
                1. InputStreamReader-: It converts bytes → characters.Computer/network/file data usually comes as raw bytes.
                2.BufferedReader is used to read text efficiently and conveniently.Advantages are:
                                    1.faster reading using a buffer
                                    2.easy line-by-line reading with readLine
                 */

//                We can fetch the data from the fromclient using .readLine() method (this data is coming from client).
                BufferedReader fromClient =
                        new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

//                Sending the below text from server to client.
                toClient.println("Hello from the server");

//                Client stops speaking.
                toClient.close();
//                Client stops listening.

                fromClient.close();
//                The call (or connection) is closed now.
                acceptedConnection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){

        try{
            run();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
