package com.example.UserRegistration.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ReportEventBookingSystem {
    Integer totalBooking;
    String eventName;
    Integer booking;
    String userName;
    Integer userBooking;

    public ReportEventBookingSystem(Integer totalBooking, String eventName, Integer booking, String userName, Integer userBooking) {
        this.totalBooking = totalBooking;
        this.eventName = eventName;
        this.booking = booking;
        this.userName = userName;
        this.userBooking = userBooking;
    }
}
