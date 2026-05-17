package MultiThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;


public class MultiThreadServer {

//Consumer is a built in interface in java Consumer<T> accept any type T.
//    Again this interface also has only one method  and that method name is accept().
//    In this code we are using 2 lambdas one is below and other is at Thread constructor to overrdie run method.
//  Below method getConsumer returns a lambda of type Consumer<Socket> which means Consumer<Socket> object.
//    With consumer interface we are more focusing on clear code by using a seperate method we can do same work by
//    ovverriding the runnable interface method but we choose consumer interface for better design choice.
    public static Consumer<Socket> getConsumer(){
        return (clientSocket)->{
            try{
                PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(),true);
/*                The getInetAddress() method in Java is  used to retrieve the IP address to which a socket is
                connected(client). */
                toSocket.println("hello from Server " + clientSocket.getInetAddress());
                BufferedReader fromClient =
                        new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream())
                        );

                String message = fromClient.readLine();
                System.out.println(message);
            }catch(IOException e){
                e.printStackTrace();
            }
        };
    }
    public static void main(String[] args) {
        int port = 8010;

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server listening to the port " + port);

            serverSocket.setSoTimeout(10000);
            while (true) {
//                Wait for a client to connect to the server, then create a socket for communication with that client
/*                We have settimeout for 10sec so if client doesn't connect ,after 10sec exception will be thrown and
              loop will break

 */
                Socket clientSocket = serverSocket.accept();
//Means Create a new thread that will execute this code:
//                Using new Thread we create a new thread but thread is bydefault in sleeping state not in running
//   We pass the work inside new Thread(here) that need to be done by that thread.
//We are passing a lambda Expression inside this thread.
                /*

                 */
//                Whatever task thread need to execute we need to define it by overriding method of Runnable Interface
//                Inside this Thread() constructor a Runnable type is expected.

                Thread thread = new Thread(()->getConsumer().accept(clientSocket));
                thread.start();

            }

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
