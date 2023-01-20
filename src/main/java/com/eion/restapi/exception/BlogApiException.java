package com.eion.restapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter

public class BlogApiException extends RuntimeException{
    private HttpStatus status;
    private  String message;
}
