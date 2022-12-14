package kawcat.jframeworkhttp.classes;

import kawcat.jframeworkhttp.classes.objects.RouteEntry;
import kawcat.jframeworkhttp.enums.Methods;
import kawcat.jframeworkhttp.interfaces.RequestHandler;

import java.io.File;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Router {
    private static final Set<RouteEntry> routes = new CopyOnWriteArraySet<>();

    /**
     * Register a class implementing `kawcat.jframework.interfaces.RequestHandler` for later on be called as a request comes in
     * @param method `kawcat.jframework.enums.Methods` HTTP method
     * @param URI `java.lang.String` HTTP URI
     * @param handler `kawcat.jframework.interfaces.RequestHandler` Class implementing the interface
     * @return `boolean` if it was registered or not
     */
    public static boolean register(Methods method, String URI, RequestHandler handler){
        return routes.add(new RouteEntry(method, URI, handler));
    }

    public static boolean register(Methods method, String URI, File file){
        return routes.add(new RouteEntry(method, URI, file));
    }

    /**
     * Unregister a class implementing `kawcat.jframework.interfaces.RequestHandler`
     * @param handler `kawcat.jframework.interfaces.RequestHandler` Class implementing the interface
     * @return `boolean` if it was unregistered or not
     */
    public static boolean unregister(RequestHandler handler){
        RouteEntry[] entries = routes.toArray(new RouteEntry[routes.size()]);
        for(RouteEntry entry : entries){
            if(entry.getHandler().equals(handler)){
                return routes.remove(entry);
            }
        }
        return false;
    }

    public static boolean unregister(File file){
        RouteEntry[] entries = routes.toArray(new RouteEntry[routes.size()]);
        for(RouteEntry entry : entries){
            if(entry.getFile().equals(file)){
                return routes.remove(entry);
            }
        }
        return false;
    }

    /**
     * Get the entry of a route looking up by its method and path
     * @param method `kawcat.jframework.enums.Methods` HTTP method
     * @param path `java.lang.String` HTTP URI
     * @return Class implementing `kawcat.jframework.interfaces.RequestHandler` handling requests for the method & URI looked up
     */
    public static RouteEntry get(Methods method, String path){
        RouteEntry[] entries = routes.toArray(new RouteEntry[routes.size()]);
        for(RouteEntry entry : entries){
            if(entry.getMethod().equals(method) && entry.getURI().equals(path)){
                return entry;
            }
        }
        return null;
    }
}
