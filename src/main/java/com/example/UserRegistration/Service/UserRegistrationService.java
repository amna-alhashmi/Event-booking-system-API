package com.example.UserRegistration.Service;

import com.example.UserRegistration.Models.UserRegistration;
import com.example.UserRegistration.Repositories.UserRegistrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    UserRegistrationInterface userRegistrationInterface;
    public void addPersonalInformation(UserRegistration userRegistration){
        UserRegistration userInformation=new UserRegistration();
        userInformation.setUserName(userRegistration.getUserName());
        userInformation.setPassword(userRegistration.getPassword());
        userRegistrationInterface.save(userInformation);
    }
}
