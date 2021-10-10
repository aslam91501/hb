package com.hotelbooking.api.application;

import com.hotelbooking.api.entity.Guest;
import com.hotelbooking.api.repository.GuestRepository;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FindOrCreateGuestTest {
    @Autowired
    private GuestRepository repository;


    @BeforeAll
    public void setUp(){
        Guest guest = new Guest();
        guest.setFirstName("John");
        guest.setLastName("Doe");
        guest.setPhoneNumber("3335558888");

        repository.save(guest);
    }

   
    
}
