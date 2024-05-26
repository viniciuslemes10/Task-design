package br.com.tak.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceObjectIsNotNullException extends RuntimeException{
    public ResourceObjectIsNotNullException(String message) {
        super(message);
    }

    public ResourceObjectIsNotNullException() {
        super("It is not allowed to persist a null object");
    }
}
