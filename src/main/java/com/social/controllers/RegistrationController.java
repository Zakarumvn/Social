package com.social.controllers;

import com.social.entities.User;
import com.social.services.UserService;
import com.social.validators.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Katarzyna on 2017-03-24.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationValidator registrationValidator;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User userForm, BindingResult bindingResult, Model model, WebRequest request) {

        registrationValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User registered = userService.registerNewAccount(userForm);

        model.addAttribute("msg", "You've been registered, check your email to verificate your account.");
        return "login";
    }
}
