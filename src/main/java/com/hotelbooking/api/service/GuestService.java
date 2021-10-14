package com.hotelbooking.api.service;

import java.util.List;

import com.hotelbooking.api.entity.Guest;


public interface GuestService {
    void createGuest(Guest guest);
    List<Guest> getAllGuests();
    Guest findById(Long id);
    Guest findGuestByPhoneNumber(String phoneNumber);
    void updateGuest(Guest guest);
    void deleteGuest(Long id);
}
