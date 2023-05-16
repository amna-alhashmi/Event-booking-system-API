package com.example.UserRegistration.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Data
@Setter
@Getter
public class EventRequest {
    Integer id;
    String name;
    String location;
    String date;
    Integer ticketAvailable;
    String userName;


}
