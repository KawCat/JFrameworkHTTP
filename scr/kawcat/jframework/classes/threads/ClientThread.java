package kawcat.jframework.classes.threads;

import kawcat.jframework.classes.Router;
import kawcat.jframework.classes.objects.Request;
import kawcat.jframework.classes.objects.Response;
import kawcat.jframework.classes.objects.RouteEntry;
import kawcat.jframework.enums.Methods;
import kawcat.jframework.enums.StatusCodes;
import kawcat.jframework.interfaces.RequestHandler;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientThread extends Thread {
    private final Socket SOCKET;
    private final String ADDRESS;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedOutputStream bytesOut;

    public ClientThread(final Socket SOCKET){
        this.SOCKET = SOCKET;
        try{
            in = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));
            out = new PrintWriter(SOCKET.getOutputStream(), true);
            bytesOut = new BufferedOutputStream(SOCKET.getOutputStream());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        ADDRESS = SOCKET.getInetAddress().getHostAddress();
    }

    @Override
    public void run(){
        Request request = read();
        if(request != null){
            RouteEntry route = Router.get(request.getMethod(), request.getURI());
            if(route != null){
                RequestHandler handler = route.getHandler();
                Response response = handler.handle(request);
                if(response == null){
                    Router.unregister(handler);
                }else{
                    respond(response);
                }
            }else{
                respond(new Response(request.getVersion(), StatusCodes.NOT_FOUND, "<!DOCTYPE html><html><head><title>404 Not Found</title></head><body><center><h1>404 Page Not Found</h1><hr><p>JFramework</p></center></body></html>".getBytes()));
            }
        }
        close();
    }

    private void close() {
        try{
            in.close();
            out.close();
            SOCKET.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        this.interrupt();
    }

    private void respond(Response response){
        String header = "HTTP/" + response.getVersion() + " " + response.getStatusCode().getIntByEnum() + " " + response.getStatusCode().toString();
        out.println(header);
        out.println("Server: JFramework/1.0.0");
        out.println("Date: " + new Date());
        out.println();
        out.flush();
        try{
            bytesOut.write(response.getContent());
            bytesOut.flush();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    private Request read(){String raw = readRaw();
        if(raw == null) return null;
        String[] inSplitted = raw.split(" ");
        String URI = inSplitted[1];
        if(URI.length() > 1 && URI.endsWith("/")) URI =  URI.substring(0, URI.length() - 1);

        return new Request(Methods.valueOf(inSplitted[0]), URI, inSplitted[2].split("/")[1]);
    }

    private String readRaw(){
        try{
            return in.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }
}
