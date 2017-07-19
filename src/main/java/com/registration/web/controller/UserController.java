package com.registration.web.controller;

import com.registration.model.User;
import com.registration.service.UserService;
import com.registration.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    private final UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@RequestBody final User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.toString());
        }

        userService.save(userForm);
    }

    @RequestMapping(value = "/findByEmail/{email:.+}", method = RequestMethod.GET)
    @ResponseBody
    public User findByEmail(@PathVariable("email") final String email) {
        return userService.findByEmail(email);
    }
}
