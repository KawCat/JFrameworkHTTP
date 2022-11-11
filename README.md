# JFrameworkHTTP
## Usage

Main.java
````java
import kawcat.jframeworkhttp.classes.Server;
import kawcat.jframeworkhttp.classes.Router;
import kawcat.jframeworkhttp.enums.Methods;

public class Main{
    public static void main(String[] args){
        // If no port is given to the constructor the default port will be 80
        Server server = new Server();
        
        // First we need to tell which HTTP method we want to serve
        // Second we establish which URI we're going to serve
        // And finally the class implementing the 'RequestHandler' interface
        Router.register(Methods.GET, "/", new Index());
        
        // When we have all set we can start listening for connections
        server.listen();
    }
}
````
---
Index.java
````java
import kawcat.jframeworkhttp.interfaces.RequestHandler;
import kawcat.jframeworkhttp.classes.objects.Response;
import kawcat.jframeworkhttp.classes.objects.Request;
import kawcat.jframeworkhttp.enums.StatusCodes;

public class Index implements RequestHandler{
    @Override
    public Response handle(Request req){
        // Basic HTML, usually this would be from a file
        String html = "Hello world!";

        // The response HTTP version is the same as the request HTTP version
        // This respond is marked with the HTTP status code "200 OK"
        // If we want to input this argument with an integer value you can use
        //StatusCodes.getEnumByInt(200)
        // And finally we convert the HTML into bytes
        Response res = new Response(req.getVersion(), StatusCodes.OK, html.getBytes());
        
        // If the return value is false the framework will automatically unregister
        // this class and send the default 404 Not Found page & status code
        return res;
    }
}
````