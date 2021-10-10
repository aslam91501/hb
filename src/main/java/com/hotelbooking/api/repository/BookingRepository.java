package com.hotelbooking.api.repository;

import com.hotelbooking.api.entity.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
