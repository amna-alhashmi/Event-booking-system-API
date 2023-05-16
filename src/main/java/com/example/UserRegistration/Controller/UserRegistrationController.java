package com.example.UserRegistration.Controller;

import com.example.UserRegistration.Models.UserRegistration;
import com.example.UserRegistration.Service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "register")
public class UserRegistrationController {
    @Autowired
    UserRegistrationService userRegistrationService;
    @RequestMapping(value = "UserRegistrationInformation", method = RequestMethod.POST)
    public String addPersonalInformation(@RequestBody UserRegistration userRegistration) {
        userRegistrationService.addPersonalInformation(userRegistration);

        return "UserRegistration add successful";
    }
}
