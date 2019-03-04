package com.epam.producing.testProject.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomerNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler
    @ResponseStatus
    String customerNotFoundException(CustomerNotFoundException ex) {
        return ex.getMessage();
    }
}
