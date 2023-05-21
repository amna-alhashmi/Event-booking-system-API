package com.example.UserRegistration.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
public class TicketBooking extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer numberOfTickets;
    String eventName;
    String location;
    String isActive;

    @OneToOne
    @JoinColumn(name = "Event_id",referencedColumnName = "id")
    Event event;
    @OneToOne
    @JoinColumn(name = "User_id",referencedColumnName = "id")
    UserRegistration userRegistration;


}
