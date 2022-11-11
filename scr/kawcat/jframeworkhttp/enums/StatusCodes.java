package kawcat.jframeworkhttp.enums;

public enum StatusCodes {
    OK, CREATED, ACCEPTED, NON_AUTHORITATIVE_INFORMATION, NO_CONTENT, RESET_CONTENT, PARTIAL_CONTENT, MULTIPLE_CHOICES, MOVED_PERMANENTLY, FOUND, SEE_OTHER, NOT_MODIFIED, TEMPORARY_REDIRECT, PERMANENT_REDIRECT, BAD_REQUEST, UNAUTHORIZED, PAYMENT_REQUIRED, FORBIDDEN, NOT_FOUND, METHOD_NOT_ALLOWED, NOT_ACCEPTABLE, PROXY_AUTHENTICATION_REQUIRED, REQUEST_TIMEOUT, CONFLICT, GONE, LENGTH_REQUIRED, PRECONDITION_FAILED, PAYLOAD_TOO_LARGE, URI_TOO_LONG, UNSUPPORTED_MEDIA_TYPE, RANGE_NOT_SATISFIABLE, EXCEPTION_FAILED, IM_A_TEAPOT, UNPROCESSABLE_ENTITY, TOO_EARLY, UPGRADE_REQUIRED, PRECONDITION_REQUIRED, TOO_MANY_REQUESTS, REQUEST_HEADER_FIELDS_TOO_LARGE, UNAVAILABLE_FOR_LEGAL_REASONS, INTERNAL_SERVER_ERROR, NOT_IMPLEMENTED, BAD_GATEWAY, SERVICE_UNAVAILABLE, GATEWAY_TIMEOUT, HTTP_VERSION_NOT_SUPPORTED, VARIANT_ALSO_NEGOTIATES, INSUFFICIENT_STORAGE, LOOP_DETECTED, NOT_EXTENDED, NETWORK_AUTHENTICATION_REQUIRED, SIX_HUNDRED;

    public static StatusCodes getEnumByInt(int statusCode){
        return switch (statusCode) {
            // Successful responses (200-206)
            case 200 -> OK;
            case 201 -> CREATED;
            case 202 -> ACCEPTED;
            case 203 -> NON_AUTHORITATIVE_INFORMATION;
            case 204 -> NO_CONTENT;
            case 205 -> RESET_CONTENT;
            case 206 -> PARTIAL_CONTENT;
            // Redirection messages (300-308)
            case 300 -> MULTIPLE_CHOICES;
            case 301 -> MOVED_PERMANENTLY;
            case 302 -> FOUND;
            case 303 -> SEE_OTHER;
            case 304 -> NOT_MODIFIED;
            case 307 -> TEMPORARY_REDIRECT;
            case 308 -> PERMANENT_REDIRECT;
            // Client error response (400-451)
            case 400 -> BAD_REQUEST;
            case 401 -> UNAUTHORIZED;
            case 402 -> PAYMENT_REQUIRED;
            case 403 -> FORBIDDEN;
            case 404 -> NOT_FOUND;
            case 405 -> METHOD_NOT_ALLOWED;
            case 406 -> NOT_ACCEPTABLE;
            case 407 -> PROXY_AUTHENTICATION_REQUIRED;
            case 408 -> REQUEST_TIMEOUT;
            case 409 -> CONFLICT;
            case 410 -> GONE;
            case 411 -> LENGTH_REQUIRED;
            case 412 -> PRECONDITION_FAILED;
            case 413 -> PAYLOAD_TOO_LARGE;
            case 414 -> URI_TOO_LONG;
            case 415 -> UNSUPPORTED_MEDIA_TYPE;
            case 416 -> RANGE_NOT_SATISFIABLE;
            case 417 -> EXCEPTION_FAILED;
            case 418 -> IM_A_TEAPOT;
            case 422 -> UNPROCESSABLE_ENTITY;
            case 425 -> TOO_EARLY;
            case 426 -> UPGRADE_REQUIRED;
            case 428 -> PRECONDITION_REQUIRED;
            case 429 -> TOO_MANY_REQUESTS;
            case 431 -> REQUEST_HEADER_FIELDS_TOO_LARGE;
            case 451 -> UNAVAILABLE_FOR_LEGAL_REASONS;
            // Server error responses (500-511)
            case 500 -> INTERNAL_SERVER_ERROR;
            case 501 -> NOT_IMPLEMENTED;
            case 502 -> BAD_GATEWAY;
            case 503 -> SERVICE_UNAVAILABLE;
            case 504 -> GATEWAY_TIMEOUT;
            case 505 -> HTTP_VERSION_NOT_SUPPORTED;
            case 506 -> VARIANT_ALSO_NEGOTIATES;
            case 507 -> INSUFFICIENT_STORAGE;
            case 508 -> LOOP_DETECTED;
            case 510 -> NOT_EXTENDED;
            case 511 -> NETWORK_AUTHENTICATION_REQUIRED;
            default -> SIX_HUNDRED;
        };
    }

