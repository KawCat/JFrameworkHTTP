package kawcat.jframework.interfaces;

import kawcat.jframework.classes.objects.Request;
import kawcat.jframework.classes.objects.Response;

public interface RequestHandler {
    /**
     *
     * @param request HTTP request
     * @return `kawcat.jframework.classes.objects.Response` object, if just once this returns null the class will be unregistered automatically
     */
    Response handle(Request request);
}
