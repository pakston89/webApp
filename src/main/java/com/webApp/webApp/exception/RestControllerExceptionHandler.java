package com.webApp.webApp.exception;

import com.webApp.webApp.utils.LogConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "controller")
public class RestControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void anyException(Exception ex)
    {
        LogConstants.RestControllerExceptionHandlerLOG.error(ex);
    }
}
