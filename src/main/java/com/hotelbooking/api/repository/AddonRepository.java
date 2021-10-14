package com.hotelbooking.api.repository;

import com.hotelbooking.api.entity.Addon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddonRepository extends JpaRepository<Addon, Long> {
    
}
