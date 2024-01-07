package com.gomarket.GoMarket.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiError> notFound(NotFoundException exception) {
        return new ResponseEntity<>(new ApiError(404, exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ApiError> badRequest(BadRequestException exception) {
        return new ResponseEntity<>(new ApiError(400, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
