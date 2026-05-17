package MultiThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

//    We are using anonymous class to override the Runnable interface method.
    public Runnable getRunnable() throws UnknownHostException, IOException{
//        Below return new Runnable means return object of the class that is implementing runnable interaface.
//        And yes that class is anonymous bcoz there isn't any class.
/*
To simply use anonymous class we simply return the object of the class implmeneting that interface and overrde it's
method and that class is anonymous.
We are overridng run method.
 */
        return new Runnable() {
            @Override
            public void run() {
                int port = 8010;
                try{
                    InetAddress address = InetAddress.getByName("localhost");
                    Socket socket = new Socket(address,port);
                    try{
                        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);
                        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        toSocket.println("Hello from Client " + socket.getLocalSocketAddress());
                        String line = fromSocket.readLine();
                        System.out.println("Response from Server " + line);
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();
        for(int i =0 ; i<100;i++){
            try{
                Thread thread = new Thread(client.getRunnable());
//                When we write thread.start it automatically calls run() method, and it's overrided definition is
//                called.
                thread.start();
            }catch (Exception ex){
                return;
            }
        }
    }
}
