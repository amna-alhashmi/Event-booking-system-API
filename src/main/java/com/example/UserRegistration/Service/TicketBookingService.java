package com.example.UserRegistration.Service;

import com.example.UserRegistration.Models.Event;
import com.example.UserRegistration.Models.TicketBooking;
import com.example.UserRegistration.Models.UserRegistration;
import com.example.UserRegistration.Repositories.EventInterface;
import com.example.UserRegistration.Repositories.TicketBookingInterface;
import com.example.UserRegistration.Repositories.UserRegistrationInterface;
import com.example.UserRegistration.RequestObject.TicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class TicketBookingService {
    @Autowired
    EventInterface eventInterface;
    @Autowired
    UserRegistrationInterface userRegistrationInterface;
    @Autowired
    TicketBookingInterface ticketBookingInterface;
    public void addNewTicket(TicketRequest ticketRequest){

        TicketBooking ticketInformation=new TicketBooking();
        ticketInformation.setNumberOfTickets(ticketRequest.getNumberOfTickets());
        ticketInformation.setEventName(ticketRequest.getEventName());
        ticketInformation.setLocation(ticketRequest.getLocation());
        ticketInformation.setDate(ticketRequest.getDate());
        ticketInformation.setTicketAvailable(ticketRequest.getTicketAvailable());

        Integer id = userRegistrationInterface.getUserId(ticketRequest.getUserName());
        UserRegistration userId = userRegistrationInterface.getAllUserRegistration(id);
        ticketInformation.setUserRegistration(userId);


        Integer id1 = eventInterface.getUserId(ticketRequest.getName());
        Event eventId = eventInterface.getAllUserRegistration(id1);
        ticketInformation.setEvent(eventId);

        ticketBookingInterface.save(ticketInformation);
    }

    public Integer getBookingByNumberOfTicket(Integer eventId)throws ParseException {
        Integer ticketBookings=ticketBookingInterface.getBookingByNumberOfTicket(eventId);
        return ticketBookings;

    }
    public List<TicketBooking> getAllTicket1(){
        return ticketBookingInterface.getAllTicket1();
    }

public void BookingCancellation(Integer bookingId){
        TicketBooking ticketBooking=ticketBookingInterface.findById(bookingId).get();
        ticketBooking.setIsActive("False");
        ticketBookingInterface.save(ticketBooking);
}


//    public void addBookingInformation(TicketBooking ticketBooking){
//        TicketBooking TicketBooking1=new TicketBooking();
//        TicketBooking1.setNumberOfTickets(ticketBooking.getNumberOfTickets());
//        TicketBooking1.setEventName(ticketBooking.getEventName());
//        TicketBooking1.setLocation(ticketBooking.getLocation());
//        eventInterface.save(TicketBooking1);
    }
//}

