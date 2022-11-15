package kawcat.jframeworkhttp.classes.objects;

import kawcat.jframeworkhttp.enums.Methods;
import kawcat.jframeworkhttp.interfaces.RequestHandler;

import java.io.File;

/**
 * Used for the `java.util.Collections` on `kawcat.jframework.classes.Router`
 */
public class RouteEntry {
    private final Methods method;
    private final String URI;
    private final RequestHandler handler;
    private final File file;

    /**
     * Route entry constructor
     * @param method `kawcat.jframework.enums.Method` HTTP method
     * @param URI `java.lang.String` URI requested
     * @param handler `kawcat.jframework.interfaces.RequestHandler` Class implementing the interface
     */
    public RouteEntry(Methods method, String URI, RequestHandler handler) {
        this.method = method;
        this.URI = URI;
        this.handler = handler;
        this.file = null;
    }

    public RouteEntry(Methods method, String URI, File file) {
        this.method = method;
        this.URI = URI;
        this.handler = null;
        this.file = file;
    }

    /**
     * Get the HTTP method
     * @return `kawcat.jframework.enums.Methods` HTTP method
     */
    public Methods getMethod() {
        return method;
    }

    /**
     * Get the HTTP URI
     * @return `java.lang.String`
     */
    public String getURI() {
        return URI;
    }

    /**
     * Get the class implementing `kawcat.jframework.interfaces.RequestHandler`
     * @return `kawcat.jframework.interfaces.RequestHandler` Class implementing the interface
     */
    public RequestHandler getHandler() {
        return handler;
    }

    public File getFile() {
        return file;
    }
}
