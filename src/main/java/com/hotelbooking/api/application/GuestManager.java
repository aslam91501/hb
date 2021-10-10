package com.hotelbooking.api.application;

import com.hotelbooking.api.entity.Guest;
import com.hotelbooking.api.repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestManager {
    @Autowired
    private GuestRepository guestRepository;
    
    public void CreateGuestIfNotExists(Guest guest){
        if(!guestRepository.existsByPhoneNumber(guest.getPhoneNumber())){
            guestRepository.save(guest);
        } else return;
    }

    public Guest findGuestIfExists(String phoneNumber){
        Guest guest = guestRepository.findByPhoneNumber(phoneNumber);
        return guest;
    }

}
