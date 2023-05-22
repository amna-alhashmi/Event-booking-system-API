package com.example.UserRegistration.Service;

import com.example.UserRegistration.Repositories.EventInterface;
import com.example.UserRegistration.Repositories.TicketBookingInterface;
import com.example.UserRegistration.Repositories.UserRegistrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
@Autowired
    UserRegistrationInterface userRegistrationInterface;
@Autowired
    EventInterface eventInterface;
@Autowired
    TicketBookingInterface ticketBookingInterface;

}
