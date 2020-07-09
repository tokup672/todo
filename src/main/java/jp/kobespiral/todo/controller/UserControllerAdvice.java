package jp.kobespiral.todo.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String occurOtherException(Exception exception){
        return "error";
    }

    @ExceptionHandler(BindException.class)
    public String inputError(BindException exception, Model model){
        model.addAttribute("errMsg", exception.getMessage());
        return "error_input";
    }
}