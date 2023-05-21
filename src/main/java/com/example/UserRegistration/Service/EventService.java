package com.example.UserRegistration.Service;

import com.example.UserRegistration.Models.Event;
import com.example.UserRegistration.Models.UserRegistration;
import com.example.UserRegistration.Repositories.EventInterface;
import com.example.UserRegistration.Repositories.UserRegistrationInterface;
import com.example.UserRegistration.RequestObject.EventRequest;
import com.example.UserRegistration.RequestObject.EventSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Service
public class EventService {
    @Autowired
    EventInterface eventInterface;
    @Autowired
    UserRegistrationInterface userRegistrationInterface;

    public void addNewEvent(EventRequest eventRequest){
        Event eventInformation=new Event();
        eventInformation.setName(eventRequest.getName());
        eventInformation.setLocation(eventRequest.getLocation());
        eventInformation.setTicketAvailable(eventRequest.getTicketAvailable());
        eventInformation.setDate(eventRequest.getDate());
        Integer id = userRegistrationInterface.getUserId(eventRequest.getUserName());
        UserRegistration userId = userRegistrationInterface.getAllUserRegistration(id);
        eventInformation.setUserRegistration(userId);
        eventInterface.save(eventInformation);
    }
    public Event getValue(String location,String date){
        return eventInterface.getAllEvent1(location,date);
    }

//    public Event getValue(EventSearch eventSearch) throws ParseException {
//
//        Event event = new Event();
//        event.setName(eventSearch.getName());
//        event.setDate(eventSearch.getDateFrom());
//        event.setDate(eventSearch.getDateTo());
//        event.();
//        eventInterface.save(event);
//        return event;
//    }


}
