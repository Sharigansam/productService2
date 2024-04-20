package com.example.productservice2.advice;

import com.example.productservice2.dtos.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Something went wrong");
        return new ResponseEntity<>(errorDto,
                HttpStatusCode.valueOf(404));
    }
}

