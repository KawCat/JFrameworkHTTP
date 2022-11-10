package kawcat.jframework.enums;

public enum StatusCodes {
    OK, CREATED, ACCEPTED, NON_AUTHORITATIVE_INFORMATION, NO_CONTENT, RESET_CONTENT, PARTIAL_CONTENT, MULTIPLE_CHOICES, MOVED_PERMANENTLY, FOUND, SEE_OTHER, NOT_MODIFIED, TEMPORARY_REDIRECT, PERMANENT_REDIRECT, BAD_REQUEST, UNAUTHORIZED, PAYMENT_REQUIRED, FORBIDDEN, NOT_FOUND, METHOD_NOT_ALLOWED, NOT_ACCEPTABLE, PROXY_AUTHENTICATION_REQUIRED, REQUEST_TIMEOUT, CONFLICT, GONE, LENGTH_REQUIRED, PRECONDITION_FAILED, PAYLOAD_TOO_LARGE, URI_TOO_LONG, UNSUPPORTED_MEDIA_TYPE, RANGE_NOT_SATISFIABLE, EXCEPTION_FAILED, IM_A_TEAPOT, UNPROCESSABLE_ENTITY, TOO_EARLY, UPGRADE_REQUIRED, PRECONDITION_REQUIRED, TOO_MANY_REQUESTS, REQUEST_HEADER_FIELDS_TOO_LARGE, UNAVAILABLE_FOR_LEGAL_REASONS, INTERNAL_SERVER_ERROR, NOT_IMPLEMENTED, BAD_GATEWAY, SERVICE_UNAVAILABLE, GATEWAY_TIMEOUT, HTTP_VERSION_NOT_SUPPORTED, VARIANT_ALSO_NEGOTIATES, INSUFFICIENT_STORAGE, LOOP_DETECTED, NOT_EXTENDED, NETWORK_AUTHENTICATION_REQUIRED, SIX_HUNDRED;

    public static StatusCodes getEnumByInt(int statusCode){
        switch(statusCode){
            // Successful responses (200-206)
            case 200: return OK;
            case 201: return CREATED;
            case 202: return ACCEPTED;
            case 203: return NON_AUTHORITATIVE_INFORMATION;
            case 204: return NO_CONTENT;
            case 205: return RESET_CONTENT;
            case 206: return PARTIAL_CONTENT;
            // Redirection messages (300-308)
            case 300: return MULTIPLE_CHOICES;
            case 301: return MOVED_PERMANENTLY;
            case 302: return FOUND;
            case 303: return SEE_OTHER;
            case 304: return NOT_MODIFIED;
            case 307: return TEMPORARY_REDIRECT;
            case 308: return PERMANENT_REDIRECT;
            // Client error response (400-451)
            case 400: return BAD_REQUEST;
            case 401: return UNAUTHORIZED;
            case 402: return PAYMENT_REQUIRED;
            case 403: return FORBIDDEN;
            case 404: return NOT_FOUND;
            case 405: return METHOD_NOT_ALLOWED;
            case 406: return NOT_ACCEPTABLE;
            case 407: return PROXY_AUTHENTICATION_REQUIRED;
            case 408: return REQUEST_TIMEOUT;
            case 409: return CONFLICT;
            case 410: return GONE;
            case 411: return LENGTH_REQUIRED;
            case 412: return PRECONDITION_FAILED;
            case 413: return PAYLOAD_TOO_LARGE;
            case 414: return URI_TOO_LONG;
            case 415: return UNSUPPORTED_MEDIA_TYPE;
            case 416: return RANGE_NOT_SATISFIABLE;
            case 417: return EXCEPTION_FAILED;
            case 418: return IM_A_TEAPOT;
            case 422: return UNPROCESSABLE_ENTITY;
            case 425: return TOO_EARLY;
            case 426: return UPGRADE_REQUIRED;
            case 428: return PRECONDITION_REQUIRED;
            case 429: return TOO_MANY_REQUESTS;
            case 431: return REQUEST_HEADER_FIELDS_TOO_LARGE;
            case 451: return UNAVAILABLE_FOR_LEGAL_REASONS;
            // Server error responses (500-511)
            case 500: return INTERNAL_SERVER_ERROR;
            case 501: return NOT_IMPLEMENTED;
            case 502: return BAD_GATEWAY;
            case 503: return SERVICE_UNAVAILABLE;
            case 504: return GATEWAY_TIMEOUT;
            case 505: return HTTP_VERSION_NOT_SUPPORTED;
            case 506: return VARIANT_ALSO_NEGOTIATES;
            case 507: return INSUFFICIENT_STORAGE;
            case 508: return LOOP_DETECTED;
            case 510: return NOT_EXTENDED;
            case 511: return NETWORK_AUTHENTICATION_REQUIRED;
            default: return SIX_HUNDRED;
        }
    }

