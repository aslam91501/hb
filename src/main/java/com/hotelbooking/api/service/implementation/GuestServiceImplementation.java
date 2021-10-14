package com.hotelbooking.api.service.implementation;

import java.util.List;
import java.util.Optional;

import com.hotelbooking.api.entity.Guest;
import com.hotelbooking.api.repository.GuestRepository;
import com.hotelbooking.api.service.GuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImplementation implements GuestService{
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<Guest> getAll(){
        List<Guest> guests = guestRepository.findAll();
        return guests;
    }

    @Override
    public void create(Guest guest){
        guestRepository.save(guest);
    }

    @Override
    public Guest getByPhoneNumber(String phoneNumber) {
        return guestRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public void update(Guest guest) {
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
    public Guest get(Long id) {
        return guestRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        if(guestRepository.existsById(id))
            guestRepository.deleteById(id);   
    }


}
