package kawcat.jframeworkhttp.classes.objects;

import kawcat.jframeworkhttp.enums.StatusCodes;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private final String CRLF = "\r\n";
    private final StatusCodes statusCode;
    private Map<String, String> headers = new HashMap<>();
    private final byte[] content;

    /**
     * Response constructor
     * @param statusCode `kawcat.jframework.enums.StatusCode` HTTP status code
     * @param content `byte[]` Content response
     */
    public Response(StatusCodes statusCode, byte[] content) {
        this.statusCode = statusCode;
        this.content = content;
    }

    /**
     * Get the response status code
     * @return `kawcat.jframework.enums.StatusCodes` of the response
     */
    public StatusCodes getStatusCode(){
        return statusCode;
    }

    public void addHeader(String K, String V){
        if(headers.get(K) != null){
            headers.replace(K, V);
        }else{
            headers.put(K, V);
        }
    }

    public boolean removeHeader(String K, String V){
        return headers.remove(K, V);
    }

    public String getHeaders(){
        final StringBuffer headersRaw = new StringBuffer();
        headers.forEach((K, V) -> {
            headersRaw.append(K + ": " + V + CRLF);
        });

        return headersRaw.toString();
    }

    /**
     * Get the response content
     * @return `byte[]` of the content
     */
    public byte[] getContent() {
        return content;
    }
}
