package com.hotelbooking.api.service.implementation;

import java.util.List;

import com.hotelbooking.api.entity.Booking;
import com.hotelbooking.api.repository.BookingRepository;
import com.hotelbooking.api.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImplementation implements BookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void create(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Booking get(Long id) {
        return bookingRepository.findById(id).get();
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public void update(Booking booking) {
        if(bookingRepository.existsById(booking.getId())){
            Booking _booking = bookingRepository.getById(booking.getId());

            if(booking.getBill() != null && booking.getBill() != _booking.getBill())
                _booking.setBill(booking.getBill());

            if(booking.getCheckInDate() != null && booking.getCheckInDate() != _booking.getCheckInDate())
                _booking.setCheckInDate(booking.getCheckInDate());
            
            if(booking.getCheckInTime() != null && booking.getCheckInTime() != _booking.getCheckInTime())
                _booking.setCheckInTime(booking.getCheckInTime());

            if(booking.getCheckOutDate() != null && booking.getCheckOutDate() != _booking.getCheckOutDate())
                _booking.setCheckOutDate(booking.getCheckOutDate());
            
            if(booking.getCheckOutTime() != null && booking.getCheckOutTime() != _booking.getCheckOutTime())
                _booking.setCheckOutTime(booking.getCheckOutTime());
            
            if(booking.getGuest() != null && booking.getGuest() != _booking.getGuest())
                _booking.setGuest(booking.getGuest());

        }
    }

    @Override
    public void delete(Long id) {
        if(bookingRepository.existsById(id))
            bookingRepository.deleteById(id);        
    }
    
}
