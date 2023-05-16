package com.example.UserRegistration.Models;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
Integer ticketAvailable;
String date;

    public Integer getTicketAvailable() {
        return ticketAvailable;
    }

    public void setTicketAvailable(Integer ticketAvailable) {
        this.ticketAvailable = ticketAvailable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
