package kawcat.jframeworkhttp.classes.objects;

import kawcat.jframeworkhttp.enums.Methods;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private final String CRLF = "\r\n";
    private final Methods method;
    private final String URI, version;
    private Map<String, String> headers = new HashMap<>();


    /**
     * Request constructor
     * @param method `kawcat.jframework.enums.Methods` Method used to make the request
     * @param URI `java.lang.String` URI requested
     * @param version `java.lang.String` HTTP version used
     */
    public Request(final Methods method, final String URI, final String version, final Map<String, String> headers) {
        this.method = method;
        this.URI = URI;
        this.version = version;
        this.headers = headers;
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

    public String[] getHeaders(){
        String[] array = new String[headers.size()];
        int[] i = { 0 };
        headers.forEach((K, V) -> {
            array[i[0]] = K + ": " + V;
            i[0]++;
        });

        return array;
    }
}
