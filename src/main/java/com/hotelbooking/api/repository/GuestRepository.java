package com.hotelbooking.api.repository;

import com.hotelbooking.api.entity.Guest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    Guest findByPhoneNumber(String phoneNumber);
}
