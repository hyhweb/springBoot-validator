package com.springboot.validator.controller;

import com.springboot.validator.bean.BeanValidator;
import com.springboot.validator.entity.User;
import com.springboot.validator.exception.NotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.*;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
    public User addUser(User user) {

        BeanValidator.validate(user);
        /*if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }*/
        return user;

    }


}
