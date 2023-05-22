package com.example.UserRegistration.SchedulJob;

import com.example.UserRegistration.Models.Event;
import com.example.UserRegistration.Service.EventService;
import com.example.UserRegistration.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Schedul {
@Autowired
    SlackClient slackClient;
@Autowired
    EventService eventService;
    @Scheduled(cron ="0 */5 * * * *")
    public List<Event> getTicketAvailability() {
        List<Event> events = eventService.getTicketAvailability();
        for (Event s:events)
        {
            slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of school is:"+s.getName());
        }
        return events;
    }
}
