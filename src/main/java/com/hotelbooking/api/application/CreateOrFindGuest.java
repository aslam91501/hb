package com.hotelbooking.api.application;

import com.hotelbooking.api.entity.Guest;
import com.hotelbooking.api.repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateOrFindGuest {
    @Autowired
    private GuestRepository guestRepository;

    public void CreateGuestIfNotExists(Guest guest){
        if(!guestRepository.existsByPhoneNumber(guest.getPhoneNumber())){
            
        }
    }
}