    public int getIntByEnum(){
        return switch (this) {
            // Successful responses (200-206)
            case OK -> 200;
            case CREATED -> 201;
            case ACCEPTED -> 202;
            case NON_AUTHORITATIVE_INFORMATION -> 203;
            case NO_CONTENT -> 204;
            case RESET_CONTENT -> 205;
            case PARTIAL_CONTENT -> 206;
            // Redirection messages (300-308)
            case MULTIPLE_CHOICES -> 300;
            case MOVED_PERMANENTLY -> 301;
            case FOUND -> 302;
            case SEE_OTHER -> 303;
            case NOT_MODIFIED -> 304;
            case TEMPORARY_REDIRECT -> 307;
            case PERMANENT_REDIRECT -> 308;
            // Client error response (400-451)
            case BAD_REQUEST -> 400;
            case UNAUTHORIZED -> 401;
            case PAYMENT_REQUIRED -> 402;
            case FORBIDDEN -> 403;
            case NOT_FOUND -> 404;
            case METHOD_NOT_ALLOWED -> 405;
            case NOT_ACCEPTABLE -> 406;
            case PROXY_AUTHENTICATION_REQUIRED -> 407;
            case REQUEST_TIMEOUT -> 408;
            case CONFLICT -> 409;
            case GONE -> 410;
            case LENGTH_REQUIRED -> 411;
            case PRECONDITION_FAILED -> 412;
            case PAYLOAD_TOO_LARGE -> 413;
            case URI_TOO_LONG -> 414;
            case UNSUPPORTED_MEDIA_TYPE -> 415;
            case RANGE_NOT_SATISFIABLE -> 416;
            case EXCEPTION_FAILED -> 417;
            case IM_A_TEAPOT -> 418;
            case UNPROCESSABLE_ENTITY -> 422;
            case TOO_EARLY -> 425;
            case UPGRADE_REQUIRED -> 426;
            case PRECONDITION_REQUIRED -> 428;
            case TOO_MANY_REQUESTS -> 429;
            case REQUEST_HEADER_FIELDS_TOO_LARGE -> 431;
            case UNAVAILABLE_FOR_LEGAL_REASONS -> 451;
            // Server error responses (500-511)
            case INTERNAL_SERVER_ERROR -> 500;
            case NOT_IMPLEMENTED -> 501;
            case BAD_GATEWAY -> 502;
            case SERVICE_UNAVAILABLE -> 503;
            case GATEWAY_TIMEOUT -> 504;
            case HTTP_VERSION_NOT_SUPPORTED -> 505;
            case VARIANT_ALSO_NEGOTIATES -> 506;
            case INSUFFICIENT_STORAGE -> 507;
            case LOOP_DETECTED -> 508;
            case NOT_EXTENDED -> 510;
            case NETWORK_AUTHENTICATION_REQUIRED -> 511;
            default -> 600;
        };
    }

    public String toString(){
        return switch (this) {
            // Successful responses (200-206)
            case OK -> "OK";
            case CREATED -> "Created";
            case ACCEPTED -> "Accepted";
            case NON_AUTHORITATIVE_INFORMATION -> "Non-Authoritative Information";
            case NO_CONTENT -> "No Content";
            case RESET_CONTENT -> "Reset Content";
            case PARTIAL_CONTENT -> "Partial Content";
            // Redirection messages (300-308)
            case MULTIPLE_CHOICES -> "Multiple Choices";
            case MOVED_PERMANENTLY -> "Moved Permanently";
            case FOUND -> "Found";
            case SEE_OTHER -> "See Other";
            case NOT_MODIFIED -> "Not Modified";
            case TEMPORARY_REDIRECT -> "Temporary Redirect";
            case PERMANENT_REDIRECT -> "Permanent Redirect";
            // Client error response (400-451)
            case BAD_REQUEST -> "Bad Request";
            case UNAUTHORIZED -> "Unauthorized";
            case PAYMENT_REQUIRED -> "Payment Required";
            case FORBIDDEN -> "Forbidden";
            case NOT_FOUND -> "Not Found";
            case METHOD_NOT_ALLOWED -> "Method Not Allowd";
            case NOT_ACCEPTABLE -> "Not Acceptable";
            case PROXY_AUTHENTICATION_REQUIRED -> "Proxy Authentication Required";
            case REQUEST_TIMEOUT -> "Request Timeout";
            case CONFLICT -> "Conflict";
            case GONE -> "Gone";
            case LENGTH_REQUIRED -> "Length Required";
            case PRECONDITION_FAILED -> "Prediction Failed";
            case PAYLOAD_TOO_LARGE -> "Payload Too Large";
            case URI_TOO_LONG -> "URI Too Large";
            case UNSUPPORTED_MEDIA_TYPE -> "Unsupported Media Type";
            case RANGE_NOT_SATISFIABLE -> "Range Not Satisfiable";
            case EXCEPTION_FAILED -> "Exception Failed";
            case IM_A_TEAPOT -> "I'm a teapot";
            case UNPROCESSABLE_ENTITY -> "Unprocessable Entity";
            case TOO_EARLY -> "Too Early";
            case UPGRADE_REQUIRED -> "Upgrade Required";
            case PRECONDITION_REQUIRED -> "Prediction Required";
            case TOO_MANY_REQUESTS -> "Too Many Requests";
            case REQUEST_HEADER_FIELDS_TOO_LARGE -> "Request Header Fields Too Large";
            case UNAVAILABLE_FOR_LEGAL_REASONS -> "Unavailable For Legal Reasons";
            // Server error responses (500-511)
            case INTERNAL_SERVER_ERROR -> "Internal Server Error";
            case NOT_IMPLEMENTED -> "Not Implemented";
            case BAD_GATEWAY -> "Bad Gateway";
            case SERVICE_UNAVAILABLE -> "Service Unavailable";
            case GATEWAY_TIMEOUT -> "Gateway Timeout";
            case HTTP_VERSION_NOT_SUPPORTED -> "HTTP Version Not Supported";
            case VARIANT_ALSO_NEGOTIATES -> "Variant Also Negotiates";
            case INSUFFICIENT_STORAGE -> "Insufficient Storage";
            case LOOP_DETECTED -> "Loop Detected";
            case NOT_EXTENDED -> "Not Extended";
            case NETWORK_AUTHENTICATION_REQUIRED -> "Network Authentication Required";
            default -> "JFramework";
        };
    }
}
