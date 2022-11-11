package kawcat.jframeworkhttp.classes.objects;

import kawcat.jframeworkhttp.enums.Methods;

public class Request {
    private final Methods method;
    private final String URI, version;

    /**
     * Request constructor
     * @param method `kawcat.jframework.enums.Methods` Method used to make the request
     * @param URI `java.lang.String` URI requested
     * @param version `java.lang.String` HTTP version used
     */
    public Request(final Methods method, final String URI, final String version) {
        this.method = method;
        this.URI = URI;
        this.version = version;
    }

    /**
     * Get the method used to make the request
     * @return `kawcat.jframework.enums.Methods`
     */
    public Methods getMethod(){
        return method;
    }

    /**
     * Get the URI requested
     * @return `java.lang.String`
     */
    public String getURI(){
        return URI;
    }

    /**
     * Get the HTTP version used
     * @return `java.lang.String`
     */
    public String getVersion(){
        return version;
    }

    public String toString(){
        return "[" + getMethod().toString() + ", " + getURI() + ", " + getVersion() + "]";
    }
}
