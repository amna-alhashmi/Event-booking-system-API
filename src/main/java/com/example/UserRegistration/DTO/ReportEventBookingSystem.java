package com.example.UserRegistration.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ReportEventBookingSystem {
    Integer totalBooking;
    String topEvent;
    String topUsers;

    public ReportEventBookingSystem(Integer totalBooking, String topEvent, String topUsers) {
        this.totalBooking = totalBooking;
        this.topEvent = topEvent;
        this.topUsers = topUsers;
    }
}
