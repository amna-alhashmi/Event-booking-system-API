package com.example.UserRegistration.Repositories;

import com.example.UserRegistration.Models.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistrationInterface extends JpaRepository<UserRegistration,Integer> {
    @Query(value="SELECT id from user_registration  where user_name= :userName", nativeQuery = true)
    Integer getUserId(@Param("userName") String user_name);
    @Query(value = "SELECT s FROM UserRegistration s where s.id= :userId")
    UserRegistration getAllUserRegistration(@Param("userId")Integer userId);

}
