package com.hotelbooking.api.service;

import java.util.List;

import com.hotelbooking.api.entity.Guest;
import com.hotelbooking.api.repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImplementation implements GuestService{
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<Guest> getAllGuests(){
        List<Guest> guests = guestRepository.findAll();
        return guests;
    }

    @Override
    public void createGuest(Guest guest){
        guestRepository.save(guest);
    }

    @Override
    public Guest findGuestByPhoneNumber(String phoneNumber) {
        return guestRepository.findByPhoneNumber(phoneNumber);
    }


}
