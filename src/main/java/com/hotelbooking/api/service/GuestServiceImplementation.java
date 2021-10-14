package com.hotelbooking.api.service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateGuest(Guest guest) {
        Optional<Guest> guestData = guestRepository.findById(guest.getId());        

        if(guestData.isPresent()){
            Guest _guest = guestData.get();
            
            if(guest.getFirstName() != null && guest.getFirstName() != _guest.getFirstName())
                _guest.setFirstName(guest.getFirstName());
            
            if(guest.getLastName() != null && guest.getLastName() != _guest.getLastName())
                _guest.setLastName(guest.getLastName());

            if(guest.getPhoneNumber() != null && guest.getPhoneNumber() != _guest.getPhoneNumber())
                _guest.setPhoneNumber(guest.getPhoneNumber());    

            guestRepository.save(_guest);
        }
    }



    @Override
    public Guest findById(Long id) {
        return guestRepository.findById(id).get();
    }

    @Override
    public void deleteGuest(Long id) {
        if(guestRepository.existsById(id))
            guestRepository.deleteById(id);   
    }


}
