package com.example.UserRegistration.Repositories;

import com.example.UserRegistration.Models.Event;
import com.example.UserRegistration.Models.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketBookingInterface extends JpaRepository<TicketBooking,Integer> {
    @Query(value = "SELECT s FROM TicketBooking s where s.id= :eventId")
    TicketBooking getAllTicket(@Param("eventId")Integer id);
    @Query (value = "SELECT s FROM TicketBooking s")
    List<TicketBooking> getAllTicket1();
    @Query(value = "SELECT s.numberOfTicket FROM TicketBooking s where s.Event.id= :eventId")
    List<TicketBooking> getBookingByNumberOfTicket(@Param("eventId")Integer id);
    @Query(value = "SELECT s FROM TicketBooking s where s.id= :ticketBookingId")
    TicketBooking getTicketById(@Param("ticketBookingId")Integer id);
}
