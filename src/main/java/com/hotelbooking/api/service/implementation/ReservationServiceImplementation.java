package com.hotelbooking.api.service.implementation;

import java.util.List;

import com.hotelbooking.api.entity.Reservation;
import com.hotelbooking.api.repository.ReservationRepository;
import com.hotelbooking.api.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImplementation implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void create(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public Reservation get(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void update(Reservation reservation) {
        if(reservationRepository.existsById(reservation.getId())){
            Reservation _reservation = reservationRepository.getById(reservation.getId());

            if(reservation.getCheckInDate() != null && reservation.getCheckInDate() != _reservation.getCheckInDate())
                _reservation.setCheckInDate(reservation.getCheckInDate());
            
            if(reservation.getCheckInTime() != null && reservation.getCheckInTime() != _reservation.getCheckInTime())
                _reservation.setCheckInTime(reservation.getCheckInTime());

            if(reservation.getCheckOutDate() != null && reservation.getCheckOutDate() != _reservation.getCheckOutDate())
                _reservation.setCheckOutDate(reservation.getCheckOutDate());
            
            if(reservation.getCheckOutTime() != null && reservation.getCheckOutTime() != _reservation.getCheckOutTime())
                _reservation.setCheckOutTime(reservation.getCheckOutTime());
            
            if(reservation.getGuest() != null && reservation.getGuest() != _reservation.getGuest())
                _reservation.setGuest(reservation.getGuest());

            if(reservation.getRoom() != null && reservation.getRoom() != _reservation.getRoom()){
                _reservation.setRoom(reservation.getRoom());
            }

            if(reservation.getStatus() != null && reservation.getStatus() != _reservation.getStatus()){
                _reservation.setStatus(reservation.getStatus());
            }

            reservationRepository.save(_reservation);
        }
    }

    @Override
    public void delete(Long id) {
        if(reservationRepository.existsById(id))
            reservationRepository.deleteById(id);
    }
}
