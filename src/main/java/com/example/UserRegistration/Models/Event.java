package com.example.UserRegistration.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Getter
@Setter
public class Event extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String location;
    Integer ticketAvailable;
    Integer booking;
    @OneToOne
    @JoinColumn(name = "User_id",referencedColumnName = "id")
    UserRegistration userRegistration;




}
