package com.example.UserRegistration.Repositories;

import com.example.UserRegistration.Models.Event;
import com.example.UserRegistration.Models.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventInterface extends JpaRepository<Event,Integer> {
    @Query(value="SELECT id from event  where name= :evanName", nativeQuery = true)
    Integer getEvenId(@Param("evanName") String name);
    @Query(value = "SELECT s FROM Event s where s.id= :eventId")
    Event getAllEvent(@Param("eventId")Integer id);
    @Query(value = "SELECT s FROM Event s where s.location= :locationName AND s.date= :dates")
    Event getAllEvent1(@Param("locationName") String locationName, @Param("dates") String dates);
    @Query(value="SELECT id from event  where name= :eventName", nativeQuery = true)
    Integer getUserId(@Param("eventName") String name);
    @Query(value = "SELECT s FROM Event s where s.id= :eventId")
    Event getAllUserRegistration(@Param("eventId")Integer eventId);
    @Query(value = "SELECT s FROM Event s")
    List<Event> getTicketAvailability();
    @Query(value = "Select count(id) from event where name= :eventName", nativeQuery = true)
    Integer getEventBooking(@Param("eventName")String eventName);
    @Query (value = "SELECT s FROM Event s")
    List<Event> getAllEvent();
}
