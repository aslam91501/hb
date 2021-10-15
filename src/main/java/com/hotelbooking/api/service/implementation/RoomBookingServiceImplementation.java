package com.hotelbooking.api.service.implementation;

import java.util.List;

import com.hotelbooking.api.entity.RoomBooking;
import com.hotelbooking.api.repository.RoomBookingRepository;
import com.hotelbooking.api.service.RoomBookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomBookingServiceImplementation implements RoomBookingService{
    @Autowired
    private RoomBookingRepository roomBookingRepository;

    @Override
    public void create(RoomBooking roomBooking) {
        roomBookingRepository.save(roomBooking);
    }

    @Override
    public RoomBooking get(Long id) {
        if(roomBookingRepository.existsById(id))
            return roomBookingRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<RoomBooking> getAll() {
        return roomBookingRepository.findAll();
    }

    @Override
    public void update(RoomBooking roomBooking) {
        if(roomBookingRepository.existsById(roomBooking.getId())){
            RoomBooking _roomBooking = roomBookingRepository.findById(roomBooking.getId()).get();

            if(roomBooking.getStartDate() != null && roomBooking.getStartDate() != _roomBooking.getStartDate())
                _roomBooking.setStartDate(roomBooking.getStartDate());
            
            if(roomBooking.getEndDate() != null && roomBooking.getEndDate() != _roomBooking.getEndDate())
                _roomBooking.setEndDate(roomBooking.getEndDate());
            
            if(roomBooking.getRoom() != null && roomBooking.getRoom() != _roomBooking.getRoom())
                _roomBooking.setRoom(roomBooking.getRoom());
        }        
    }

    @Override
    public void delete(Long id) {
        if(roomBookingRepository.existsById(id))
            roomBookingRepository.deleteById(id);
    }
}
