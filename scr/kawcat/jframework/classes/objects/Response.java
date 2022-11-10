package kawcat.jframework.classes.objects;

import kawcat.jframework.enums.StatusCodes;

public class Response {
    private final String version;
    private final StatusCodes statusCode;
    private final byte[] content;

    /**
     * Response constructor
     * @param version `java.lang.String` HTTP version used
     * @param statusCode `kawcat.jframework.enums.StatusCode` HTTP status code
     * @param content `byte[]` Content response
     */
    public Response(String version, StatusCodes statusCode, byte[] content) {
        this.version = version;
        this.statusCode = statusCode;
        this.content = content;
    }

    /**
     * Get the response HTTP version used
     * @return `java.lang.String` of the HTTP version used
     */
    public String getVersion(){
        return version;
    }

    /**
     * Get the response status code
     * @return `kawcat.jframework.enums.StatusCodes` of the response
     */
    public StatusCodes getStatusCode(){
        return statusCode;
    }

    /**
     * Get the response content
     * @return `byte[]` of the content
     */
    public byte[] getContent() {
        return content;
    }
}
