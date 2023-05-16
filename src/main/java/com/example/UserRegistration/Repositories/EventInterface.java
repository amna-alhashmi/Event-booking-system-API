package com.example.UserRegistration.Repositories;

import com.example.UserRegistration.Models.Event;
import com.example.UserRegistration.Models.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventInterface extends JpaRepository<Event,Integer> {
    @Query(value="SELECT id from event  where name= :evanName", nativeQuery = true)
    Integer getEvenId(@Param("evanName") String name);
    @Query(value = "SELECT s FROM Event s where s.id= :eventId")
    Event getAllEvent(@Param("eventId")Integer id);
    @Query(value = "SELECT s FROM Event s")
    Event getAllEvent1(Integer id ,String locationName, String date);
    @Query(value="SELECT id from event  where name= :eventName", nativeQuery = true)
    Integer getUserId(@Param("eventName") String name);
    @Query(value = "SELECT s FROM Event s where s.id= :eventId")
    Event getAllUserRegistration(@Param("eventId")Integer eventId);

}
