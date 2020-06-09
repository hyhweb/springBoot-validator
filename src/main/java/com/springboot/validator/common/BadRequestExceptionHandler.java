package com.springboot.validator.common;

import ch.qos.logback.core.pattern.ConverterUtil;
import com.springboot.validator.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class BadRequestExceptionHandler extends ResponseEntityExceptionHandler {
  /*  @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> messages = new HashMap<>();
        BindingResult result = ex.getBindingResult();
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
              for (ObjectError error : errors) {
                FieldError fieldError = (FieldError) error;
                messages.put(fieldError.getField(), fieldError.getDefaultMessage());
              }
        }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messages);
       // return super.handleBindException(ex, headers, status, request);
    }*/

    @ExceptionHandler(Exception.class)
    public Object dispose(final HttpServletRequest request, final HttpServletResponse response,
                          final Exception ex) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("mgs", ex.getMessage());
        map.put("code", "0");
        return map;

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Object handleNotFoundException(NotFoundException ex) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("mgs", ex.getMessage());
        map.put("code", String.valueOf(HttpStatus.NOT_FOUND.value()));
        return map;
    }
}
