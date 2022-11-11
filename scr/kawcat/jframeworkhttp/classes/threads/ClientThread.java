package kawcat.jframeworkhttp.classes.threads;

import kawcat.jframeworkhttp.classes.Router;
import kawcat.jframeworkhttp.classes.objects.Request;
import kawcat.jframeworkhttp.classes.objects.Response;
import kawcat.jframeworkhttp.classes.objects.RouteEntry;
import kawcat.jframeworkhttp.enums.Methods;
import kawcat.jframeworkhttp.enums.StatusCodes;
import kawcat.jframeworkhttp.interfaces.RequestHandler;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientThread extends Thread {
    private final Socket socket;
    private final String address;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedOutputStream bytesOut;
    private Response notFound;

    public ClientThread(final Socket socket){
        this.socket = socket;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            bytesOut = new BufferedOutputStream(socket.getOutputStream());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        address = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run(){
        Request request = read();
        notFound = new Response(request.getVersion(), StatusCodes.NOT_FOUND, "<!DOCTYPE html><html><head><title>404 Not Found</title></head><body><center><h1>404 Page Not Found</h1><hr><p>JFramework</p></center></body></html>".getBytes());

        if(request != null){
            RouteEntry route = Router.get(request.getMethod(), request.getURI());
            if(route != null){
                RequestHandler handler = route.getHandler();
                Response response = handler.handle(request);
                if(response == null){
                    Router.unregister(handler);
                    respond(notFound);
                }else{
                    respond(response);
                }
            }else{
                respond(notFound);
            }
        }
        close();
    }

    private void close() {
        try{
            in.close();
            out.close();
            socket.close();
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

    private Request read(){
        String raw = readRaw();
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
