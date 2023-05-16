package br.com.projeto.mentoria.exceptions;

import org.aspectj.bridge.IMessage;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{
    private HttpStatus statusCode;

    public ApiException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
