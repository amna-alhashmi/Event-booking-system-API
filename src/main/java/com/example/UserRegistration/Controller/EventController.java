package com.example.UserRegistration.Controller;

import com.example.UserRegistration.Models.Event;
import com.example.UserRegistration.Models.UserRegistration;
import com.example.UserRegistration.RequestObject.EventRequest;
import com.example.UserRegistration.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "events")
public class EventController {
    @Autowired
    EventService eventService;
    @RequestMapping(value = "addNewEvent", method = RequestMethod.POST)
    public String addNewEvent(@RequestBody EventRequest eventRequest) {
        eventService.addNewEvent(eventRequest);

        return "NewEvent add successful";
    }
    @RequestMapping(value = "Value",method = RequestMethod.GET)
    public Event getValue(@RequestParam String location,String date){
        return eventService.getValue(location,date);
    }
//    @RequestMapping(value = "Value", method = RequestMethod.POST)
//    public String getValue(@RequestParam Integer id ,String location, String dateFrom,String dateTo) {
//        try {
//            eventService.getValue(id,location,dateFrom,dateTo);
//            return "Event get Successfully";
//        } catch (Exception e) {
//            return "Event get Failed";
//        }
//    }


}
