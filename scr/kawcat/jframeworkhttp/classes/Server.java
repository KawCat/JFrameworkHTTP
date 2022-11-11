package kawcat.jframeworkhttp.classes;

import kawcat.jframeworkhttp.classes.threads.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private final int port;
    private ServerSocket socket;

    /**
     * Server constructor using default HTTP port (80)
     */
    public Server(){
        this.port = 80;
    }

    /**
     * Server constructor
     * @param port Port to use to listen for HTTP requests
     */
    public Server(final int port){
        this.port = port;
    }

    /**
     * Method to start listening for HTTP requests
     */
    public void listen(){
        try{
            socket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
            while(true){
                new ClientThread(socket.accept()).start();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }


}
