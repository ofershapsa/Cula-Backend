package com.example.demoCulaSystem.advise;

import com.example.demoCulaSystem.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
public class ExceptionsHandler {


    @ExceptionHandler(value = UserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handler(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = TaskException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handler2(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = EventException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handler3(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = JobException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handler4(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = ProjectException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handler5(Exception e) {
        return e.getMessage();
    }
}