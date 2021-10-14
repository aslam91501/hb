package com.hotelbooking.api.repository;

import com.hotelbooking.api.entity.RoomBooking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBookingRepository extends JpaRepository<RoomBooking, Long>{
    
}
