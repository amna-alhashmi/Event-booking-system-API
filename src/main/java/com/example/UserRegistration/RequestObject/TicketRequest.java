package com.example.UserRegistration.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class TicketRequest {
    Integer numberOfTickets;
    String eventName;
    String location;
    String userName;
    String date;
    String name;
    Integer ticketAvailable;
}
