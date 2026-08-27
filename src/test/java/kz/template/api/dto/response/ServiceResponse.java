package kz.template.api.dto.response;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ServiceResponse<T> {

    private final int statusCode;
    private final Headers headers;
    private final String rawBody;
    private final T body;

    public ServiceResponse(Response response, Class<T> bodyClass) {
        this.statusCode = response.statusCode();
        this.headers = response.headers();
        this.rawBody = response.asString();
        this.body = deserializeBody(response, bodyClass);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Headers getHeaders() {
        return headers;
    }

    public String getRawBody() {
        return rawBody;
    }

    public T getBody() {
        return body;
    }

    private T deserializeBody(Response response, Class<T> bodyClass) {
        if (bodyClass == null || bodyClass == Void.class) {
            return null;
        }

        return response.as(bodyClass);
    }
}