    public int getIntByEnum(){
        switch(this){
            // Successful responses (200-206)
            case OK: return 200;
            case CREATED: return 201;
            case ACCEPTED: return 202;
            case NON_AUTHORITATIVE_INFORMATION: return 203;
            case NO_CONTENT: return 204;
            case RESET_CONTENT: return 205;
            case PARTIAL_CONTENT: return 206;
            // Redirection messages (300-308)
            case MULTIPLE_CHOICES: return 300;
            case MOVED_PERMANENTLY: return 301;
            case FOUND: return 302;
            case SEE_OTHER: return 303;
            case NOT_MODIFIED: return 304;
            case TEMPORARY_REDIRECT: return 307;
            case PERMANENT_REDIRECT: return 308;
            // Client error response (400-451)
            case BAD_REQUEST: return 400;
            case UNAUTHORIZED: return 401;
            case PAYMENT_REQUIRED: return 402;
            case FORBIDDEN: return 403;
            case NOT_FOUND: return 404;
            case METHOD_NOT_ALLOWED: return 405;
            case NOT_ACCEPTABLE: return 406;
            case PROXY_AUTHENTICATION_REQUIRED: return 407;
            case REQUEST_TIMEOUT: return 408;
            case CONFLICT: return 409;
            case GONE: return 410;
            case LENGTH_REQUIRED: return 411;
            case PRECONDITION_FAILED: return 412;
            case PAYLOAD_TOO_LARGE: return 413;
            case URI_TOO_LONG: return 414;
            case UNSUPPORTED_MEDIA_TYPE: return 415;
            case RANGE_NOT_SATISFIABLE: return 416;
            case EXCEPTION_FAILED: return 417;
            case IM_A_TEAPOT: return 418;
            case UNPROCESSABLE_ENTITY: return 422;
            case TOO_EARLY: return 425;
            case UPGRADE_REQUIRED: return 426;
            case PRECONDITION_REQUIRED: return 428;
            case TOO_MANY_REQUESTS: return 429;
            case REQUEST_HEADER_FIELDS_TOO_LARGE: return 431;
            case UNAVAILABLE_FOR_LEGAL_REASONS: return 451;
            // Server error responses (500-511)
            case INTERNAL_SERVER_ERROR: return 500;
            case NOT_IMPLEMENTED: return 501;
            case BAD_GATEWAY: return 502;
            case SERVICE_UNAVAILABLE: return 503;
            case GATEWAY_TIMEOUT: return 504;
            case HTTP_VERSION_NOT_SUPPORTED: return 505;
            case VARIANT_ALSO_NEGOTIATES: return 506;
            case INSUFFICIENT_STORAGE: return 507;
            case LOOP_DETECTED: return 508;
            case NOT_EXTENDED: return 510;
            case NETWORK_AUTHENTICATION_REQUIRED: return 511;
            default: return 600;
        }
    }

    public String toString(){
        switch(this){
            // Successful responses (200-206)
            case OK: return "OK";
            case CREATED: return "Created";
            case ACCEPTED: return "Accepted";
            case NON_AUTHORITATIVE_INFORMATION: return "Non-Authoritative Information";
            case NO_CONTENT: return "No Content";
            case RESET_CONTENT: return "Reset Content";
            case PARTIAL_CONTENT: return "Partial Content";
            // Redirection messages (300-308)
            case MULTIPLE_CHOICES: return "Multiple Choices";
            case MOVED_PERMANENTLY: return "Moved Permanently";
            case FOUND: return "Found";
            case SEE_OTHER: return "See Other";
            case NOT_MODIFIED: return "Not Modified";
            case TEMPORARY_REDIRECT: return "Temporary Redirect";
            case PERMANENT_REDIRECT: return "Permanent Redirect";
            // Client error response (400-451)
            case BAD_REQUEST: return "Bad Request";
            case UNAUTHORIZED: return "Unauthorized";
            case PAYMENT_REQUIRED: return "Payment Required";
            case FORBIDDEN: return "Forbidden";
            case NOT_FOUND: return "Not Found";
            case METHOD_NOT_ALLOWED: return "Method Not Allowd";
            case NOT_ACCEPTABLE: return "Not Acceptable";
            case PROXY_AUTHENTICATION_REQUIRED: return "Proxy Authentication Required";
            case REQUEST_TIMEOUT: return "Request Timeout";
            case CONFLICT: return "Conflict";
            case GONE: return "Gone";
            case LENGTH_REQUIRED: return "Length Required";
            case PRECONDITION_FAILED: return "Prediction Failed";
            case PAYLOAD_TOO_LARGE: return "Payload Too Large";
            case URI_TOO_LONG: return "URI Too Large";
            case UNSUPPORTED_MEDIA_TYPE: return "Unsupported Media Type";
            case RANGE_NOT_SATISFIABLE: return "Range Not Satisfiable";
            case EXCEPTION_FAILED: return "Exception Failed";
            case IM_A_TEAPOT: return "I'm a teapot";
            case UNPROCESSABLE_ENTITY: return "Unprocessable Entity";
            case TOO_EARLY: return "Too Early";
            case UPGRADE_REQUIRED: return "Upgrade Required";
            case PRECONDITION_REQUIRED: return "Prediction Required";
            case TOO_MANY_REQUESTS: return "Too Many Requests";
            case REQUEST_HEADER_FIELDS_TOO_LARGE: return "Request Header Fields Too Large";
            case UNAVAILABLE_FOR_LEGAL_REASONS: return "Unavailable For Legal Reasons";
            // Server error responses (500-511)
            case INTERNAL_SERVER_ERROR: return "Internal Server Error";
            case NOT_IMPLEMENTED: return "Not Implemented";
            case BAD_GATEWAY: return "Bad Gateway";
            case SERVICE_UNAVAILABLE: return "Service Unavailable";
            case GATEWAY_TIMEOUT: return "Gateway Timeout";
            case HTTP_VERSION_NOT_SUPPORTED: return "HTTP Version Not Supported";
            case VARIANT_ALSO_NEGOTIATES: return "Variant Also Negotiates";
            case INSUFFICIENT_STORAGE: return "Insufficient Storage";
            case LOOP_DETECTED: return "Loop Detected";
            case NOT_EXTENDED: return "Not Extended";
            case NETWORK_AUTHENTICATION_REQUIRED: return "Network Authentication Required";
            default: return "JFramework";
        }
    }
}
