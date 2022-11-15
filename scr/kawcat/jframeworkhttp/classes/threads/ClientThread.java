package kawcat.jframeworkhttp.classes.threads;

import kawcat.jframeworkhttp.classes.Router;
import kawcat.jframeworkhttp.classes.Server;
import kawcat.jframeworkhttp.classes.objects.Request;
import kawcat.jframeworkhttp.classes.objects.Response;
import kawcat.jframeworkhttp.classes.objects.RouteEntry;
import kawcat.jframeworkhttp.enums.Methods;
import kawcat.jframeworkhttp.enums.StatusCodes;
import kawcat.jframeworkhttp.interfaces.RequestHandler;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ClientThread extends Thread {
    private final Server server;
    private final Socket socket;
    private final String address;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedOutputStream bytesOut;
    private BufferedInputStream bytesIn;
    private Response page;
    private final String CRLF = "\r\n";

    public ClientThread(final Server server, final Socket socket){
        this.server = server;
        this.socket = socket;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            bytesOut = new BufferedOutputStream(socket.getOutputStream());
            bytesIn = new BufferedInputStream(socket.getInputStream());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        address = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run(){
        Request request = read();

        if(request != null){
            System.out.println(request.getMethod() + " " + request.getURI());
            File pageFile = new File("kawcat/jframeworkhttp/others/page.html");

            if(!request.getVersion().equals("1.1")){
                String pageHTML = null;
                try{
                    pageHTML = Files.readString(pageFile.toPath());
                    pageHTML = pageHTML.replace("{code}", Integer.toString(StatusCodes.HTTP_VERSION_NOT_SUPPORTED.getIntByEnum()));
                    pageHTML = pageHTML.replace("{status}", StatusCodes.HTTP_VERSION_NOT_SUPPORTED.toString());
                    pageHTML = pageHTML.replace("{server}", server.getServerName());
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
                page = new Response(StatusCodes.HTTP_VERSION_NOT_SUPPORTED, pageHTML.getBytes());
                respond(page);
            }else{
                String pageHTML = null;
                try{
                    pageHTML = Files.readString(pageFile.toPath());
                    pageHTML = pageHTML.replace("{code}", Integer.toString(StatusCodes.NOT_FOUND.getIntByEnum()));
                    pageHTML = pageHTML.replace("{status}", StatusCodes.NOT_FOUND.toString());
                    pageHTML = pageHTML.replace("{server}", server.getServerName());
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
                page = new Response(StatusCodes.NOT_FOUND, pageHTML.getBytes());
                RouteEntry route = Router.get(request.getMethod(), request.getURI());
                if(route != null){
                    RequestHandler handler = route.getHandler();
                    File file = route.getFile();
                    Response response = null;
                    if(handler != null){
                        response = handler.handle(request);
                    }else if(file != null){
                        Path filePath = file.toPath();

                        try{
                            response = new Response(StatusCodes.OK, Files.readAllBytes(filePath));
                            response.addHeader("Content-Type", Files.probeContentType(filePath));
                        }catch(IOException ioe){
                            ioe.printStackTrace();
                        }
                    }
                    if(response == null){
                        Router.unregister(handler);
                        respond(page);
                    }else{
                        respond(response);
                    }
                }else{
                    respond(page);
                }
            }
        }
        close();
    }

    private void close() {
        try{
            in.close();
            out.close();
            bytesIn.close();
            bytesOut.close();
            socket.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        this.interrupt();
    }

    private void respond(Response response){
        String header = "HTTP/1.1 " + response.getStatusCode().getIntByEnum() + " " + response.getStatusCode();
        out.print(header + CRLF);
        response.addHeader("Connection", "close");
        response.addHeader("Date", new Date().toString());
        response.addHeader("Content-Length", Integer.toString(response.getContent().length));
        response.addHeader("Server", server.getServerName());
        out.print(response.getHeaders());
        out.print(CRLF);
        out.flush();
        try{
            bytesOut.write(response.getContent());
            bytesOut.flush();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println(response.getStatusCode().getIntByEnum() + " " + response.getStatusCode());
    }

    private Request read(){
        String raw = readRaw();
        if(raw == null) return null;
        String[] rows = raw.split(CRLF);

        String[] request = rows[0].split(" ");
        String URI = request[1];
        if(URI.length() > 1 && URI.endsWith("/")) URI =  URI.substring(0, URI.length() - 1);

        Map<String, String> headers = new HashMap<>();
        for(int i = 1; i < rows.length; i++){
            String[] header = rows[i].split(":");
            headers.put(header[0].trim(), header[1].trim());
        }

        return new Request(Methods.valueOf(request[0]), URLDecoder.decode(URI, StandardCharsets.UTF_8), request[2].split("/")[1], headers);
    }

    private String readRaw(){
        try{
            String request = "";
            String line;
            while(!(line = in.readLine()).equals("")){
                request += line + CRLF;
            }
            return request;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }
}
